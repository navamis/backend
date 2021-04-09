package com.onlineadmissionsystem.oas.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlineadmissionsystem.oas.entities.Branch;
import com.onlineadmissionsystem.oas.entities.College;
import com.onlineadmissionsystem.oas.entities.Course;
import com.onlineadmissionsystem.oas.entities.Program;


@Repository
public interface ICollegeRepository extends JpaRepository<College, Integer>  {
	
	
	
	
//	ArrayList<College> findByCourse(Course course);
//
//	ArrayList<College> findByProgram(Program program);
//
//	ArrayList<College> findByBranch(Branch branch);

	College findByCollegeName(String collegeName);

	College findByCollegeRegId(int collegeRegId);



	

}