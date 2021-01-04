package com.training.educationsystem.services;

import java.time.LocalDate;
import java.util.List;


import com.training.educationsystem.entities.Message;

/*
 * message service interface to declare all the methods
 */
public interface MessageService {

	public Message addMessage(LocalDate localDate, String messageDescription);
	
	public Message  viewMessage(int messageId);
	
	public List<Message> viewAllMessages();
}
