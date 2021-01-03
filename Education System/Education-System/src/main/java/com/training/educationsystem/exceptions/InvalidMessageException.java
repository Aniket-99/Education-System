package com.training.educationsystem.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class InvalidMessageException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public InvalidMessageException(String message) {
		super(message);
	}
}