package com.example.kidszonea4arctic3.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.kidszonea4arctic3.models.NotificationSNW;
import com.example.kidszonea4arctic3.repositories.INotificationSNWRepository;


@Service
public class NotificationSNWServiceImpl implements INotificationSNWService{
	
	@Autowired 
	INotificationSNWRepository iNotificationSNWRepository;


	
	
    @Override
    public NotificationSNW getNotifById(long id) {

        return iNotificationSNWRepository.findById(id).get();
    }

    @Override
    public List<NotificationSNW> getAllNotif() {
		List<NotificationSNW>Notifs = new ArrayList<NotificationSNW>();
		iNotificationSNWRepository.findAll().forEach(e ->Notifs.add(e));
        return Notifs;

    }

    @Override
    public List<NotificationSNW> getNotifByUser(long id) {

        return iNotificationSNWRepository.getNotifByUser(id);

    }


    @Override
    public void deleteNotif(long id) {

       iNotificationSNWRepository.deleteById(id);
    }

	@Override
	public List<NotificationSNW> getMyNotifs() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
    
    
	//@Override
	//public List<NotificationSNW> getMyNotifs() throws Exception {
	
		//return iNotificationSNWRepository.getNotifByUser(currentUser().getIdUser());
	//}
	
}

