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
public class LocalChatAPI {
	

	ChatService chatService;
	
	public ChatService getChatService() {
		return chatService;
	}

	public void setChatService(ChatService chatService) {
		this.chatService = chatService;
	}
	
	
	@GET
	@Path("/user")
	@Produces("application/json")
	public Response getCurrentUser(){
		
		if(chatService == null){
			
			System.out.println("what is this happening !!");
		}
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
		
		System.out.println("enthonnu koppade ethu");
		if(chatService == null){
			
			System.out.println("Enne kollu !! Spring gone mad !");
			return null;
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
	
	@GET
	@Path("/drops")
	@Produces("application/json")
	public Response getAllDrops(){
		
		if(chatService == null){
			
			System.out.println("Enne kollu !! Spring gone mad !");
			return null;
		}
		
		try {
			return Response.ok(chatService.getAllDropsData()).build();
		} catch (LocalChatExceptions e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			return Response.ok(e).status(500).build();
		}
	}

}
