package com.onlineadmissionsystem.oas.services;

import java.util.List;

import com.onlineadmissionsystem.oas.entities.University;

public interface IUniversityServices 
{
	public University addUniversity(University university);
	
	public List<University> viewAllUniversityDetails();
	
	
	public List<University> getUniversityDetailsBycollegeName(String collegeName);
	
	public void deleteUniversityById(int universityId);
	
	public University getUniversityById(int applicationId);
	
	public University updateUniversity(University university);

}
