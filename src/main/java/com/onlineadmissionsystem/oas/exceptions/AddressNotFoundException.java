package com.onlineadmissionsystem.oas.exceptions;


public class AddressNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

public AddressNotFoundException() {
		
	}
	
	public AddressNotFoundException(String message) {
		super(message);
	}

}

