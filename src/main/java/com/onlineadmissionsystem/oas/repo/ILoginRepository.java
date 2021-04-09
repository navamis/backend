package com.onlineadmissionsystem.oas.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.onlineadmissionsystem.oas.entities.Login;


public interface ILoginRepository  extends JpaRepository<Login, Integer>  {

	Login findByUserId(int userId);

	

}
