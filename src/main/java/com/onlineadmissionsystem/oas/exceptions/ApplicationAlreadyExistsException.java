package com.onlineadmissionsystem.oas.exceptions;

public class ApplicationAlreadyExistsException extends RuntimeException {
	public ApplicationAlreadyExistsException() {
		
	}
	public ApplicationAlreadyExistsException(String message) {
		super(message);
	}
}


