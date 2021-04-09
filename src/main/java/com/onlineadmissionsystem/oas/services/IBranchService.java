package com.onlineadmissionsystem.oas.services;


import java.util.List;

import org.springframework.stereotype.Component;

import com.onlineadmissionsystem.oas.entities.Branch;
import com.onlineadmissionsystem.oas.exceptions.AlreadyExistsException;


@Component
public interface IBranchService {
	
	public Branch addBranch(Branch branch) throws AlreadyExistsException;
	
	public List<Branch> viewAllBranchDetails();
	
	public Branch getBranchDetailsByName(String branchName);
	
	public int deleteBranchById(int branchId);
	
	public Branch getBranchById(int branchId);
	
	public int deleteBranchByName(String branchName);
	
	public int updateBranch(Branch branch);


}