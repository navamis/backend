package com.onlineadmissionsystem.oas.services;

import java.util.List;

import com.onlineadmissionsystem.oas.entities.Application;


public interface ApplicationService {
public List<Application> viewAllApplicationDetails();
public List<Application> getApplicationDetailsByEmail(String email);
public Application addApplication(Application application);
public List<Application> getApplicationDetailsByStatus(String status);
public int deleteApplicationById(int applicationId);
public int deleteApplicationByEmail(String email);
public Application getApplicationById(int applicationId);
public int updateApplicationStatus(Application app);
}
