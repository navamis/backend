package com.onlineadmissionsystem.oas.exceptions;

public class UserNotFoundException extends RuntimeException{
	public UserNotFoundException() {
	
	}
	
	public UserNotFoundException(String message) {
		super(message);
	}
}