package com.onlineadmissionsystem.oas.repo;
import java.util.ArrayList;
//import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlineadmissionsystem.oas.entities.Course;


	

	@Repository
	public interface ICourseRepository extends JpaRepository<Course,Integer>{

		public Course findByCourseName(String courseName);

		ArrayList<Course> findByEligibility(String eligibility);
        

	}

