package com.onlineadmissionsystem.oas.repo;


import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlineadmissionsystem.oas.entities.University;

@Repository
public interface IUniversityRepository extends JpaRepository<University, Integer>{

	

	ArrayList<University> findByCollegeCollegeName(String collegeName);

	
}
