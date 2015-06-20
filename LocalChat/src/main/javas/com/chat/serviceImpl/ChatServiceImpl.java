package com.chat.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chat.data.ChatData;
import com.chat.models.User;
import com.chat.service.ChatService;

@Service
public class ChatServiceImpl implements ChatService{
	
	@Autowired
	ChatData chatdata;

	public User getCurrentUser() {
		
		User user = chatdata.getCurrentUser();
		return user;
	}

}
