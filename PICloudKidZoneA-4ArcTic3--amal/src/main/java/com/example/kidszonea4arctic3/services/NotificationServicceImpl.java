package com.example.kidszonea4arctic3.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kidszonea4arctic3.models.Notification;
import com.example.kidszonea4arctic3.repositories.NotificationRepository;

@Service
public class NotificationServicceImpl implements NotificationService{
	@Autowired
	NotificationRepository notificationRepository;
	
	public static final Logger l= LogManager.getLogger(NotificationServicceImpl.class);

	

	
	@Override
	public List<Notification> retrieveAllNotification(Long directeurId) {
		return notificationRepository.findByIdDirecteur(directeurId);
		
	}

	@Override
	public void updateNotification(Long idNotif) {
		notificationRepository.readNotif(idNotif);
	}

	@Override
	public void DeleteNotification(Long idNotif) {
		notificationRepository.deleteById(idNotif);
		
	}

	@Override
	public void createNotification(Notification n) {		
		notificationRepository.save(n);
	}
	
}
