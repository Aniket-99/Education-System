package com.training.educationsystem.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.educationsystem.exceptions.InvalidAdminException;
import com.training.educationsystem.exceptions.InvalidInputException;
import com.training.educationsystem.services.AdminService;

@RestController
@RequestMapping("/educationsystem/admin")
public class AdminController {
	
	//declaring logger
	private static final Logger logger=LoggerFactory.getLogger(AdminController.class);
	
	//autowiring AdminService service interfaces	 
	@Autowired
	AdminService adminService;
	
	/*
	 * @param adminUername
	 * @param adminPassword
	 * admin logs into the system using user name and password
	 * @return the message successful if the username and password is present in the admin table
	 * throws invalidInputException if the fields are not valid
	 */
	@GetMapping("/admin-login")
	public String adminLogin(@RequestParam("adminUsername") String username,
			@RequestParam("adminPassword") String password) throws InvalidAdminException{
		//logger for admin logging
		logger.info("admin is logging-START");
		
		String pattern = "^[a-zA-Z0-9]*$";
		if (username == "") {
			logger.error("username empty error thrown.....");
			throw new InvalidInputException("Username cannot be null :");
		} if(password == "") {
			logger.error("password empty error thrown.....");
			throw new InvalidInputException("Password cannot be null :");
		}if (!(username.matches(pattern))) {
			logger.error("username not valid error thrown.....");
			throw new InvalidInputException("Username can only contain alphanumeric characters ");
		} if(!(password.matches(pattern))){
			logger.error("password not valid error thrown.....");
			throw new InvalidInputException("Password can only contain alphanumeric characters ");
		}else {
			logger.info("admin logged in successfully-END");
			return adminService.adminLogin(username, password);
		}		
	}

}
