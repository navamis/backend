package com.onlineadmissionsystem.oas.test;

import java.util.ArrayList;

import javax.persistence.NoResultException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.onlineadmissionsystem.oas.entities.Branch;
import com.onlineadmissionsystem.oas.entities.Course;
import com.onlineadmissionsystem.oas.exceptions.AlreadyExistsException;
import com.onlineadmissionsystem.oas.exceptions.CourseNotFoundException;
import com.onlineadmissionsystem.oas.serviceimpl.CourseServiceImplementation;


@SpringBootTest
class TestCourse {
	
	@Autowired
	CourseServiceImplementation courseServiceImplementation;
	

	@Test
	 void testAddCourse() throws AlreadyExistsException {
		try {
			Branch b1= new Branch("mech", "Computer Science Engineering");
			Branch b2= new Branch("civil","Electronics communication engineering");
			ArrayList<Branch> branches= new ArrayList<Branch>();
			  branches.add(b1);
			  branches.add(b2);

            Course c1=new Course("C++", "7 cgpa",branches);
			Course course1=courseServiceImplementation.addCourse(c1);	
			System.out.println(course1);
		}
		catch(NoResultException e) {
			e.printStackTrace();
		}
	}
	
//	@Test
	public void testViewAllCourseDetails() throws CourseNotFoundException {
		courseServiceImplementation.viewAllCourseDetails();
	}
	
//	@Test
	public void testGetCourseDetailsByCourseName() {
		String name="B Tech";
	    courseServiceImplementation.getCourseDetailsByCourseName(name);
	}
	
//	@Test
	public void testGetCourseDetailsByEligibility() {
		String eligibility="Passed 10+2";
		ArrayList<Course> course=courseServiceImplementation.getCourseDetailsByEligibility(eligibility);
		System.out.println(course);
	}
	
//	@Test
	public void testGetCourseDetailsByCourseId() {
		int id=3;
		Course course=courseServiceImplementation.getCourseDetailsByCourseId(id);
		System.out.println(course);
	}
	
//	@Test
	public void testDeleteCourseById() {
		int id=3;
		courseServiceImplementation.deleteCourseById(id);
		System.out.println("Course deleted");
	}
	
//	@Test
	public void testDeleteCourseByName() {
		String name="B Tech";
		courseServiceImplementation.deleteCourseByName(name);
		System.out.println("Course deleted");
	}
	
//	@Test
	public void testUpdateCourseDetails() {
		Branch b1= new Branch("mech", "Computer Science Engineering");
		Branch b2= new Branch("civil","Electronics communication engineering");
		ArrayList<Branch> branches= new ArrayList<Branch>();
		  branches.add(b1);
		  branches.add(b2);
		Course course=new Course("MS","B Tech",branches);
		courseServiceImplementation.updateCourseDetails(course);
		System.out.println("Course updated");
	}

}
