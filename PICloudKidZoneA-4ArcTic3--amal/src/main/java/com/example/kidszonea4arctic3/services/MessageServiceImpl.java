package com.example.kidszonea4arctic3.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kidszonea4arctic3.models.Message;
import com.example.kidszonea4arctic3.repositories.MessageRepository;

@Service
public class MessageServiceImpl implements MessageService{
	@Autowired
	MessageRepository messageRepository;

	@Override
	public List<Message> retrieveAllMessages(Long idParent) {
		return messageRepository.findByIdDirecteurAndIdParent(idParent);
	}

	@Override
	public void addMessage(Message r) {
		messageRepository.save(r);
		
	}

	@Override
	public void deleteMessage(Long id) {
		messageRepository.deleteById(id);	
	}

}
