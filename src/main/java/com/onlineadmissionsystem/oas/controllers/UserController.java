package com.onlineadmissionsystem.oas.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.onlineadmissionsystem.oas.entities.User;
import com.onlineadmissionsystem.oas.services.IUserService;

@CrossOrigin(origins="*")
@RestController
public class UserController {
	static final Logger log=LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	IUserService userService;
	
	
	@PostMapping("/users")
	@ResponseStatus(code = HttpStatus.CREATED) 
	public User addUserDetails(@RequestBody User user) {
		userService.addUserDetails(user);
		return user;
	}
	

	@GetMapping("/users")
	@ResponseStatus(code = HttpStatus.OK)
	public List<User> getAllUserDetails(){
		return userService.getAllUserDetails();
		}
	
	
	@GetMapping("/users/{userId}")
	@ResponseStatus(code = HttpStatus.OK)
	public User getUserDetailsById(@PathVariable int userId) {
		return userService.getUserDetailsById(userId);
		}
	
	@DeleteMapping("/users/{userId}")
	@ResponseStatus(code = HttpStatus.OK)
	public void deleteUserDetailsById(@PathVariable int userId) {
		userService.deleteUserDetailsById(userId);
		}

	@PutMapping("/users") 
	@ResponseStatus(code = HttpStatus.OK)
	public User updateUserDetails(@RequestBody User user){
		userService.updateUserDetails(user);
		return user;  
		}
}