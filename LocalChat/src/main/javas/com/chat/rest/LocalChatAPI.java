package com.chat.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chat.exceptions.LocalChatExceptions;
import com.chat.models.Drops;
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
	
	@POST
	@Path("/drops")
	@Consumes("application/json")
	@Produces("application/json")
	public Response submitDrops(Drops inputDrop) throws LocalChatExceptions{
		
		if(inputDrop == null){
			
			LocalChatExceptions exceptions = new LocalChatExceptions("Illegal argument", 403, "");
			return Response.ok(exceptions).status(400).build();
		}
		
		try{
			
			Integer dropid = chatService.saveDrops(inputDrop);
			return Response.ok(dropid).status(200).build();
		}
		catch(LocalChatExceptions e){
			
			System.out.println(e);
			return Response.ok(e).status(500).build();
		}
	
	}

}
