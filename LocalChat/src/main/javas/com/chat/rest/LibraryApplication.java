package com.chat.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

public class LibraryApplication extends Application{

	private Set<Object> singleton = new HashSet<Object>();
	
	public LibraryApplication() {
		
		singleton.add(new LocalChatAPI());
	}
	
	@Override
	public Set<Object> getSingletons() {
		
		return singleton;
	}
}
