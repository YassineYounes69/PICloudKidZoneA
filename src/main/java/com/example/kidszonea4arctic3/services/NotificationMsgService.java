package com.example.kidszonea4arctic3.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.kidszonea4arctic3.models.NotificationMsg;
import com.example.kidszonea4arctic3.models.Parent;
import com.example.kidszonea4arctic3.models.Retour;
import com.example.kidszonea4arctic3.repositories.NotificationMsgRepository;
import com.example.kidszonea4arctic3.repositories.ParentRepository;



@Service
public class NotificationMsgService implements INotificationMsgService {
	
	@Autowired
	private NotificationMsgRepository notificationRepository;
	@Autowired
	ParentRepository userRepository;

	// Add notification
	@Override
	public NotificationMsg addNotif(long idS, long idR, NotificationMsg notification) {
		Parent s = userRepository.findById(idS).get();
		Parent r = userRepository.findById(idR).get();
		notification.setParentSend(s);
		notification.setParentReceive(r);
		notification.setCreatedAt(new Date(System.currentTimeMillis()));
		notification.setTime(new Date(System.currentTimeMillis()));
		notification.setRead(false);
		return notificationRepository.save(notification);
	}

	/* 
	 * @Override
	
	public List<NotificationMsg> findAllByUserReceive() throws Exception {
		//User user = getCurrentUser();
		Date toDay = new Date(System.currentTimeMillis());
		List<NotificationMsg> notifs = notificationRepository.userNotification(user);
		List<NotificationMsg> notifsN = new ArrayList<NotificationMsg>();
		for (NotificationMsg notificationMsg : notifs) {
			Date notifDay = notificationMsg.getCreatedAt();
			long diffInMillies = Math.abs(toDay.getTime() - notifDay.getTime());

			long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
			if (diff == 0) {
				notificationMsg.setTimeChecked(toDay);
				// notificationRepository.save(notif);
				DateFormat dateFormat = new SimpleDateFormat("hh:mm");
				String timeString1 = dateFormat.format(notificationMsg.getTimeChecked());
				String timeString2 = dateFormat.format(notificationMsg.getTime());
				String[] fractions1 = timeString1.split(":");
				String[] fractions2 = timeString2.split(":");
				Integer hours1 = Integer.parseInt(fractions1[0]);
				Integer hours2 = Integer.parseInt(fractions2[0]);
				Integer minutes1 = Integer.parseInt(fractions1[1]);
				Integer minutes2 = Integer.parseInt(fractions2[1]);
				int hourDiff = hours1 - hours2;
				int minutesDiff = minutes1 - minutes2;
				if (minutesDiff < 0) {
					minutesDiff = 60 + minutesDiff;
					hourDiff--;
				}
				if (hourDiff < 0) {
					hourDiff = 24 + hourDiff;
				}
				// rt.setStringValue("Notif received " + hourDiff + "h" +
				// minutesDiff + "min ago");
				String content = notificationMsg.getContent();
				notificationMsg.setContent(content + " " + hourDiff + " hours and " + minutesDiff + " minutes ago");
			} else {
				// rt.setStringValue("Notif received " + diff + " days");
				String content = notificationMsg.getContent();
				notificationMsg.setContent(content + " " + diff + " days ago");
			}
			notifsN.add(notificationMsg);
		}
		return notifsN;
	}
*/
	@Override
	public Retour<NotificationMsg> findByNotificationId(@PathVariable("idU") long id) 
	{
		
		Retour<NotificationMsg> rt = new Retour<>();
		NotificationMsg notif = notificationRepository.findById(id).get();

		Date toDay = new Date(System.currentTimeMillis());
		Date notifDay = notif.getCreatedAt();
		long diffInMillies = Math.abs(toDay.getTime() - notifDay.getTime());

		long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
		notif.setRead(true);
		notificationRepository.save(notif);
		if (diff == 0) {
			notif.setTimeChecked(toDay);
			notificationRepository.save(notif);
			DateFormat dateFormat = new SimpleDateFormat("hh:mm");
			String timeString1 = dateFormat.format(notif.getTimeChecked());
			String timeString2 = dateFormat.format(notif.getTime());
			String[] fractions1 = timeString1.split(":");
			String[] fractions2 = timeString2.split(":");
			Integer hours1 = Integer.parseInt(fractions1[0]);
			Integer hours2 = Integer.parseInt(fractions2[0]);
			Integer minutes1 = Integer.parseInt(fractions1[1]);
			Integer minutes2 = Integer.parseInt(fractions2[1]);
			int hourDiff = hours1 - hours2;
			int minutesDiff = minutes1 - minutes2;
			if (minutesDiff < 0) {
				minutesDiff = 60 + minutesDiff;
				hourDiff--;
			}
			if (hourDiff < 0) {
				hourDiff = 24 + hourDiff;
			}
			rt.setStringValue("Notif received " + hourDiff + "h" + minutesDiff + "min ago");
			String content = notif.getContent();
			notif.setContent(content + " " + hourDiff + " hours and " + minutesDiff + " minutes ago");
		} else {
			rt.setStringValue("Notif received " + diff + " days");
			String content = notif.getContent();
			notif.setContent(content + " " + diff + " days ago");
		}

		rt.getObjectValue().add(notif);
		return rt;
	}

	@Override
	public List<NotificationMsg> findAllByUserReceive() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	
}
