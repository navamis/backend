package com.onlineadmissionsystem.oas.serviceimpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineadmissionsystem.oas.entities.ProgramScheduled;
import com.onlineadmissionsystem.oas.repo.ICollegeRepository;
import com.onlineadmissionsystem.oas.repo.IProgramScheduleRepository;
import com.onlineadmissionsystem.oas.services.IProgramScheduleService;

@Service
public class ProgramScheduledServiceImplementation implements IProgramScheduleService {
	static final Logger log=LoggerFactory.getLogger(ProgramScheduledServiceImplementation.class);
	
	@Autowired
	IProgramScheduleRepository programScheduleRepository;
	
	@Autowired
	ICollegeRepository collegeRepository;

	@Override
	public ProgramScheduled addProgramSchedule(ProgramScheduled programSchedule) {
		programScheduleRepository.save(programSchedule);
		return programSchedule;
	}

	@Override
	public ArrayList<ProgramScheduled> viewAllProgramScheduleDetails() {
		return new ArrayList<>(programScheduleRepository.findAll());
	}


	@Override
	public List<ProgramScheduled> getProgramScheduleByDate(LocalDate date) {
		return programScheduleRepository.findByStartDate(date);
	}
	
	@Override
	public int deleteProgramScheduleById(int scheduleId) {
		Optional<ProgramScheduled> programScheduled = programScheduleRepository.findById(scheduleId);
		ProgramScheduled pr = null;
		if(programScheduled.isPresent()) {
			pr = programScheduled.get();
			programScheduleRepository.delete(pr);
			return programScheduled.get().getScheduleId();
		}
		return 0;
	}

	@Override
	public ProgramScheduled getProgramScheduleById(int scheduleId) {
		Optional<ProgramScheduled> programScheduled = programScheduleRepository.findById(scheduleId);
		if(programScheduled.isPresent()) {
		return programScheduled.get();
    }
		return null;
	}

	@Override
	public ProgramScheduled updateProgramSchedule(ProgramScheduled programSchedule) {
		Optional<ProgramScheduled> programScheduledFind = programScheduleRepository.findById(programSchedule.getScheduleId());
		if(programScheduledFind.isPresent()) {
			ProgramScheduled prscheduled=programScheduledFind.get();
				prscheduled.setScheduleId(programSchedule.getScheduleId());
				prscheduled.setStartDate(programSchedule.getStartDate());
				prscheduled.setEndDate(programSchedule.getEndDate());
           programScheduleRepository.save(prscheduled);
		}
		return programSchedule;
	}

}

