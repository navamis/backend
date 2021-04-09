package com.onlineadmissionsystem.oas.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlineadmissionsystem.oas.entities.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer>   {

	User findByUserId(int userId);
	
}

