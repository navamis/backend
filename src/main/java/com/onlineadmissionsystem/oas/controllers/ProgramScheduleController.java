package com.onlineadmissionsystem.oas.controllers;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import com.onlineadmissionsystem.oas.entities.ProgramScheduled;
import com.onlineadmissionsystem.oas.repo.IProgramScheduleRepository;
import com.onlineadmissionsystem.oas.serviceimpl.CollegeService;
import com.onlineadmissionsystem.oas.serviceimpl.ProgramScheduledServiceImplementation;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@CrossOrigin(origins="*")
@RestController

public class ProgramScheduleController {
	static final Logger log=LoggerFactory.getLogger(ProgramScheduleController.class);

	/*
	 * add @return values and @param if needed
	 */
	@Autowired
	CollegeService collegeService;
	@Autowired
	IProgramScheduleRepository programScheduleRepository;
	@Autowired
	ProgramScheduledServiceImplementation programScheduledServiceImplementation;
	

	/*
	 * This method adds college
	 * 
	 */
	@PostMapping("/programScheduled")
	@Transactional
	@ApiOperation(value = "Add ProgramScheduled", response = ProgramScheduled.class)
	public ResponseEntity<ProgramScheduled> addProgramSchedule(@ApiParam(value = "Add ProgramScheduled", required = true) @RequestBody ProgramScheduled pS) {
		ProgramScheduled programScheduled = programScheduledServiceImplementation.addProgramSchedule(pS);
		return new ResponseEntity<>(programScheduled ,HttpStatus.CREATED);
	}
	
	
	/*
	 * Method to view all college Details
	 */
	@GetMapping("/programScheduled")
	@ApiOperation(value = "View All ProgramScheduled Details",response= ProgramScheduled.class)
	public ResponseEntity<ArrayList<ProgramScheduled>> viewAllProgramScheduleDetails(){
		ArrayList<ProgramScheduled> programScheduled = programScheduledServiceImplementation.viewAllProgramScheduleDetails();
		return new ResponseEntity<>(programScheduled,HttpStatus.OK);
	}
	
	
	
	/*
	 * this method gets programSchedule details By Date
	 * @returns programSchedule
	 */
	@GetMapping("/programScheduledByDate/{date}")
	@ApiOperation(value = "get ProgramScheduled details by date",response= ProgramScheduled.class)
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<ProgramScheduled> getProgramScheduleByDate(@PathVariable("date") LocalDate date){
		ProgramScheduled pS = (ProgramScheduled) programScheduledServiceImplementation.getProgramScheduleByDate(date);
		return new ResponseEntity<>(pS,HttpStatus.OK);
	}
	
	
	/*
	 * This method delete's delete ProgramScheduled By Id
	 * @returns programSchedule
	 */	
	@DeleteMapping("/deleteProgramScheduledById/{scheduleId}")
	@ApiOperation(value = "Delete ProgramScheduled by scheduleId",notes = "Provide scheduleId",response= ProgramScheduled.class)
	public ResponseEntity<String> deleteProgramScheduleById(
	@ApiParam(value="Name of the college to be deleted",required = true) @PathVariable("scheduleId") int scheduleId) {
		programScheduledServiceImplementation.deleteProgramScheduleById(scheduleId);
		return new ResponseEntity<>("Successfully deleted",HttpStatus.OK);
	}
	

	/*
	 * this method gets programSchedule details By scheduleId
	 * @returns programSchedule
	 */
	@GetMapping("/programScheduledById/{scheduleId}")
	@ApiOperation(value = "get ProgramScheduled details by scheduleId",response= ProgramScheduled.class)
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<ProgramScheduled> getProgramScheduleByDate(@PathVariable("scheduleId") int scheduleId){
		ProgramScheduled pS = programScheduledServiceImplementation.getProgramScheduleById(scheduleId);
		return new ResponseEntity<>(pS,HttpStatus.OK);
	}

	/*
	 * This method updates programSchedules details by scheduleId
	 */
	@PutMapping("/programScheduled")
	@ApiOperation(value = "update programScheduled details",notes = "Provide scheduleId",response= ProgramScheduled.class)
	public ResponseEntity<ProgramScheduled> updateProgramSchedule(
	@ApiParam(value="RegId of tht ProgramScheduled to be updated",required = true) @RequestBody ProgramScheduled programScheduled) {
		programScheduledServiceImplementation.updateProgramSchedule(programScheduled);
		return new ResponseEntity<>(programScheduled,HttpStatus.OK);
	}
}