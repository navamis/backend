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

import com.onlineadmissionsystem.oas.entities.Course;
import com.onlineadmissionsystem.oas.exceptions.AlreadyExistsException;
import com.onlineadmissionsystem.oas.exceptions.CourseNotFoundException;
import com.onlineadmissionsystem.oas.serviceimpl.BranchServiceImplementation;
import com.onlineadmissionsystem.oas.serviceimpl.CourseServiceImplementation;

@CrossOrigin(origins="*")
@RestController

public class CourseController {
	static final Logger log=LoggerFactory.getLogger(CourseController.class);
	
	@Autowired
	CourseServiceImplementation courseServiceImplementation;
	
	@Autowired
	BranchServiceImplementation branchServiceImplementation;

	@PostMapping("/courses")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Course addCourse(@RequestBody Course course) throws AlreadyExistsException {
		courseServiceImplementation.addCourse(course);
		return course;
	}
	
	@GetMapping("/courses")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Course> viewAllCourseDetails() throws CourseNotFoundException {
		return courseServiceImplementation.viewAllCourseDetails();
	}
	
	@GetMapping("/courseByName/{courseName}")
	@ResponseStatus(code = HttpStatus.OK)
	public Course getCourseDetailsByCourseName(@PathVariable("courseName") String courseName) {
		return courseServiceImplementation.getCourseDetailsByCourseName(courseName);
	}
	
	@GetMapping("/courseByEligibility/{eligibility}")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Course> getCourseDetailsByEligibility(@PathVariable("eligibility") String eligibility) {
		return courseServiceImplementation.getCourseDetailsByEligibility(eligibility);
	}
	
	@GetMapping("/courseById/{courseId}")
	@ResponseStatus(code = HttpStatus.OK)
	public Course getCourseDetailsByCourseId(@PathVariable("courseId") int courseId) {
		return courseServiceImplementation.getCourseDetailsByCourseId(courseId);
	}
	
	@DeleteMapping("/deleteCourseById/{courseId}")
	@ResponseStatus(code = HttpStatus.OK)
	public int deleteCourseById(@PathVariable("courseId") int courseId) {
		return courseServiceImplementation.deleteCourseById(courseId);
	}
	
	@DeleteMapping("/deleteCourseByCourseName/{courseName}")
	@ResponseStatus(code = HttpStatus.OK)
	public int deleteCourseByName(@PathVariable("courseName") String courseName) {
		return courseServiceImplementation.deleteCourseByName(courseName);
	}
	
	@PutMapping("/courses")
	@ResponseStatus(code = HttpStatus.OK)
	@Transactional
	public Course updateCourseDetails(@RequestBody Course course) {
		 courseServiceImplementation.updateCourseDetails(course);
		 return course;
	}
}
