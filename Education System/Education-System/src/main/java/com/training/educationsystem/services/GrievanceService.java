package com.training.educationsystem.services;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.educationsystem.entities.Grievance;
import com.training.educationsystem.exceptions.InvalidGrievanceException;
import com.training.educationsystem.repositories.GrievanceRepository;

@Transactional
@Service
public class GrievanceService implements IGrievanceService  {
	private static final Logger logger=LogManager.getLogger(GrievanceService.class);
	@Autowired
	GrievanceRepository grievancerepo;

/** 
*adding grievance 
*@param sname
*@param grievance
*@return Grievance object	
* 
*/
		//adding grievance 
		@Override
		public Grievance addGrievance(String sname, String grievance) {
			logger.info("adding grievance data in grievance service");
			Grievance grievance1=new Grievance();
			grievance1.setSname(sname);
			grievance1.setGrievance(grievance);
			Grievance addedGrievance=grievancerepo.save(grievance1);
			logger.info("done in grievance service");
			return addedGrievance;
		}

/**
*updating Grievance reply
*@param id
*@param reply
*@return Grievance object
*@throws InvalidGrievanceException
* 
*/
		//updating the reply for given id
		@Override
		public Grievance updateGrievanceForReply(int id, String reply) throws InvalidGrievanceException {
			logger.info("Updating reply in grievance service-START");
			Grievance aadReply=grievancerepo.getOne(id);
			if(aadReply!=null) {
				aadReply.setReply(reply);
				Grievance grievance=grievancerepo.save(aadReply);
				logger.info("Done in grievance service-END");
				return grievance;
			}
			else
				logger.error("Grievance of mentioned Id cannot be FOUND");
				throw new InvalidGrievanceException("Grievance of mentioned Id cannot be found");
		}
		
/**
*shows all Grievance present
*@return Grievance List
*@throws InvalidGrievanceException
* 
*/
		@Override
		public List<Grievance> getAllGrievance() throws InvalidGrievanceException {
			logger.info("Fetching all grievance data in grievance service-START");
			List<Grievance> grievanceList=grievancerepo.findAll();
			if(grievanceList.size()>0) {
				logger.info("Done in grievance service-END");
				return grievanceList;
			}
			else
				logger.error("NO grievance to show");
				throw new InvalidGrievanceException("NO grievance to show");
		}

/** 
*shows reply of the mentioned Id
*@return reply of id
*@throws InvalidGrievanceException
* 
*/
		@Override
		public String viewReply(int id) throws InvalidGrievanceException {
			logger.info("Showing reply in grievance service-START");
			Grievance viewReply=grievancerepo.findById(id).orElse(null);
			if(viewReply!=null) {
				String reply=viewReply.getReply();
				logger.info("Done in grievance service-END");
				return reply;
			}
			else
				logger.error("Reply of mentioned Id cannot be FOUND");
				throw new InvalidGrievanceException("Reply of mentioned Id cannot be FOUND");
		}
		

	}
