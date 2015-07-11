package com.chat.models;


public class User {
	
	private Integer userid;
	private String username;
	private String email;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
		
	public User(Integer userid, String username, String email) {
		super();
		this.userid = userid;
		this.username = username;
		this.email = email;
	}
	
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
