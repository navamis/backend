package com.onlineadmissionsystem.oas.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.onlineadmissionsystem.oas.entities.Program;
import com.onlineadmissionsystem.oas.exceptions.AlreadyExistsException;
import com.onlineadmissionsystem.oas.exceptions.ProgramNotFoundException;
import com.onlineadmissionsystem.oas.serviceimpl.ProgramServiceImplementation;

@CrossOrigin(origins="*")
@RestController

public class ProgramController {
	static final Logger log=LoggerFactory.getLogger(ProgramController.class);

	@Autowired
	ProgramServiceImplementation programServiceImplementation;
	
	@PostMapping("/programs")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Program addProgram(@RequestBody Program program) throws AlreadyExistsException {
		programServiceImplementation.addProgram(program);
		return program;
	}
	
	@GetMapping("/programs")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Program> viewAllProgramDetails() throws ProgramNotFoundException {
		return programServiceImplementation.viewAllProgramDetails();
	}
	
	@GetMapping("/programByCollegeName/{collegeName}")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Program> getApplicationDetailsByCollegeName(@PathVariable("collegeName") String collegeName){
		return programServiceImplementation.getApplicationDetailsByCollegeName(collegeName);
	}
	
	@GetMapping("/programByProgramName/{programName}")
	@ResponseStatus(code = HttpStatus.OK)
	public Program getProgramDetailsByName(@PathVariable("programName")String programName) {
		return programServiceImplementation.getProgramDetailsByName(programName);
	}
	
	@GetMapping("/programByEligibility/{eligibility}")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Program> getProgramDetailsByEligibility(@PathVariable("eligibility") String eligibility) {
		return programServiceImplementation.getProgramDetailsByEligibility(eligibility);
	}

	@DeleteMapping("/deleteProgramById/{programId}")
	@ResponseStatus(code = HttpStatus.OK)
	public int deleteProgramById(@PathVariable("programId") int programId) {
		return programServiceImplementation.deleteProgramById(programId);
	}
	
	@DeleteMapping("/deleteProgramByName/{programName}")
	@ResponseStatus(code = HttpStatus.OK)
	public int deleteProgramByName(@PathVariable("programName") String programName) {
		return programServiceImplementation.deleteProgramByName(programName);
	}
	
	@GetMapping("/programById/{programId}")
	@ResponseStatus(code = HttpStatus.OK)
	public Program getProgramById(@PathVariable("programId") int programId) {
		return programServiceImplementation.getProgramById(programId);
	}
	
	@PutMapping("/programs")
	@ResponseStatus(code = HttpStatus.OK)
	@Transactional
	public Program updateProgramStatus(@RequestBody Program program) {
		programServiceImplementation.updateProgramStatus(program);
		return program;
	}
}
