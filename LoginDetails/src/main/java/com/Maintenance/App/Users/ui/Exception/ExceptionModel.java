package com.Maintenance.App.Users.ui.Exception;

import java.util.Date;


public class ExceptionModel {
	private Date timeStamp;
	private String message;
	private String details;
	
	
	public Date getTimeStamp() {
		return timeStamp;
	}
	public String getMessage() {
		return message;
	}
	public String getDetails() {
		return details;
	}
	
	
	public ExceptionModel(Date timeStamp, String message,String details) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
		this.details = details;
	}
	
	
	
	


	
	
	
	
	
	

}
