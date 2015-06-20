package com.chat.dataimpl;

import org.springframework.stereotype.Repository;

import com.chat.data.ChatData;
import com.chat.models.User;

@Repository
public class ChatDataImpl implements ChatData{
	
	

	public User getCurrentUser() {
		
		User user = new User(1, "sebin", "sebin7tony@gmail.com");
		return user;
	}

}
