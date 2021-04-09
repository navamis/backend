package com.onlineadmissionsystem.oas.services;


import java.util.List;

import com.onlineadmissionsystem.oas.entities.College;


public interface ICollegeService {


	
	public College addCollege(College college);
	public List<College> viewAllCollegeDetails();
//	public List<College> getCollegeDetailsByProgram(String programName);
//	public  List<College> getCollegeDetailsByCourse(String courseName);
//	public  List<College> getCollegeDetailsByBranch(String branchName);
	public  College getCollegeDetailsByCollegeName(String collgeName);
	public College deleteCollegeById(int collegeId);
	public College deleteCollegeByName(String collgeName);
	public College  updateCollegeDetails(College college);
	public  College getCollegeDetailsByCollegeRegId(int collegeRegId);
	

}