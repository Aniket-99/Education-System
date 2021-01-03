package com.training.educationsystem.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class InvalidAdminException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public InvalidAdminException(String message) {
		super(message);
	}
}