package com.example.kidszonea4arctic3.services;


import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import com.example.kidszonea4arctic3.models.Child;
import com.example.kidszonea4arctic3.models.Meeting;
import com.example.kidszonea4arctic3.models.Parent;

public interface IMeetingService {
	
	public List<Meeting> getAllMeetings();
	public Meeting addMeeting (Meeting meeting);
	public Meeting updateMeeting (long id,Meeting meeting);
	public void suppMeeting (long id);
	public List<Meeting> getMeetingsById(long id);
	public List<Date> ListMeetingByDateTrier()throws Exception;
	public List<?> allMeetingsByNameParent();
	/*public List<?> ParentWithMostMeeting();*/
	public List<Parent> getAllParents();
	
	public int UpdateMeet(Meeting meet) ;

	//public List<Child> getAllChilds();

	
	Parent getParent(Parent parentUITO);
	
	public Parent getParentById(Long id);
	 
	
	//Parent getParentById(String parentUITO);

}
