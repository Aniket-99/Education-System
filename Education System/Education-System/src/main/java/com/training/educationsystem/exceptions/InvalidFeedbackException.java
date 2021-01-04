package com.training.educationsystem.exceptions;

public class InvalidFeedbackException extends Exception {

/**
 * InvalidInputException
 */
	private static final long serialVersionUID=1L;
	public String message;
	public InvalidFeedbackException(String message) {
		this.message=message;
}
	@Override
	public String toString() {
		return "InvalidFeedbackException [message=" + message + "]";
	}
	
}
