package com.onlineadmissionsystem.oas.test;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.onlineadmissionsystem.oas.entities.Login;
import com.onlineadmissionsystem.oas.entities.User;
import com.onlineadmissionsystem.oas.repo.ILoginRepository;
import com.onlineadmissionsystem.oas.repo.IUserRepository;
import com.onlineadmissionsystem.oas.services.IUserService;

	@SpringBootTest
	class UserTest {
		
		@Autowired
		IUserRepository userRepository;
		
		@Autowired
	    IUserService userService;
	    
		@Autowired
		ILoginRepository loginRepository;
		
	    User user = new User(100, "Ria", "Ann", "Charles", "ria@gmail.com", "9999999999", "1234 5678 9876");

		Login login = new Login(101,"Ria","password1", "Admin");
		

		
		//@Test
		public void addTest() {
			System.out.println("passed");
		}
		
		@Test
		public void testaddUserDetails() {		
			User user = new User(111, "Ria", "Ann", "Charles", "ria@gmail.com", "9999999999", "1234 5678 9876");
			User u = userService.addUserDetails(user);
			System.out.println(u);
		}
		

		//@Test
		public void testgetAllUserDetails() {
			
			List<User> u = userService.getAllUserDetails();
			System.out.println(u);
		}
		
			
		//@Test
		public void testgetUserDetailsById() {
			userService.getUserDetailsById(111);
		}
		
	    //@Test
		public void testdeleteUserDetailsById() {
			userService.deleteUserDetailsById(115);
		}
			
		//@Test
		public void testupdateUserDetails() {
			userService.updateUserDetails(user);
			}
	//Login Test Cases----------------------------------------------------------------------------------------------------------		
			
		//@Test
		public void testaddLoginDetails() {
			Login login = new Login(101, "Ria","xyz", "Admin");
		    userService.addLoginDetails(login);
			}
		
		
		//@Test
		public void testgetAllLoginDetails() {
			userService.getAllLoginDetails();
		}
		

		//@Test
		public void testgetLoginDetailsById() {
	      userService.getLoginDetailsById(101);		
		}

		
		//@Test
		public void testdeleteLoginDetailsById() {
			userService.deleteLoginDetailsById(20);
			
		}
		
		
		//@Test
		public void testchangePassword() {
			userService.changePassword(login);
		}
		
		
		//@Test
		public void testresetPassword() {
			userService.resetPassword(login);
		}
		
		
		
		
		}