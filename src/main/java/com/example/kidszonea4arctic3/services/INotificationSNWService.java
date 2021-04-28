package com.example.kidszonea4arctic3.services;

import java.util.List;

import com.example.kidszonea4arctic3.models.NotificationSNW;


public interface INotificationSNWService {
	
	public NotificationSNW getNotifById(long id);

	public List<NotificationSNW> getAllNotif();

	public List<NotificationSNW> getNotifByUser(long id);

	public void deleteNotif(long id);

	//public User currentUser() throws Exception;

	public List<NotificationSNW> getMyNotifs() throws Exception;


}
