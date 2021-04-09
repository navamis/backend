package com.onlineadmissionsystem.oas.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlineadmissionsystem.oas.entities.Application;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Integer>{
public List<Application> findByEmailId(String emailId);
public List<Application> findByApplicationStatus(String applicationStatus);
public List<Application> findByApplicationId(int applicationId);
}
