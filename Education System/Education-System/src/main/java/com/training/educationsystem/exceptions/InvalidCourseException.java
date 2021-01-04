package com.training.educationsystem.exceptions;

public class InvalidCourseException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String str;
	public InvalidCourseException(String message)
	{
		this.str=message;
	}
	@Override
	public String toString() {
		return "InvalidCourseException [" + str + "]";
	}
	
}
