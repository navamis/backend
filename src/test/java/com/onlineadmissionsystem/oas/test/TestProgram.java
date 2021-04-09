package com.onlineadmissionsystem.oas.test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.onlineadmissionsystem.oas.entities.Program;
import com.onlineadmissionsystem.oas.exceptions.AlreadyExistsException;
import com.onlineadmissionsystem.oas.exceptions.ProgramNotFoundException;
import com.onlineadmissionsystem.oas.serviceimpl.ProgramServiceImplementation;

@SpringBootTest
class TestProgram {

	@Autowired
	ProgramServiceImplementation programServiceImplementation;
	
	@Test
	 void testAddProgram() throws AlreadyExistsException {
		try {
			Program program=new Program("abc","Undergraduate","2 years","M Tech");
			programServiceImplementation.addProgram(program);
		}
		catch(NoResultException e) {
			e.printStackTrace();
		}
	}
	
//	@Test
	public void testViewAllProgramDetails() throws ProgramNotFoundException {
		List<Program> programs=programServiceImplementation.viewAllProgramDetails();
		System.out.println(programs);
	}
	
//	@Test
	public void testGetProgramDetailsByName() {
		String name="MBA";
	    programServiceImplementation.getProgramDetailsByName(name);
	}
	
//	@Test
	public void testGetProgramDetailsByEligibility() {
		String eligibility="Passed 10+2";
		ArrayList<Program> program=programServiceImplementation.getProgramDetailsByEligibility(eligibility);
		System.out.println(program);
	}

//	@Test
	public void testDeleteProgramById() {
		int id=3;
		programServiceImplementation.deleteProgramById(id);
		System.out.println("Course deleted");
	}

//	@Test
	public void testDeleteProgramByName() {
		String name="MBA";
		programServiceImplementation.deleteProgramByName(name);
		System.out.println("Course deleted");
	}
	
//	@Test
	public void testGetProgramById() {
		int id=3;
		Program program=programServiceImplementation.getProgramById(id);
		System.out.println(program);
	}
	
//	@Test
	public void testUpdateProgramStatus() {
		Program program=programServiceImplementation.getProgramById(2);
		program.setDegreeOffered("BBA");
		programServiceImplementation.updateProgramStatus(program);
		System.out.println("Course Updated");
	}
	


}
