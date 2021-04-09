package com.onlineadmissionsystem.oas.test;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.onlineadmissionsystem.oas.entities.Branch;
import com.onlineadmissionsystem.oas.entities.College;
import com.onlineadmissionsystem.oas.entities.Course;
import com.onlineadmissionsystem.oas.entities.Program;
import com.onlineadmissionsystem.oas.repo.ICollegeRepository;
import com.onlineadmissionsystem.oas.services.ICollegeService;


@SpringBootTest
 class CollegeTest {

	static final Logger log=LoggerFactory.getLogger(CollegeTest.class);
	
		@Autowired
		ICollegeRepository collressrepository;
		
		@Autowired
		ICollegeService collservice;
		
		College college;
		
		
        
       

//		@Test
//		 void Testaddcollege()
//		{
//			Branch b1= new Branch("mech", "Computer Science Engineering");
//			Branch b2= new Branch("civil","Electronics communication engineering");
//			ArrayList<Branch> branches= new ArrayList<Branch>();
//			  branches.add(b1);
//			  branches.add(b2);
//			  
//		   Program p1=new Program("M.tech", "70% abv", "4 years", "Graduation");
//			    ArrayList<Program> programs= new ArrayList<Program>();
//			    programs.add(p1);
//			    
//		   Address address= new Address("abc","defg","vvv","hij",890,"klmnop");
//			  
//		    Course c1=new Course("C++", "7 cgpa",branches);
//		    ArrayList<Course> courses= new ArrayList<Course>();
//		    courses.add(c1);
//		    
//            
//		    
//		    college= new College("BMSIT",address ,programs,courses,branches);
//			
//			collservice.addCollege(college);
//			
//		}
//		
		
		
		//@Test
		 void TestviewAllCollegeDetails()
		{
			collservice.viewAllCollegeDetails();
		}
		
		
		
		//@Test
		 void TestgetCollegeDetailsByName()
		{
			collservice.getCollegeDetailsByCollegeName("Reva");
		}
		
		
		
		//@Test
		 void TestdeleteCollegeById() {
			collservice.deleteCollegeById(31);
		}
		
		
		
		//@Test
		 void TestdeleteCollegeByName() {
			collservice.deleteCollegeByName("BMSIT");
		}
		
		
		
	//	@Test
//		 void TestupdateCollegeDetails()
//		{
//
//			Branch b1= new Branch("mech", "Computer Science Engineering");
//			Branch b2= new Branch("civil","Electronics communication engineering");
//			ArrayList<Branch> branches= new ArrayList<Branch>();
//			  branches.add(b1);
//			  branches.add(b2);
//			  
//		   Program p1=new Program("M.tech", "70% abv", "4 years", "Graduation");
//			    ArrayList<Program> programs= new ArrayList<Program>();
//			    programs.add(p1);
//			    
//		   Address address= new Address("abc","defg","vvv","hij",890,"klmnop");
//			  
//		    Course c1=new Course("C++", "7 cgpa",branches);
//		    ArrayList<Course> courses= new ArrayList<Course>();
//		    courses.add(c1);
//		    
//            
//		    
//		    college= new College("Presidency",address ,programs,courses,branches);
//			
//		collservice.updateCollegeDetails(college);
//			
//		}
		
		
		
		//@Test
		 void TestgetCollegeDetailsById()
		{
			collservice.getCollegeDetailsByCollegeRegId(1);
		}
		
		
	
//		//@Test
//		 void getCollegeDetailsByProgram()
//		{
//			collservice.getCollegeDetailsByProgram("B.tech");
//		}
//		
//		
//		
//		//@Test
//		 void getCollegeDetailsByBranch()
//		{
//			collservice.getCollegeDetailsByBranch("CSE");
//		}
//		
//		
//		
//		//@Test
//		 void getCollegeDetailsByCourse()
//		{
//			collservice.getCollegeDetailsByCourse("C");
//		}
		
}