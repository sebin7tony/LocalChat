package com.chat.models;

public class Location {
	
	private Float lat;
	private Float lon;
	
	public Location() {
		
	}
	
	public Location(float lat, float lon) {
		
		this.lat = lat;
		this.lon = lon;
	}
	
	public float getLat() {
		return lat;
	}
	public void setLat(float lat) {
		this.lat = lat;
	}
	public float getLon() {
		return lon;
	}
	public void setLon(float lon) {
		this.lon = lon;
	}
	
	

}
