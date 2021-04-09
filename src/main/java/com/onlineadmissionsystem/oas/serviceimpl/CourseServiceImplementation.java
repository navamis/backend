package com.onlineadmissionsystem.oas.serviceimpl;

import java.util.ArrayList;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineadmissionsystem.oas.entities.Branch;
import com.onlineadmissionsystem.oas.entities.Course;
import com.onlineadmissionsystem.oas.exceptions.AlreadyExistsException;
import com.onlineadmissionsystem.oas.exceptions.CourseNotFoundException;
import com.onlineadmissionsystem.oas.repo.ICourseRepository;
import com.onlineadmissionsystem.oas.services.ICourseService;

@Service
public class CourseServiceImplementation implements ICourseService{
	static final Logger log=LoggerFactory.getLogger(CourseServiceImplementation.class);
	
	@Autowired
	ICourseRepository courseRepository;
	
	
	@Override
	public Course addCourse(Course course) throws AlreadyExistsException{
		Optional<Course> cr=courseRepository.findById(course.getCourseId());
		if(cr.isPresent()) {
			throw new AlreadyExistsException("Course " +course.getCourseName()+" already exists");		

		}else {
			courseRepository.save(course);
		return course; 
		}
	}

	@Override
	public ArrayList<Course> viewAllCourseDetails() throws CourseNotFoundException {
		ArrayList<Course> courses = new ArrayList<>(courseRepository.findAll());
		if(courses.isEmpty()) {
			throw new CourseNotFoundException("Course Not Found");
		}
		return courses;
	}

	@Override
	public Course getCourseDetailsByCourseName(String courseName) {
		return courseRepository.findByCourseName(courseName);
		
	}

	@Override
	public ArrayList<Course> getCourseDetailsByEligibility(String eligibility) {
		return new ArrayList<>(courseRepository.findByEligibility(eligibility));
	}

	@Override
	public Course getCourseDetailsByCourseId(int courseId) {
		Optional<Course> course = courseRepository.findById(courseId);
		if(course.isPresent()) {
		return course.get();
    }
		return null;
	}

	@Override
	public int deleteCourseById(int courseId) {
		Optional<Course> course = courseRepository.findById(courseId);
		Course cr = null;
		if(course.isPresent()) {
			cr = course.get();
			courseRepository.delete(cr);
			return course.get().getCourseId();
		}
		return 0;
	}

	@Override
	public int deleteCourseByName(String courseName) {
		Course course = courseRepository.findByCourseName(courseName);
		if (!(course==null))
		{
				courseRepository.delete(course);
				return course.getCourseId();
		}
		return 0;
	}

	@Override
	public int updateCourseDetails(Course course) {
		Optional<Course> courseFind = courseRepository.findById(course.getCourseId());
		Course cr=null;
		if(courseFind.isPresent()) {
			cr=courseFind.get();
			if(course.getCourseId()!=0) {
				cr.setCourseId(course.getCourseId());
			}
			if(course.getCourseName()!=null) {
				cr.setCourseName(course.getCourseName());
			}
			if(course.getEligibility()!=null) {
				cr.setEligibility(course.getEligibility());
			}
			if(course.getBranches()!=null) {
				cr.setBranches((ArrayList<Branch>) course.getBranches());
			}
		}
		return 0;
	}


}
