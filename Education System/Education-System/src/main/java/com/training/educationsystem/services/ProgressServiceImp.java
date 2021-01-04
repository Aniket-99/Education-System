package com.training.educationsystem.services;

import java.util.List;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.educationsystem.entities.Progress;
import com.training.educationsystem.exceptions.InvalidProgressException;
import com.training.educationsystem.repositories.ProgressRepository;

/*
 * progress service implementation class to implement 
 * all the methods of service interface and provide its defintion
 */
@Transactional
@Service
public class ProgressServiceImp implements ProgressService{
	
	// declaring logger
	private static final Logger logger = LoggerFactory.getLogger(ProgressServiceImp.class);
	
	@Autowired
	ProgressRepository progressRepo; // autowiring repository interface
	
	/*
	 * @param completedHours
	 * method for adding the progress
	 * here completed hours of the course will be added into progress table by calling the save function of jpa repository
	 * @return the progress after saving it 
	 */
	@Override
	public Progress addProgress(int completedHours) throws InvalidProgressException {
		logger.info("ProgressServiceImp class's addProgress method called-START");
		Progress progress=new Progress();
		progress.setCompletedHours(completedHours);
		logger.info("saving and returning the progress-END");
		return progressRepo.save(progress);
	}
	
	/*
	 * @param progressId
	 * method to view the progress
	 * here progress of each course is found by calling the getOne function of jpa repository
	 * @return the progress in the database 
	 */
	@Override
	public Progress viewProgress(int progressId) throws InvalidProgressException {		
		logger.info("ProgressServiceImp class's viewProgress method called-START");
		logger.info("finding and returning the progress.....");
		if(progressRepo.existsById(progressId)) {
			logger.info("returning the progress-END");
			return progressRepo.getOne(progressId);
		}
		else {
			logger.error("throwing progress with id not found exception");
			throw new InvalidProgressException("No such progress found with this id : " + progressId);
		}
	}

	/*
	 * method to view all the progresses
	 * here progress of all course is found by calling the findAll function of jpa repository 
	 * @return all the progresses in the database
	 */
	@Override
	public List<Progress> viewAllProgresses() throws InvalidProgressException {
		logger.info("ProgressServiceImp class's viewAllProgresses method called-START");
		logger.info("finding and returning all the progresses.....");
		if(progressRepo.findAll().size()>0) {
			logger.info("returning all the progress-END");
			return progressRepo.findAll();
		}
		else {
			logger.error("throwing progress not found exception");
			throw new InvalidProgressException("No progresses found!");
		}
	}
}

