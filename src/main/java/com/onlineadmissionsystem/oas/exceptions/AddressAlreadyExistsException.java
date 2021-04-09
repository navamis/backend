package com.onlineadmissionsystem.oas.exceptions;

public class AddressAlreadyExistsException extends RuntimeException{

	private static final long serialVersionUID = 1L;

		public AddressAlreadyExistsException() {
	}
	
	public AddressAlreadyExistsException(String message) {
		super(message); 

}
}