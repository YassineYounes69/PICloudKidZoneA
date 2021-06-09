package com.example.kidszonea4arctic3.services;

import java.util.List;

import com.example.kidszonea4arctic3.models.Notification;


public interface NotificationService {
	void createNotification(Notification n);
	List<Notification> retrieveAllNotification(Long directeurId);//afficher toutes les notification pour le directeur
	void updateNotification(Long idNotif);//mis a jour de notification set isRead=true
	void DeleteNotification(Long idNotif);
	
}
