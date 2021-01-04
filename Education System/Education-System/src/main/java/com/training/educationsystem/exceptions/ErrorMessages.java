package com.training.educationsystem.exceptions;

public class ErrorMessages {

   private String status;
	private String message;
	
	
	public ErrorMessages(String status, String message) {
		super();
		this.status = status;
		this.message = message;
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
	
	
	
}
