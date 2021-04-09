package com.onlineadmissionsystem.oas.controllers;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.onlineadmissionsystem.oas.entities.College;
import com.onlineadmissionsystem.oas.repo.ICollegeRepository;
import com.onlineadmissionsystem.oas.serviceimpl.CollegeService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@CrossOrigin(origins="*")
@RestController
public class CollegeController {
	static final Logger log=LoggerFactory.getLogger(CollegeController.class);
	
	@Autowired
	ICollegeRepository collegerepository;
	
	@Autowired
	CollegeService collegeservice;


	
	
	/*
	 * This method adds college
	 * 
	 */
	@PostMapping("/collegeadd")
	@Transactional
	@ApiOperation(value = "Add College", response = College.class)
	public ResponseEntity<College> addCollege(@ApiParam(value = "Add College", required = true) @RequestBody College c) {
		College coll1 = collegeservice.addCollege(c);
		return new ResponseEntity<>(coll1 ,HttpStatus.CREATED);
	}
	

	
	
	/*
	 * Method to view all college Details
	 */
	@GetMapping("/collegeview")
	@ApiOperation(value = "View All College Details",response= College.class)
	public ResponseEntity<ArrayList<College>> viewAllCollegeDetails(){
		log.info("Viewing All College Details");
		ArrayList<College> coll = collegeservice.viewAllCollegeDetails();
		return new ResponseEntity<>(coll,HttpStatus.OK);
	}	
	

	
	
	/*
	 * This method gets college details by college name
	 */
	@GetMapping("/college/getcollege/{collegeName}")
	@ApiOperation(value = "get college details by college name",response= College.class)
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<College> getCollegeDetailsByCollegeName(@PathVariable("collegeName") String collegeName){
		College coll = collegeservice.getCollegeDetailsByCollegeName(collegeName);
		return new ResponseEntity<>(coll,HttpStatus.OK);
	}
	
	
	

	
	/*
	 * This method delete's college by id
	 * @return String
	 */
	@DeleteMapping("/collegeid/{collegeRegId}")
	@ApiOperation(value = "Delete college by Id",notes = "Provide collegeRegId",response= College.class)
	public ResponseEntity<String> deleteCollegeById(
	@ApiParam(value="Id of the college to be deleted",required = true)@PathVariable("collegeRegId")int collegeRegId) {
		collegeservice.deleteCollegeById(collegeRegId);
		return new ResponseEntity<>("Successfully deleted",HttpStatus.OK);
	}
	
	
	

	
	/*
	 * This method delete's college by college name
	 * @returns String
	 */	
	@DeleteMapping("/collegename/{collegeName}")
	@ApiOperation(value = "Delete college by college name",notes = "Provide collegeName",response= College.class)
	public ResponseEntity<String> deleteCollegeByCollegeName(
	@ApiParam(value="Name of the college to be deleted",required = true) @PathVariable("collegeName") String collegeName) {
		collegeservice.deleteCollegeByName(collegeName);
		return new ResponseEntity<>("Successfully deleted",HttpStatus.OK);
	}
	
	
	

	
	/*
	 * This method updates college details by college Id
	 */
	@PutMapping("/collegedetails")
	@ApiOperation(value = "update college details",notes = "Provide collegeRegId",response= College.class)
	public ResponseEntity<String> updateCollegeDetails(
	@ApiParam(value="RegId of the college to be updated",required = true) @RequestBody College college ){
	    collegeservice.updateCollegeDetails(college);
		return new ResponseEntity<>("update successful",HttpStatus.OK);
	}
	
	
	

	
	/*
	 * this method gets college details by college regId
	 * @returns college
	 */
	@GetMapping("/collegebyid/{collegeRegId}")
	@ApiOperation(value = "get college details by college RegId",response= College.class)
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<College> getCollegeDetailsByCollegeRegId(@PathVariable("collegeRegId") int collegeRegId){
		College coll = collegeservice.getCollegeDetailsByCollegeRegId(collegeRegId);
		return new ResponseEntity<>(coll,HttpStatus.OK);
	}
	

	
	
	/*
	 *This method gets college details by program 
	 *@return college 
	 */
//	@GetMapping("/collegeprogram/{programName}")
//	@ApiOperation(value = "get college details by program",response= College.class)
//	@ResponseStatus(code = HttpStatus.OK)
//	public ResponseEntity<ArrayList<College>>getCollegeDetailsByProgram(@PathVariable("programName") String programName){
//		ArrayList<College> coll = collegeservice.getCollegeDetailsByProgram(programName);
//		return new ResponseEntity<>(coll,HttpStatus.OK);
//	}
//	
//	
//
//	
//	/*
//	 * This method gets college details by course name
//	 * @return college
//	 * 
//	 */
//	@GetMapping("/collegecourse/{courseName}")
//	@ApiOperation(value = "get college details by course name",response= College.class)
//	@ResponseStatus(code = HttpStatus.OK)
//	public ResponseEntity<ArrayList<College>> getCollegeDetailsByCourse(@PathVariable("courseName") String courseName){
//		ArrayList<College> coll = collegeservice.getCollegeDetailsByCourse(courseName);
//		return new ResponseEntity<>(coll,HttpStatus.OK);
//	}
//	
//
//	
//	
//	/*
//	 *This method gets college details by branch
//	 *@return college 
//	 */
//	@GetMapping("/collegebranch/{branchName}")
//	@ApiOperation(value = "get college details by branch",response= College.class)
//	@ResponseStatus(code = HttpStatus.OK)
//	public ResponseEntity<ArrayList<College>>getCollegeDetailsByBranch(@PathVariable("branchName") String branchName){
//		ArrayList<College> coll = collegeservice.getCollegeDetailsByBranch(branchName);
//		return new ResponseEntity<>(coll,HttpStatus.OK);
//	}
}