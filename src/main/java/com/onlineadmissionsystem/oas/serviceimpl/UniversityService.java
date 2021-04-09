package com.onlineadmissionsystem.oas.serviceimpl;

import java.util.ArrayList;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineadmissionsystem.oas.entities.University;
import com.onlineadmissionsystem.oas.exceptions.RecordNotFoundException;
import com.onlineadmissionsystem.oas.repo.IUniversityRepository;
import com.onlineadmissionsystem.oas.services.IUniversityServices;


@Service
public class UniversityService implements IUniversityServices {
	static final Logger log=LoggerFactory.getLogger(UniversityService.class);
	
	@Autowired
	IUniversityRepository unirepo;

	public University addUniversity(University university) {
//		University university=unirepo.
		unirepo.save(university);
		return university;
	}

	@Override
	public ArrayList<University> viewAllUniversityDetails() {
		return new ArrayList<>(unirepo.findAll());
	}
	     

	
	@Override
	public ArrayList<University> getUniversityDetailsBycollegeName(String collegeName) {
	     return unirepo.findByCollegeCollegeName(collegeName);
	}

	@Override
	public void deleteUniversityById(int universityId) throws RecordNotFoundException  {
		{
			 Optional<University> uni4 = unirepo.findById(universityId);
	         
		        if(uni4.isPresent()) 
		        {
		            unirepo.deleteById(universityId);
		        } else {
		            throw new RecordNotFoundException("No employee record exist for given id");
		        }
		    } 
		}
	
	@Override
	public University getUniversityById(int applicationId) {
		Optional<University> uni5= unirepo.findById(applicationId);
		return uni5.get();
	}

	@Override
	public University updateUniversity(University university) {
		{
	        Optional<University> unipres = unirepo.findById(university.getUniversityId());
	         
	        if(unipres.isPresent()) 
	        {
	            University uninew = unipres.get();
	            uninew.setName(university.getName());
	       
	            uninew.setCollege(university.getCollege());
	           	
	            uninew = unirepo.save(uninew);
	             
	            return uninew;
	        } else {
	          university = unirepo.save(university);
	             
	            return university;
	        }
	    } 
     }

}