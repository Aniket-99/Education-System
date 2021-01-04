package com.training.educationsystem.services;

import java.util.List;

import com.training.educationsystem.entities.Grievance;
import com.training.educationsystem.exceptions.InvalidGrievanceException;

public interface IGrievanceService {

	public Grievance addGrievance(String sname, String grievance);
	public List<Grievance> getAllGrievance() throws InvalidGrievanceException;
	public Grievance updateGrievanceForReply(int id,String reply) throws InvalidGrievanceException;
	public String viewReply(int id ) throws InvalidGrievanceException;
}
