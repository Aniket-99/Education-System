package com.training.educationsystem.exceptions;

import java.util.Date;

public class ErrorMessageDetails {	
	private Date timestamp;
	private String status;
	private String message;
	private String request;
	
	public ErrorMessageDetails(Date timestamp, String status, String message, String string) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.message = message;
		this.request = string;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	
	
}
