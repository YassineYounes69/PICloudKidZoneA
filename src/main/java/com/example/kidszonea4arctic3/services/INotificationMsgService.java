package com.example.kidszonea4arctic3.services;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.example.kidszonea4arctic3.models.NotificationMsg;
import com.example.kidszonea4arctic3.models.Retour;



public interface INotificationMsgService {
	public NotificationMsg addNotif(long idS, long idR, NotificationMsg notification);

	public List<NotificationMsg> findAllByUserReceive() throws Exception;

	public Retour<NotificationMsg> findByNotificationId(@PathVariable("idU") long id);
}
