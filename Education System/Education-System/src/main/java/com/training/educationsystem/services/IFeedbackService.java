package com.training.educationsystem.services;

import java.util.List;

import com.training.educationsystem.entities.Feedback;
import com.training.educationsystem.exceptions.InvalidFeedbackException;

public interface IFeedbackService {

	public 	Feedback addFeedback(String sname, String feedback);
	public List<Feedback> getAllFeedback() throws InvalidFeedbackException;
	public Feedback updateFeedbackForReply(int id,String reply) throws InvalidFeedbackException;
	public String viewReply(int id )throws InvalidFeedbackException;

}
