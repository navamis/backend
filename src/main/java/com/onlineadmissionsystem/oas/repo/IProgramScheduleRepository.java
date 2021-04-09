package com.onlineadmissionsystem.oas.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlineadmissionsystem.oas.entities.ProgramScheduled;


@Repository
public interface IProgramScheduleRepository extends JpaRepository<ProgramScheduled, Integer> {


	List<ProgramScheduled> findByStartDate(LocalDate date);
	

}
