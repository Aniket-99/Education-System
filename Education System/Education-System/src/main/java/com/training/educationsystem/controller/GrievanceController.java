package com.training.educationsystem.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.training.educationsystem.entities.Grievance;
import com.training.educationsystem.exceptions.ErrorDetails;
import com.training.educationsystem.exceptions.InvalidGrievanceException;
import com.training.educationsystem.services.GrievanceService;

@RestController
@RequestMapping("/api/educationsystem/grievance")
public class GrievanceController {
	private static final Logger logger=LogManager.getLogger(GrievanceController.class);
	
	/**
	 * 
	 */
	@Autowired
	private GrievanceService service;
		
/**
*Shows all grievances
*@return list of grievance data
*@throws InvalidGrievanceException 
*/
		@GetMapping("/view-all-grievance")
		public List<Grievance> getAllGrievance() throws InvalidGrievanceException{
			logger.info("Fetching all grievance in grievance controller-START");
			List<Grievance> grievanceList=service.getAllGrievance();
			logger.info("Done in grievance controller-END");
			return grievanceList;
		}
		
/**
*Adds grievance into database
*@param sname
*@param grievance
*@return grievance2
*@throws InvalidGrievanceException
* 
*/
		@PostMapping("/add-grievance")
		public Grievance addGrievance(@RequestParam("sname")String sname,@RequestParam("grievance")String grievance) 
				throws InvalidGrievanceException		{
			logger.info("For adding feedback in controller-START");
			String pattern="^[a-zA-Z0-9]*$";
			String namePattern="^[a-zA-Z]+$"; 
				if (sname=="") {
					logger.error("Name cannot be empty");
					throw new InvalidGrievanceException("name cannot be empty");
				}
				if (!(sname.matches(namePattern))) {
					logger.error("Name cannot contain special symbol and numbers");
					throw new InvalidGrievanceException("sname cannot contain special symbol and numbers");
				}
				if (grievance=="") {
					logger.error("Grievance cannot be empty");
					throw new InvalidGrievanceException("grievance cannot be empty");
				}
				if (!(grievance.matches(pattern))) {
					logger.error("Grievance cannot contain special symbol");
					throw new InvalidGrievanceException("grievance cannot contain special symbol");
				}
				else {
					logger.info("Grievance added succesfully-END");
					return service.addGrievance(sname,grievance);
				}
		}
			@ResponseStatus(HttpStatus.NOT_FOUND)
			@ExceptionHandler(InvalidGrievanceException.class)
			ErrorDetails exceptionHabler(InvalidGrievanceException e)
			{
				return new ErrorDetails("400",e.message); 	
			}
		
		
/**
*Adds reply to the grievance by id of grievance
*@param id
*@param reply
*@return addReply
*@throws InvalidGrievanceException 
* 
*/
		@PatchMapping("/add-reply")
		public Grievance updateGrievanceForReply(@RequestParam("id")int id,@RequestParam("reply")String reply) throws InvalidGrievanceException
		{
			logger.info("Updating reply in grievance controller-START");
			Grievance addReply=service.updateGrievanceForReply(id, reply);
			logger.info("Done in grievance controller-END");
			return addReply;
		}
		
/**
*Shows the reply by id
*@param id
*@return reply
*@throws InvalidGrievanceException 
* 
*/
		@GetMapping("/view-reply/{id}")
		public String viewReply(@PathVariable("id")int id ) throws InvalidGrievanceException
		{
			logger.info("Showing reply in grievance controller-START");
			String reply=service.viewReply(id);
			logger.info("Done in grievance controller-END");
			return reply;
		}
		
	}
