package com.chat.models;

import java.util.Date;

public class Drops {
	
	private Integer dropId;
	private String dropMsg;
	private Location location;
	private Integer likes;
	private Date dropDate;
	private User user;
	
	public Drops() {
		
	}
	
	public Drops(String dropMsg, Location location, int likes, Date dropDate,
			User user) {
		super();
		this.dropMsg = dropMsg;
		this.location = location;
		this.likes = likes;
		this.dropDate = dropDate;
		this.user = user;
	}

	public Drops(int dropId, String dropMsg, Location location, int likes,
			Date dropDate, User user) {
		super();
		this.dropId = dropId;
		this.dropMsg = dropMsg;
		this.location = location;
		this.likes = likes;
		this.dropDate = dropDate;
		this.user = user;
	}

	public Integer getDropId() {
		return dropId;
	}
	public void setDropId(Integer dropId) {
		this.dropId = dropId;
	}
	public String getDropMsg() {
		return dropMsg;
	}
	public void setDropMsg(String dropMsg) {
		this.dropMsg = dropMsg;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public Integer getLikes() {
		return likes;
	}
	public void setLikes(Integer likes) {
		this.likes = likes;
	}
	public Date getDropDate() {
		return dropDate;
	}
	public void setDropDate(Date dropDate) {
		this.dropDate = dropDate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
