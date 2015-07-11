package com.chat.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chat.data.ChatData;
import com.chat.exceptions.LocalChatExceptions;
import com.chat.models.Drops;
import com.chat.models.User;
import com.chat.service.ChatService;


public class ChatServiceImpl implements ChatService{
	
	ChatData chatdata;

	public ChatData getChatdata() {
		return chatdata;
	}

	public void setChatdata(ChatData chatdata) {
		this.chatdata = chatdata;
	}

	public User getCurrentUser() {
		
		User user = chatdata.getCurrentUser();
		return user;
	}

	public Integer saveDrops(Drops inputDrop) throws LocalChatExceptions {
		
		if(inputDrop.getDropMsg() == null && inputDrop.getLocation() != null
				&& inputDrop.getLikes() == null && inputDrop.getDropDate() == null
				&& inputDrop.getUser() == null){
			
			throw new LocalChatExceptions("Error in input", 453, "");
		}
		
		Integer dropid = chatdata.saveDrops(inputDrop);
		return dropid;
	}

	public List<Drops> getAllDropsData() throws LocalChatExceptions {
		
		return chatdata.getAllDropsData();
	}

}
