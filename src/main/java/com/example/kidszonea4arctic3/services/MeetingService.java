package com.example.kidszonea4arctic3.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kidszonea4arctic3.models.Meeting;
import com.example.kidszonea4arctic3.models.Parent;
import com.example.kidszonea4arctic3.repositories.MeetingRepository;

@Service
public class MeetingService implements IMeetingService{

	//private static List<Meeting> meets = new ArrayList<>();
	@Autowired
    private MeetingRepository meetingRepository;
	
	@Override
	public List<Meeting> getAllMeetings() {
		 List<Meeting> meetings = new ArrayList<>();
		 meetingRepository.findAll().forEach(meetings::add);
		     return meetings;
	}

	
	@Override
	public Meeting updateMeeting(long id, Meeting meeting) {
	    
	    meeting=meetingRepository.findById(id).get();
		return meetingRepository.save(meeting);		
		
	}

	@Override
	public void suppMeeting(long id) {
       meetingRepository.deleteById(id);		
	}


	@Override
	public List<Meeting> getMeetingsById(long id) {
		 List<Meeting> meetings = new ArrayList<>();
		 meetingRepository.findById(id).orElse(null); 
		     return meetings;
	}


	@Override
	public Meeting addMeeting(Meeting meeting) {
		Meeting m = meetingRepository.save(meeting);
		return m;
	}


	
	
	@Override
	public List<Date> ListMeetingByDateTrier() {
		List<Date> date = new ArrayList<Date>();
		 meetingRepository.ListMeetingByDateTrier().forEach(date::add);
		     return date;
		     
	}


	@Override
	public List<?> allMeetingsByNameParent() {
		// TODO Auto-generated method stub
		return meetingRepository.allMeetingsByNameParent();
	}


	/*@Override
	public List<?> ParentWithMostMeeting() {
		// TODO Auto-generated method stub
		return meetingRepository.ParentWithMostMeeting();
	}*/

	}



