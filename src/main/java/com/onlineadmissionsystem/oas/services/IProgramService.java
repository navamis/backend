package com.onlineadmissionsystem.oas.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.onlineadmissionsystem.oas.entities.Program;
import com.onlineadmissionsystem.oas.exceptions.AlreadyExistsException;
import com.onlineadmissionsystem.oas.exceptions.ProgramNotFoundException;


@Component
public interface IProgramService {
	
	public Program addProgram(Program program) throws AlreadyExistsException;
	
	public List<Program> viewAllProgramDetails() throws ProgramNotFoundException;
	
	public List<Program> getApplicationDetailsByCollegeName(String collegeName);
	
	public Program getProgramDetailsByName(String programName);
	
	public List<Program> getProgramDetailsByEligibility(String eligibility);
	
	public int deleteProgramById(int programId);
	
	public int deleteProgramByName(String programName);
	
	public Program getProgramById(int programId);
	
	public int updateProgramStatus(Program program);
	

}