package com.chat.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chat.models.User;
import com.chat.service.ChatService;

@Path("/v1")
@Component
public class LocalChatAPI {
	
	@Autowired
	ChatService chatService;
	
	@GET
	@Path("/user")
	@Produces("application/json")
	public Response getCurrentUser(){
		
		User user = chatService.getCurrentUser();
		return Response.ok(user).build();
	}

}
