package com.example.kidszonea4arctic3.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kidszonea4arctic3.models.Employee;
import com.example.kidszonea4arctic3.models.History;
import com.example.kidszonea4arctic3.models.Meeting;
import com.example.kidszonea4arctic3.models.Parent;
import com.example.kidszonea4arctic3.repositories.ChildRepository;
import com.example.kidszonea4arctic3.repositories.EmployeeRepository;
import com.example.kidszonea4arctic3.repositories.HistoryRepository;
import com.example.kidszonea4arctic3.repositories.MeetingRepository;
import com.example.kidszonea4arctic3.repositories.ParentRepository;

@Service
public class MeetingService implements IMeetingService{

	//private static List<Meeting> meets = new ArrayList<>();
	@Autowired
    private MeetingRepository meetingRepository;
	
	@Autowired
    private ParentRepository pr;
	
	@Autowired
    private EmployeeRepository er;
	
	@Autowired
    private ChildRepository cr;
	
	@Autowired
    private HistoryRepository hr;
	   @Override 
	    public List<Meeting> getAllMeetings() {
			return (List<Meeting>) meetingRepository.findAll();
			}

	
	@Override
	public Meeting updateMeeting(long id, Meeting meeting) {
	    
	    meeting=meetingRepository.findById(id).get();
		return meetingRepository.save(meeting);		
		
	}
	
	
	@Override
	public int UpdateMeet(Meeting meet) {
	meetingRepository.save(meet);
	return (int) meet.getId();
	}

	@Override
	public void suppMeeting(long id) {
       meetingRepository.deleteById(id);		
	}
	
	
	
	@Transactional
	public void doDeleteMeet(Meeting meet) {

		meetingRepository.delete(meet);
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
	
	//##########################################
	/*@Override
	public List<Parent> getAllParents() {
		List<Parent> parentUITOLst = new ArrayList<>();
		List<Parent> parentDTOLst = (List<Parent>) pr.findAll();

		parentDTOLst.forEach(dto -> {
			Parent parentUiTO = new Parent();

			parentUITOLst.add(parentUiTO);
		});

		return parentUITOLst;
	}*/
	@Override
	public List<Parent> getAllParents() {



		
		return (List<Parent>) pr.findAll();

	}
	/*@Override
	public List<Child> getAllChilds() {



		
		return (List<Child>) cr.findAll();

	}*/


	@Override
	public Parent getParent(Parent parentUITO) {
		System.out.println(">>>>> "+parentUITO.getfName());
		//Parent pto = pr.findTitleByfName(parentUITO.getfName());
		Parent parent = new Parent();

		return parent;
	}
	
	
	public Parent getParentById(Long id){
		System.err.println("hava id fi contrat service :"+id);
		return pr.findById(id).get();
	}
	
	
	public Employee getEmployeeById(Long id){
		System.err.println("hava id fi contrat service :"+id);
		return er.findById(id).get();
	}
	
	public List<Meeting> getParentMeets() throws Exception {
		long id = 193 ; 
		Parent p = pr.findById(id).get() ;
		return meetingRepository.getMeetingByParentId(p.getId()) ;
	}
	
	
	public List<Meeting> getNewMeets() throws Exception {
		
		//List<Meeting> list = (List<Meeting>) getAllMeetings();
		
		List<Meeting> list = (List<Meeting>) meetingRepository.findAll();

		 SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
		 Date date = new Date(System.currentTimeMillis());
		 System.out.println(formatter.format(date));
		 
		 History h =new History();
	     
		for(Meeting m: list){
			 
			 if(m.getDate().before((date)))
				 h.setEmployee(m.getEmployee());
			     h.setParent(m.getParent());
			     h.setReason(m.getReason());
			     h.setState(m.isState());
			     h.setType(null);
			     h.setDate(m.getDate());
			     
				 
			    // meetingRepository.delete(m);
	      
	}
	     hr.save(h);

		
		return list ;
	}
	
	/*public Parent getParentIdByChild(Long id){
		System.err.println("hava id fi contrat service :"+id);
		return cr.findById(id).get().getParent();
	}*/


	}



