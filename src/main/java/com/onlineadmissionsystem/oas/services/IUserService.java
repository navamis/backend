package com.onlineadmissionsystem.oas.services;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.onlineadmissionsystem.oas.entities.Login;
import com.onlineadmissionsystem.oas.entities.User;

@Service
public interface IUserService {
	

    public User addUserDetails(User user);
    
    public Login addLoginDetails(Login login);
    
    public List<User> getAllUserDetails();
    
    public List<Login> getAllLoginDetails();
    
    public User getUserDetailsById(int userId);
    
    public Login getLoginDetailsById(int userId);
    
    public User deleteUserDetailsById(int userId);
      
    public Login deleteLoginDetailsById(int userId);
    
    public Login changePassword(Login login );
    
    public Login resetPassword(Login login );
    
    public User updateUserDetails(User user);

	
}
