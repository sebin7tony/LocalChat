package com.chat.dataimpl.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.chat.models.Drops;
import com.chat.models.Location;
import com.chat.models.User;

public class RowMapping {
	
	public static List<Drops> dropsMapper(List<Map<String, Object>> rows){
		
		List<Drops> dropList = new ArrayList<Drops>();
		
		for(Map<String, Object> row : rows){
			
			Drops drop = new Drops();
			drop.setDropId((Integer)(row.get("dropid")));
			drop.setDropMsg((String)row.get("dropmsg"));
			
			Location loc = new Location();
			if(row.containsKey("lat")){
				
				loc.setLat((Double)row.get("lat"));
			}
			else{
				
				System.out.println("X(location) not found");
			}
			
			if(row.containsKey("lon")){
				
				loc.setLon((Double)row.get("lon"));
			}
			else{
				
				System.out.println("Y(location) not found");
			}
			
			
			drop.setLocation(loc);
			
			drop.setLikes((Integer)row.get("likes"));
			drop.setDropDate((Date)row.get("drop_date"));
			
			User user = new User();
			user.setUserid((Integer)row.get("userid"));
			drop.setUser(user);
			dropList.add(drop);
		}
		return dropList;
	}

}
