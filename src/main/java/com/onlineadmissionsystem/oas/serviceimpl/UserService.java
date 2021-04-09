package com.onlineadmissionsystem.oas.serviceimpl;


import java.util.ArrayList;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineadmissionsystem.oas.entities.Login;
import com.onlineadmissionsystem.oas.entities.User;
import com.onlineadmissionsystem.oas.exceptions.UserNotFoundException;
import com.onlineadmissionsystem.oas.repo.ILoginRepository;
import com.onlineadmissionsystem.oas.repo.IUserRepository;
import com.onlineadmissionsystem.oas.services.IUserService;

@Service
public class UserService implements IUserService {
	static final Logger log=LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	IUserRepository userRepository;

	@Autowired
	ILoginRepository loginRepository;
	
	/*This method adds user details
	 * @return user
	 */
	@Override
	public User addUserDetails(User user) {
		userRepository.save(user);
		return user;
		}
	

	/*This method adds login details
	 * @return login
	 */
	@Override
	public Login addLoginDetails(Login login) {
		loginRepository.save(login);
		return login;
		}

	
	/*This method gets all user details
	 * @return user
	 */
	@Override
	public ArrayList<User> getAllUserDetails() {

		return new ArrayList<User>(userRepository.findAll());
		}

	
	/*This method  gets all login details
	 * @return login
	 */
	@Override
	public ArrayList<Login> getAllLoginDetails() {

		return new ArrayList<Login>(loginRepository.findAll());
		}
	

	/*This method gets user details by userId
	 * @return user
	 */
	@Override
	public User getUserDetailsById(int userId) {		

		 return userRepository.findByUserId(userId);
	}
	

	/*This method gets login details by userId
	 * @return login
	 */
	@Override
	public Login getLoginDetailsById(int userId) {

		return loginRepository.findByUserId(userId);
		}


	/*This method delete's user details by userId
	 * @return user
	 * @throws UserNotFoundException
	 */
	@Override
	public User deleteUserDetailsById(int userId) {
		Optional<User> user = userRepository.findById(userId);
		if(user.isEmpty()){
			throw new UserNotFoundException("User not found with id : "+userId);
		}
		User u = user.get();
		userRepository.delete(u);
		return u;
	}


	/*This method delete's login details by userId
	 * @return login
	 */
	@Override
	public Login deleteLoginDetailsById(int userId)  {
		Optional<Login> del1 = loginRepository.findById(userId);
		Login l = del1.get();
		loginRepository.delete(l);
		return l;
	}
	
	
	/*This method is to change the password
	 * @return login
	 */
	@Override
	public Login changePassword(Login login) {
		Optional<Login> login3= loginRepository.findById(login.getUserId());
		
		if(login3.isPresent()) {
		Login changePassword = login3.get();
		changePassword.setPassword(login.getPassword());
		loginRepository.save(changePassword);
		}
		return login;
	}

	

	/*This method is to reset the password by userId
	 * @return login
	 */
	@Override
	public Login resetPassword(Login login) {
		Optional<Login> login3 = loginRepository.findById(login.getUserId());
		if(login3.isPresent()) {
			Login resetPassword = login3.get();
     		resetPassword.setPassword(login.getPassword());
    		loginRepository.save(resetPassword);
		}
		return login;	
	}
		
	
	/*This method updates user details
	 * @return user
	 */	
	@Override
	public User updateUserDetails(User user) {
		Optional<User> user3 = userRepository.findById(user.getUserId());
		if(user3.isPresent())
		{
			User adduser = user3.get();
			adduser.setEmail(user.getEmail());
			adduser.setFirstName(user.getFirstName());
			adduser.setMiddleName(user.getMiddleName());
			adduser.setLastName(user.getLastName());
			adduser.setMobileNumber(user.getMobileNumber());
			adduser.setAadharCardNo(user.getAadharCardNo());
			userRepository.save(adduser);
		}
		return user;
	}	
	
}
