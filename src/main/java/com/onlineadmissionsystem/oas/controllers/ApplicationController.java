package com.onlineadmissionsystem.oas.controllers;

import java.util.ArrayList;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.onlineadmissionsystem.oas.entities.Application;
import com.onlineadmissionsystem.oas.serviceimpl.ApplicationServiceImplementation;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins="*")
@RestController
public class ApplicationController {
	static final Logger log=LoggerFactory.getLogger(ApplicationController.class);
	
	@Autowired
	ApplicationServiceImplementation applicationServiceImplementation;
	

	@GetMapping(value="/Application")
	public List<Application> viewAllApplicationDetails(){
	 return	applicationServiceImplementation.viewAllApplicationDetails();
	}
	
	@GetMapping(value="/Application/{email}")
	public List<Application> getApplicationDetailsByEmail(@PathVariable("email")String email){
		return applicationServiceImplementation.getApplicationDetailsByEmail(email);
	}
	
	@PostMapping(value="/Application")
	public Application addApplication(@RequestBody Application application) {
		return applicationServiceImplementation.addApplication(application);
	}
	
	/*
	 * This method gets application details by Status
	 * @returns application
	 */
	@GetMapping("/ApplicationS/{Status}")
	@ApiOperation(value = "get Application Status",response= Application.class)
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<ArrayList<Application>> getApplicationDetailsByStatus(@PathVariable("Status")String status){
		ArrayList<Application> application = applicationServiceImplementation.getApplicationDetailsByStatus(status);
		return new ResponseEntity<>(application,HttpStatus.OK);
	}

	
	@DeleteMapping(value="/ApplicationI/{Id}")
	public int deleteApplicationById(@PathVariable("Id")int applicationId) {
		return applicationServiceImplementation.deleteApplicationById(applicationId);
	}
	
	@DeleteMapping(value="/ApplicationE/{email}" )
	 public int deleteApplicationByEmail(@PathVariable("email")String email) {
		return applicationServiceImplementation.deleteApplicationByEmail(email);
	}
	@GetMapping(value="/ApplicationI/{Id}")
	public Application getApplicationById(@PathVariable("Id")int applicationId) {
		return applicationServiceImplementation.getApplicationById(applicationId);
	}
	@PostMapping(value="/ApplicationU")
	public int updateApplicationStatus(@RequestBody Application app) {
		return applicationServiceImplementation.updateApplicationStatus(app);
	}

	
}