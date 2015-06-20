package com.chat.dataimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.chat.data.ChatData;
import com.chat.models.User;

@Repository
public class ChatDataImpl implements ChatData{
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	public User getCurrentUser() {
		
		String sql = "INSERT INTO tags (tagname) VALUES ('food');";
		jdbcTemplate.update(sql);
		User user = new User(1, "sebin", "sebin7tony@gmail.com");
		return user;
	}

}
