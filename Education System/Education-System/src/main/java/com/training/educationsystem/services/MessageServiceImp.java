package com.training.educationsystem.services;

import java.time.LocalDate;
import java.util.List;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.educationsystem.entities.Message;
import com.training.educationsystem.exceptions.InvalidMessageException;
import com.training.educationsystem.repositories.MessageRepository;

/*
 * message service implementation class to implement 
 * all the methods of service interface and provide its defintion
 */
@Transactional
@Service
public class MessageServiceImp implements MessageService{

	// declaring logger
	private static final Logger logger = LoggerFactory.getLogger(MessageServiceImp.class);

	@Autowired
	MessageRepository messageRepo; // autowiring repository interface
	
	
	/*
	 * @param messageDate 
	 * @param messageDescription
	 * add message in the database by calling save function of jpa repository with the help of message repository object
	 * @return message saved in the database
	 */
	@Override
	public Message addMessage(LocalDate messageDate, String messageDescription) throws InvalidMessageException{
		logger.info("MessageServiceImp class's addMessage method called-START");
		Message message=new Message();
		message.setMessageDate(messageDate);
		message.setMessageDescription(messageDescription);
		logger.info("saving and returning the message-END");
		return messageRepo.save(message);
	}

	/*
	 * viewMesage method to print all the messages in the message table
	 * by calling findAll function of jpa repository with the help of message repository object
	 * @return all the messages after finding 
	 */
	@Override
	public List<Message> viewAllMessages() throws InvalidMessageException{
		logger.info("MessageServiceImp class's viewAllMessages method called-START");
		logger.info("finding and returning all the messages");
		if(messageRepo.findAll().size()>0) {
			logger.info("returning all the messages-END");
			return messageRepo.findAll();
		}
		else {
			logger.error("throwing no messages exception");
			throw new InvalidMessageException("No messages found!");
		}
	}

	/*
	 * @param messageId
	 * viewMesage method to print only one message in the message table
	 * by calling getOne function of jpa repository with the help of message repository object
	 * @return the message after finding 
	 */
	@Override
	public Message viewMessage(int messageId) throws InvalidMessageException {
		logger.info("MessageServiceImp class's viewMessage method called-START");
		logger.info("finding and returning the message.....");	
		if(messageRepo.existsById(messageId)) {
			logger.info("returning all the messages-END");
			return messageRepo.getOne(messageId);
		}
		else {
			logger.error("throwing message with id  not found exception");
			throw new InvalidMessageException("No such message found with id : "+messageId);
		}				
	}



}
