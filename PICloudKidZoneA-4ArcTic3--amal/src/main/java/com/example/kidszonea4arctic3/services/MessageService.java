package com.example.kidszonea4arctic3.services;

import java.util.List;

import com.example.kidszonea4arctic3.models.Message;


public interface MessageService {
	List<Message> retrieveAllMessages(Long idParent);
	void addMessage(Message r);
	void deleteMessage(Long id);
}
