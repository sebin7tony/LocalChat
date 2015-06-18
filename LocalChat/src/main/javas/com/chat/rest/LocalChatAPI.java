package com.chat.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

@Path("/v1")
@Component
public class LocalChatAPI {
	
	@GET
	@Path("/post")
	@Produces("application/json")
	public Response getPost(){
		
		return Response.ok("Everything is working fine i guess !!").build();
	}

}
