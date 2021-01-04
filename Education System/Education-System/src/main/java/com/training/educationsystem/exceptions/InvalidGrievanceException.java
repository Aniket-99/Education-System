package com.training.educationsystem.exceptions;

public class InvalidGrievanceException extends Exception {

/**
 * InvalidInputException
 */
	private static final long serialVersionUID=1L;
	public String message;
	public InvalidGrievanceException(String message) {
		this.message=message;
}
	@Override
	public String toString() {
		return "InvalidGrievanceException [message=" + message + "]";
	}

}
