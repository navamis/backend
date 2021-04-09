package com.onlineadmissionsystem.oas.repo;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlineadmissionsystem.oas.entities.Branch;


@Repository
public interface IBranchRepository extends JpaRepository<Branch,Integer>{
	
    public Branch findByBranchName(String branchName);
    

	public Branch findByBranchId(int branchId);

}