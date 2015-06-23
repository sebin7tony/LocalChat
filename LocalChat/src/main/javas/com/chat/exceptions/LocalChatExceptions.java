package com.chat.exceptions;

public class LocalChatExceptions extends Exception{

	private String msg;
	private Integer errorcode;
	private String description;
	
	public LocalChatExceptions(String msg, Integer errorcode, String description) {
		super();
		this.msg = msg;
		this.errorcode = errorcode;
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Integer getErrorcode() {
		return errorcode;
	}
	public void setErrorcode(Integer errorcode) {
		this.errorcode = errorcode;
	}
	
}
