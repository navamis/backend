package com.onlineadmissionsystem.oas.entities;

public class Student extends User {

	public Student(int userId, String firstName, String middleName, String lastName, String email, String mobileNumber,
			String aadharCardNo) {
		super(userId, firstName, middleName, lastName, email, mobileNumber, aadharCardNo);
		
	}

}
