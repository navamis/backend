package com.onlineadmissionsystem.oas.exceptions;


public class CollegeNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

public CollegeNotFoundException() {
		
	}
	
	public CollegeNotFoundException(String message) {
		super(message);
	}

}

