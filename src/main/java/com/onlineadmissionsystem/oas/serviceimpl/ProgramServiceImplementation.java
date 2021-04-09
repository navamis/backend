package com.onlineadmissionsystem.oas.serviceimpl;

import java.util.ArrayList;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineadmissionsystem.oas.entities.Program;
import com.onlineadmissionsystem.oas.exceptions.AlreadyExistsException;
import com.onlineadmissionsystem.oas.exceptions.ProgramNotFoundException;
import com.onlineadmissionsystem.oas.repo.IProgramRepository;
import com.onlineadmissionsystem.oas.services.IProgramService;

@Service
public class ProgramServiceImplementation implements IProgramService{
	static final Logger log=LoggerFactory.getLogger(ProgramServiceImplementation.class);
	
	@Autowired
	IProgramRepository programRepository;

	@Override
	public Program addProgram(Program program) throws AlreadyExistsException {
		Optional<Program> pr=programRepository.findById(program.getProgramId());
		if(pr.isPresent()) {
			throw new AlreadyExistsException("Program " +program.getProgramName()+" already exists");		

		}else {
			programRepository.save(program);
		return program; 
		}
	}

	@Override
	public ArrayList<Program> viewAllProgramDetails() throws ProgramNotFoundException {
		ArrayList<Program> programs = new ArrayList<>(programRepository.findAll());
		if(programs.isEmpty()) {
			throw new ProgramNotFoundException("Program Not Found");
		}
		return programs;
	}

	@Override
	public ArrayList<Program> getApplicationDetailsByCollegeName(String collegeName) {
		return null;
	}

	@Override
	public Program getProgramDetailsByName(String programName) {
		return programRepository.findByProgramName(programName);
	}

	@Override
	public ArrayList<Program> getProgramDetailsByEligibility(String eligibility) {
		return new ArrayList<>(programRepository.findByEligibility(eligibility));
	}

	@Override
	public int deleteProgramById(int programId) {
		Optional<Program> program = programRepository.findById(programId);
		Program pr = null;
		if(program.isPresent()) {
			pr = program.get();
			programRepository.delete(pr);
			return program.get().getProgramId();
		}
		return 0;
	}

	@Override
	public int deleteProgramByName(String programName) {
		Program program = programRepository.findByProgramName(programName);
		if (!(program==null))
		{
				programRepository.delete(program);
				return program.getProgramId();
		}
		return 0;
	}

	@Override
	public Program getProgramById(int programId) {
		Optional<Program> program = programRepository.findById(programId);
		if(program.isPresent()) {
			return program.get();

    }
		return null;
	}

	@Override
	public int updateProgramStatus(Program program) {
		Optional<Program> programFind = programRepository.findById(program.getProgramId());
		Program pr=null;
		if(programFind.isPresent()) {
			pr=programFind.get();
			if(program.getProgramId()!=0) {
				pr.setProgramId(program.getProgramId());
			}
			if(program.getProgramName()!=null) {
				pr.setProgramName(program.getProgramName());
			}
			if(program.getDegreeOffered()!=null) {
				pr.setDegreeOffered(program.getDegreeOffered());
			}
			if(program.getDuration()!=null) {
				pr.setDuration(program.getDuration());
			}
			if(program.getEligibility()!=null) {
				pr.setEligibility(program.getEligibility());
			}
		}
		return 0;
	}

}