package com.onlineadmissionsystem.oas.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.onlineadmissionsystem.oas.entities.Branch;
import com.onlineadmissionsystem.oas.entities.College;
import com.onlineadmissionsystem.oas.entities.Course;
import com.onlineadmissionsystem.oas.entities.Program;
import com.onlineadmissionsystem.oas.entities.ProgramScheduled;
import com.onlineadmissionsystem.oas.entities.University;
import com.onlineadmissionsystem.oas.serviceimpl.ProgramScheduledServiceImplementation;


@SpringBootTest
class TestProgramScheduled {
	
	@Autowired
	ProgramScheduledServiceImplementation programScheduledServiceImplementation;
	
//	@Test
//	void testAddProgramSchedule() {
//		Branch b1= new Branch("mech", "Computer Science Engineering");
//		Branch b2= new Branch("civil","Electronics communication engineering");
//		ArrayList<Branch> branches= new ArrayList<Branch>();
//		  branches.add(b1);
//		  branches.add(b2);
//		  
//	   Program p1=new Program("M.tech", "70% abv", "4 years", "Graduation");
//		    ArrayList<Program> programs= new ArrayList<Program>();
//		    programs.add(p1);
//		    
//	   Address address= new Address("abc","defg","vvv","hij",890,"klmnop");
//		  
//	    Course c1=new Course("C++", "7 cgpa",branches);
//	    ArrayList<Course> courses= new ArrayList<Course>();
//	    courses.add(c1);
//	    
//        
//	    
//	    College college= new College("BMSIT",address ,programs,courses,branches);
//	    ArrayList<College> c=new ArrayList<College>();
//		  c.add(college);
//		  University university=new University("Presi",address,c);
//		
//			ProgramScheduled programScheduled=new ProgramScheduled(b1,c1,p1,college,university, LocalDate.of(2021,03,02),LocalDate.of(2021,03,02));
//			programScheduledServiceImplementation.addProgramSchedule(programScheduled);
//		
//	}
	
//	@Test
	void testViewAllProgramScheduleDetails() {
		List<ProgramScheduled> programScheduled=programScheduledServiceImplementation.viewAllProgramScheduleDetails();
		System.out.println(programScheduled);
	}
	
	
//	@Test
	void testGetProgramScheduleByDate() {
		LocalDate date=LocalDate.of(2021, 03, 07);
		List<ProgramScheduled> pS=programScheduledServiceImplementation.getProgramScheduleByDate(date);
		System.out.println(pS);
	}
	
//	@Test
	void testDeleteProgramScheduleById() {
		int id=1;
		programScheduledServiceImplementation.deleteProgramScheduleById(id);
		System.out.println("Program deleted");
	}
	
//	@Test
	void testGetProgramScheduleById() {
		int id=1;
		ProgramScheduled programSchedule=programScheduledServiceImplementation.getProgramScheduleById(id);
		System.out.println(programSchedule);
	}
	
//	@Test
	void testUpdateProgramSchedule() {
		
		ProgramScheduled programS=programScheduledServiceImplementation.getProgramScheduleById(12);
		programS.setStartDate(LocalDate.of(2021,05,12));
		programScheduledServiceImplementation.updateProgramSchedule(programS);
//		ProgramScheduled programScheduled=new ProgramScheduled(branch,course,program,collegeName, university, LocalDate.of(2021,03,02),LocalDate.of(2021,03,02));
//		programScheduledServiceImplementation.updateProgramSchedule(programScheduled);
		System.out.println("Program scheduled updated");
	}
	
	
}
