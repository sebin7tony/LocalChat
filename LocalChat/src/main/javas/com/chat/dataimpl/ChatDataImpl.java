package com.chat.dataimpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.chat.data.ChatData;
import com.chat.dataimpl.util.RowMapping;
import com.chat.exceptions.LocalChatExceptions;
import com.chat.models.Drops;
import com.chat.models.User;
import com.mysql.jdbc.Statement;


public class ChatDataImpl implements ChatData{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	

	public User getCurrentUser() {
		
		User user = new User(1, "sebin", "sebin7tony@gmail.com");
		return user;
	}

	public Integer saveDrops(Drops inputDrop) throws LocalChatExceptions {
	
		KeyHolder keyHolder = new GeneratedKeyHolder();
		try{
			final String sql = "INSERT INTO drops (dropmsg,location,likes,drop_date,userid) VALUES ('"
					+inputDrop.getDropMsg()+"',GeomFromText('POINT("
					+inputDrop.getLocation().getLat()+" "
					+inputDrop.getLocation().getLon()+")'),"
					+inputDrop.getLikes()+",'"
					+new Date(inputDrop.getDropDate().getTime())+"',"
					+inputDrop.getUser().getUserid()+")";
			
			
			jdbcTemplate.update(new PreparedStatementCreator() {
				
				public PreparedStatement createPreparedStatement(Connection connection)
						throws SQLException {
					
					 PreparedStatement ps = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
					return ps;
				}
			},keyHolder);
			
		}
		catch(DataAccessException e){
			
			System.out.println(e);
			throw new LocalChatExceptions(e.getMessage(), 532, "database problem");
		}
		
		System.out.println("key value "+keyHolder.getKey().intValue());
		return keyHolder.getKey().intValue();
	}

	public List<Drops> getAllDropsData() throws LocalChatExceptions{
		
		String sql = "select dropid,dropmsg,X(location) as lat,Y(location) as lon,likes,drop_date,userid from drops";
		List<Map<String, Object>> queryList = null;
		try{
			
			queryList = jdbcTemplate.queryForList(sql);
		}
		catch(DataAccessException e){
			
			System.out.println(e);
			throw new LocalChatExceptions(e.getMessage(), 532, "Database problem");
		}
		 
		List<Drops> dropsList = RowMapping.dropsMapper(queryList);
		return dropsList;
	}

}
