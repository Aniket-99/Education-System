package com.training.educationsystem.exceptions;

public class NotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String message;

	public NotFoundException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "NotFoundException [message=" + message + "]";
	}
     
	
	
}
