package com.onlineadmissionsystem.oas.serviceimpl;

import java.util.ArrayList;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlineadmissionsystem.oas.entities.Branch;
import com.onlineadmissionsystem.oas.entities.College;
import com.onlineadmissionsystem.oas.entities.Course;
import com.onlineadmissionsystem.oas.entities.Program;
import com.onlineadmissionsystem.oas.exceptions.CollegeNotFoundException;
import com.onlineadmissionsystem.oas.repo.IBranchRepository;
import com.onlineadmissionsystem.oas.repo.ICollegeRepository;
import com.onlineadmissionsystem.oas.repo.ICourseRepository;
import com.onlineadmissionsystem.oas.repo.IProgramRepository;
import com.onlineadmissionsystem.oas.services.ICollegeService;



@Service
public class CollegeService implements ICollegeService {
	
	static final Logger log=LoggerFactory.getLogger(CollegeService.class);
	
	@Autowired
	ICollegeRepository collrepo;

	@Autowired
	IProgramRepository prorepo;
	
	@Autowired
	ICourseRepository courrepo;
	
	@Autowired
	IBranchRepository branrepo;
	
	@Override
	public College addCollege(College college) {
		collrepo.save(college);
		return college;
	}

	
	
	@Override
	public ArrayList<College> viewAllCollegeDetails() {
		return new ArrayList<>(collrepo.findAll());
	}



	@Override
	public College getCollegeDetailsByCollegeName(String collegeName) {
		return collrepo.findByCollegeName(collegeName);
	     
	}


	
	
//	@Override
//	public ArrayList<College> getCollegeDetailsByProgram(String programName) {
//		Program program=prorepo.findByProgramName(programName);
//
//		 ArrayList<College> col2 = collrepo.findByProgram(program);
//
//	     return col2;
//	}
//
//	
//	
//	@Override
//	public ArrayList<College> getCollegeDetailsByCourse(String courseName) {
//		
//		Course course = courrepo.findByCourseName(courseName);
//		ArrayList<College> cor3 = collrepo.findByCourse(course);
//	     return cor3;
//	}
//
//	
//	
//	@Override
//	public ArrayList<College> getCollegeDetailsByBranch(String branchName) {
//		
//		Branch branch=branrepo.findByBranchName(branchName);
//	
//	     return collrepo.findByBranch(branch);
//	}

	
	
	@Override
	public College deleteCollegeById(int collegeId) {
		 Optional<College> col6 = collrepo.findById(collegeId);
		 College c =col6.get();
	        if(col6.isPresent()) 
	        {
	        	
	            collrepo.delete(c);
	        } else {
	            throw new CollegeNotFoundException("No College record exist for given id");
	        }
	       return c; 
	    } 
		
	

	@Override
	public College deleteCollegeByName(String collegeName) {
	College col=collrepo.findByCollegeName(collegeName);
	College col1=col;
	collrepo.delete(col1);
	return col1;
	}

	
	
	@Override
	@Transactional
	public College updateCollegeDetails(College college) {
		Optional<College> collpres = collrepo.findById(college.getCollegeRegId());
	        College college1=null; 
	        if(collpres.isPresent())
	        {
	        	
	            college1 = collpres.get();
//	            college1.setCollegeRegId(college.getCollegeRegId());
//	            college1.setCollegeName(college.getCollegeName());
	            college1.setAddress(college.getAddress());
	            collrepo.save(college1);
	        }    
	           return college1;
	       
	}

     



	
	
	@Override
	public College getCollegeDetailsByCollegeRegId(int collegeRegId) {
		return collrepo.findByCollegeRegId(collegeRegId);
	}
	
	
}