package com.onlineadmissionsystem.oas.exceptions;

public class StudentException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	public StudentException() {
	
	}
	public StudentException(String message) {
		super(message);
	}
}
