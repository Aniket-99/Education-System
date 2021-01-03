package com.training.educationsystem.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.educationsystem.entities.Progress;
import com.training.educationsystem.exceptions.InvalidInputException;
import com.training.educationsystem.exceptions.InvalidProgressException;
import com.training.educationsystem.services.ProgressService;

@RestController
@RequestMapping("/educationsystem/progress")
public class ProgressController {
	
	//declaring logger
	private static final Logger logger=LoggerFactory.getLogger(ProgressController.class);
			
	// autowiring ProgressService service interfaces
	@Autowired
	ProgressService progressService;

	/*
	 * @param completedhours
	 * student will add the completed hours of the course to the progress table
	 * @return the added progress in the progress table
	 * throws exception if the field is invalid
	 */
	@PostMapping("/add-progress")
	public Progress addProgress(@RequestParam("completedHours") int hours) throws InvalidProgressException {
		//logger for adding progress
		logger.info("adding progress-START");
		if (hours < 0) {
			logger.error("progress hours negative error thrown.....");
			throw new InvalidInputException("Progress hours cannot be negative :" + hours);
		}
		if (hours == 0) {
			logger.error("progress hours zero error thrown.....");
			throw new InvalidInputException("Progress hours cannot be zero :" + hours);
		}
		if (hours > 10) {
			logger.error("progress hours invalid error thrown.....");
			throw new InvalidInputException("Progress hours cannot be greater than 9999 :" + hours);
		} else {
			logger.info("progress added successfully-END");
			return progressService.addProgress(hours);
		}
	}

	/*
	 * @param progressId 
	 * student/admin will view the progress of each course from the progress table
	 * @return the progress by progress id specified
	 * throws exception if the fields are invalid
	 */
	@GetMapping("/view-progress")
	public Progress viewProgress(@RequestParam("progressId") int id) throws InvalidProgressException {
		//logger for viewing progress
		logger.info("viewing progress-START");
		if (id < 0) {
			logger.error("progress id negative error.....");
			throw new InvalidInputException("Progress id cannot be negative :" + id);
		}
		if (id == 0) {
			logger.error("progress id zero error.....");
			throw new InvalidInputException("Progress id cannot be zero :" + id);
		}
		if (id > 9999) {
			logger.error("progress id invalid error.....");
			throw new InvalidInputException("Progress id cannot be greater than 9999 :" + id);
		} else {
			logger.info("progress viewed-END");
			return progressService.viewProgress(id);
		}

	}

	/*
	 * student/admin will view the progress of all courses from the progress table
	 * @return all progresses
	 */
	@GetMapping("/view-all-progresses")
	public List<Progress> viewAllProgresses() throws InvalidProgressException {
		//logger for viewing all the progresses
		logger.info("viewing all the progresses-START-END");
		return progressService.viewAllProgresses();
	}

}

