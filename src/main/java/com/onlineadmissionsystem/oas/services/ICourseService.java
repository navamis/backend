package com.onlineadmissionsystem.oas.services;


import java.util.List;

import org.springframework.stereotype.Component;

import com.onlineadmissionsystem.oas.entities.Course;
import com.onlineadmissionsystem.oas.exceptions.AlreadyExistsException;
import com.onlineadmissionsystem.oas.exceptions.CourseNotFoundException;



@Component
public interface ICourseService {
	
	public Course addCourse(Course course) throws AlreadyExistsException;
	
	public List<Course> viewAllCourseDetails() throws CourseNotFoundException;
	
	public Course getCourseDetailsByCourseName(String courseName);
	
	public List<Course> getCourseDetailsByEligibility(String eligibility);
	
	public Course getCourseDetailsByCourseId(int courseId);
	
	public int deleteCourseById(int courseId);
	
	public int deleteCourseByName(String courseName);
	
	public int updateCourseDetails(Course course);
	
}
