package com.onlineadmissionsystem.oas.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Component;

import com.onlineadmissionsystem.oas.entities.ProgramScheduled;


@Component
public interface IProgramScheduleService {
	
	public ProgramScheduled addProgramSchedule(ProgramScheduled programschedule);
	
	public List<ProgramScheduled> viewAllProgramScheduleDetails();
	
	public List<ProgramScheduled> getProgramScheduleByDate(LocalDate date);
	
	public int deleteProgramScheduleById(int scheduleId);
	
	public ProgramScheduled getProgramScheduleById(int scheduleId);
	
	public ProgramScheduled updateProgramSchedule(ProgramScheduled programSchedule);

}
