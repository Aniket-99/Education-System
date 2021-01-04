package com.training.educationsystem.services;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.educationsystem.entities.Feedback;
import com.training.educationsystem.exceptions.InvalidFeedbackException;
import com.training.educationsystem.repositories.FeedbackRepository;

@Transactional
@Service
public  class FeedbackService implements IFeedbackService {
	private static final Logger logger=LogManager.getLogger(FeedbackService.class);
	@Autowired
	FeedbackRepository feedbackRepo;

		
/**
*adding feedback 
*@param sname
*@param feedback
*@return Feedback object	
* 
*/
		@Override
		public Feedback addFeedback(String sname, String feedback) {
			logger.info("Adding data in feedback service-START");
			Feedback feedback1=new Feedback();
			feedback1.setSname(sname);
			feedback1.setFeedback(feedback);
			Feedback addFeedback=feedbackRepo.save(feedback1);
			logger.info("Done in feedback service-END");
			return addFeedback;	
		}
			
/**
 *updating feedback reply
 *@param id
 *@param reply
 *@return Feedback object
 *@throws InvalidFeedbackException
 * 
 */
		@Override
		public Feedback updateFeedbackForReply(int id, String reply) throws InvalidFeedbackException {
			Feedback addReply=feedbackRepo.findById(id).orElse(null);
			logger.info("updating feedbackreply in feedback service");
			if(addReply!=null) {
				addReply.setReply(reply);
				Feedback updateFeedback=feedbackRepo.save(addReply);
				logger.info("done in feedback service");
				return updateFeedback;
			}
			else 
				logger.error("Reply of the mentioned Id cannot be FOUND");
				throw new InvalidFeedbackException("Feedback of the mentioned Id cannot be found");
			}
	
/**
*shows all feedback present
*@return Feedback List
*@throws InvalidFeedbackException
* 
*/
		@Override
		public List<Feedback> getAllFeedback() throws InvalidFeedbackException {
			logger.info("getting all feedback data in feedback service");
			List<Feedback> feedbackList=feedbackRepo.findAll();
			if(feedbackList.size()>0) {
				logger.info("done in feedback service");
				return feedbackList;
			}
			else
				logger.error("NO Feedback to show");
				throw new InvalidFeedbackException("No Feedbacks to show");
	}

/**
*shows reply of the mentioned Id
*@return reply of id
*@throws InvalidFeedbackException
* 
*/
		@Override
		public String viewReply(int id) throws InvalidFeedbackException {
			logger.info("Showing reply in feedback service-START");
			Feedback viewReply=feedbackRepo.findById(id).orElse(null);
			if(viewReply!=null) {
				String reply=viewReply.getReply();
				logger.info("Done in feedback service-END");
				return reply;
			}
			else 
				logger.error("Reply of the mentioned Id cannot be FOUND");
				throw new InvalidFeedbackException("Reply of the mentioned Id cannot be FOUND");
				
				
	}
}

		