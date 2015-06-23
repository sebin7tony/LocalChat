package com.chat.service;

import com.chat.exceptions.LocalChatExceptions;
import com.chat.models.Drops;
import com.chat.models.User;

public interface ChatService {

	public User getCurrentUser();
	
	public Integer saveDrops(Drops inputDrop) throws LocalChatExceptions;
}
