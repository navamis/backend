package com.onlineadmissionsystem.oas.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlineadmissionsystem.oas.entities.Application;
import com.onlineadmissionsystem.oas.exceptions.DeletionException;
import com.onlineadmissionsystem.oas.exceptions.StudentNotFoundException;
import com.onlineadmissionsystem.oas.repo.ApplicationRepository;
import com.onlineadmissionsystem.oas.services.ApplicationService;

@Service
public class ApplicationServiceImplementation implements ApplicationService {
	static final Logger log=LoggerFactory.getLogger(ApplicationServiceImplementation.class);
@Autowired
ApplicationRepository applicationRepository;



	@Override
	public ArrayList<Application> viewAllApplicationDetails() {
		return new ArrayList<>(applicationRepository.findAll());
	
		 
	}

	@Override
	public ArrayList<Application> getApplicationDetailsByEmail(String email) {
		
		ArrayList<Application> applications = new ArrayList<>(applicationRepository.findByEmailId(email));
		if(applications.isEmpty()) {
			throw new StudentNotFoundException("Data Not Found");
			}
		return applications;
	}

	@Override
	public Application addApplication(Application application) {

			applicationRepository.save(application);

		return application;
	}

	@Override
	public ArrayList<Application> getApplicationDetailsByStatus(String status) {
		ArrayList<Application> applications = new ArrayList<>(applicationRepository.findByApplicationStatus(status));
		if(applications.isEmpty()) {
			throw new StudentNotFoundException("Status Not Found");
			}
		return applications;
		
	}

	@Override
	public int deleteApplicationById(int applicationId) {
		Optional<Application> application = applicationRepository.findById(applicationId);
		if(application.isEmpty()) {
			throw new DeletionException("Application Does not Exist");
		 }
		else if(application.isPresent())
		{
			applicationRepository.delete(application.get());
			return application.get().getApplicationId();
		}
		return 0;
	}

	@Override
	public int deleteApplicationByEmail(String email) {
		List<Application> applications = applicationRepository.findByEmailId(email);
		if(applications.isEmpty()) {
			throw new DeletionException("Application Does not Exist");
		 }
		if (!applications.isEmpty())
		{
			for(Application application: applications)
			{
				applicationRepository.delete(application);
				return application.getApplicationId();
			}
		}
		return 0;
	}

	@Override
	public Application getApplicationById(int applicationId) {
		Optional<Application> application = applicationRepository.findById(applicationId);
		if(application.isEmpty()) {
			throw new StudentNotFoundException("Status Not Found");
			}
		return application.get();
	}

	@Override
	@Transactional
	public int updateApplicationStatus(Application app) {
		Optional<Application> applicationFind = applicationRepository.findById(app.getApplicationId());
		Application application =null;
		if (applicationFind.isPresent())
		{
			application = applicationFind.get();
			if(app.getApplicantFullName()!=null)
			{
				application.setApplicantFullName(app.getApplicantFullName());
				
			}
			if(app.getDateOfBirth()!=null)
			{
				application.setDateOfBirth(app.getDateOfBirth());
			}
			if(app.getHighestQualification()!=null)
			{
				application.setHighestQualification(app.getHighestQualification());
				
			}
			if(app.getFinalYearPercentage()!=0)
			{
				application.setFinalYearPercentage(app.getFinalYearPercentage());
				
			}
			if(app.getGoals()!=null)
			{
				application.setGoals(app.getGoals());
			}
			if(app.getEmailId()!=null)
			{
				application.setEmailId(app.getEmailId());
			}
			if(app.getSchedule()!=null)
			{
				application.setSchedule(app.getSchedule());
			}
			if(app.getApplicationStatus()!=null)
			{
				application.setApplicationStatus(app.getApplicationStatus());
			}
			if(app.getDateOfInterview()!=null)
			{
				application.setDateOfInterview(app.getDateOfInterview());
			}
			if(app.getApplicantInterviewFeedback()!=null)
			{
				application.setApplicantInterviewFeedback(app.getApplicantInterviewFeedback());
			}
			return application.getApplicationId();
		}
		return 0;
	}

}
