package com.training.educationsystem.services;


/**
 * admin service interface to declare all the methods
 * @author Aniket
 *
 */
public interface AdminService {
	
	/**
	 * 
	 * @param adminUsername
	 * @param adminPassword
	 * @return String
	 */
	 String adminLogin(String adminUsername,String adminPassword); 

}
