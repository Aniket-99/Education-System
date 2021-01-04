package com.training.educationsystem.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.training.educationsystem.entities.Feedback;
import com.training.educationsystem.exceptions.ErrorDetails;
import com.training.educationsystem.exceptions.InvalidFeedbackException;
import com.training.educationsystem.services.FeedbackService;

@RestController
@RequestMapping("/api/educationsystem/feedback")
public class FeedbackController	{ 
	private static final Logger logger=LoggerFactory.getLogger(FeedbackController.class);
	/**
	 * 
	 */
	@Autowired
	private FeedbackService service;
	
/**
*Shows all list of feedback data
*@return feedback list
*@throws InvalidFeedbackException
*  
*/
		@GetMapping("/view-all-feedback")
		public List<Feedback> getAllFeedback() throws InvalidFeedbackException{
			logger.info("Fetching all feedback data in feedback controller -START");
			List<Feedback> feedbackList=service.getAllFeedback();
			logger.info("Done in feedback controller -END");
			return feedbackList;	
	}
	
/**
*Adds feedback into the database
*@param sname
*@param feedback
*@return feedback
*@throws InvalidFeedbackException
* 
*/
		@PostMapping("/add-feedback")
		public Feedback addFeedback(@RequestParam("sname")String sname,@RequestParam("feedback")String feedback) 
				throws InvalidFeedbackException		{
			logger.info("for adding feedback-START");
			String pattern="^[a-zA-Z0-9]*$";
			String namePattern="^[a-zA-Z]+$";
			
			if (sname=="") {
				logger.error("name cannot be empty");
				throw new InvalidFeedbackException("name cannot be empty");
			}
			if (!(sname.matches(namePattern))) {
				logger.error("Name cannot contain special symbol and numbers");
				throw new InvalidFeedbackException("sname cannot contain special symbol and numbers");
			}
			if (feedback=="") {
				logger.error("feedback cannot be negative");
				throw new InvalidFeedbackException("feedback cannot be empty");
			}
			if (!(feedback.matches(pattern))) {
				logger.error("feedback cannot contain special symbol");
				throw new InvalidFeedbackException("feedback cannot contain special symbol");
			}
			else {
				logger.info("feedback added succesfully..-END");
				return service.addFeedback(sname,feedback);
			}
	}
		@ResponseStatus(HttpStatus.NOT_FOUND)
		@ExceptionHandler(InvalidFeedbackException.class)
		ErrorDetails exceptionHabler(InvalidFeedbackException e)
		{
			return new ErrorDetails("400",e.message); 	
		}
		 
/**
*Adds reply to feedback by feedback id
*@param id
*@param reply
*@return addReply
*@throws InvalidFeedbackException 
* 
*/
		@PatchMapping("/add-reply")
		public Feedback updateFeedbackForReply(@RequestParam("id")int id,@RequestParam("reply")String reply)
				throws InvalidFeedbackException
	{
			logger.info("Updating reply in feedback controller-START");
			Feedback addReply=service.updateFeedbackForReply(id, reply);
			logger.info("Done in feedback controller-END");
			return addReply;
	}
	

/**
*Shows reply of feedback by id
*@param id
*@return reply
* 
*/
		@GetMapping("/view-reply/{id}")
		public String viewReply(@PathVariable("id")int id )
				throws InvalidFeedbackException
	{
			logger.info("Showing reply in feedback controller-START");
			String reply=service.viewReply(id);
			logger.info("Done in feedback controller-END");
			return reply;
	}
}
