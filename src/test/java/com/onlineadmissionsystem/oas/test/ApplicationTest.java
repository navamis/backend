package com.onlineadmissionsystem.oas.test;

import java.time.LocalDate;

import javax.persistence.NoResultException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.onlineadmissionsystem.oas.entities.Application;
import com.onlineadmissionsystem.oas.entities.Branch;
import com.onlineadmissionsystem.oas.entities.College;
import com.onlineadmissionsystem.oas.entities.Course;
import com.onlineadmissionsystem.oas.entities.Program;
import com.onlineadmissionsystem.oas.entities.ProgramScheduled;
import com.onlineadmissionsystem.oas.entities.University;
import com.onlineadmissionsystem.oas.serviceimpl.ApplicationServiceImplementation;

@SpringBootTest
class ApplicationTest {

	Branch branch;
	Course course;
	Program program;
	College collegeName;
	University university;
	
	@Autowired
	ApplicationServiceImplementation applicationServiceImplementation;
//	@Test 
	void testViewAllApplicationDetails() {
		
		applicationServiceImplementation.viewAllApplicationDetails();
	}
	
	//@Test
	void testGetApplicationDetailsByEmail() {
		String email ="em";
		applicationServiceImplementation.getApplicationDetailsByEmail(email);
	}
	
	@Test
	void testAddApplication() {
try {
			
			ProgramScheduled programScheduled=new ProgramScheduled(branch,course,program,collegeName,university, LocalDate.of(2021,03,02),LocalDate.of(2021,03,02));
			Application application = new Application("abc",  LocalDate.of(2021,03,01),"agd" , 7.0, "ajshd", "jjhsaj", programScheduled, "asb",LocalDate.of(2021,03,01), "sajhg");
			applicationServiceImplementation.addApplication(application);
			System.out.println("application added");
		}
		catch(NoResultException e) {
			e.printStackTrace();
		}
	}
		
	//@Test
	void testGetApplicationDetailsByStatus() {
		String status="st";
		applicationServiceImplementation.getApplicationDetailsByStatus(status);
		
	}
	//@Test
	void testDeleteApplicationById() {
		int applicationId=1;
		applicationServiceImplementation.deleteApplicationById(applicationId);
		System.out.println("Succesfully deleted");
		
	}
	
	//@Test
	void testDeleteApplicationByEmail() {
		String email="axy@domain.com";
		applicationServiceImplementation.deleteApplicationByEmail(email);
		System.out.println("Deleted Application Succesfully By Email ID");
	}
	
	//@Test
	void testGetApplicationById() {
		int applicationId=2;
		System.out.println(applicationServiceImplementation.getApplicationById(applicationId));
		
		
	}
	//@Test
	void testUpdateApplicationStatus() {
		Application application = new Application(2,"PAHDBJ", null, null, 0, null, null, null, null, null, null);
		applicationServiceImplementation.updateApplicationStatus(application);
	}
	
		
		
	
	
}
