package com.example.kidszonea4arctic3.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.kidszonea4arctic3.models.Child;
import com.example.kidszonea4arctic3.models.Employee;
import com.example.kidszonea4arctic3.models.Meeting;
import com.example.kidszonea4arctic3.models.Meeting.Type;
import com.example.kidszonea4arctic3.models.Parent;
import com.example.kidszonea4arctic3.repositories.ChildRepository;
import com.example.kidszonea4arctic3.repositories.EmployeeRepository;
import com.example.kidszonea4arctic3.repositories.HistoryRepository;
import com.example.kidszonea4arctic3.repositories.MeetingRepository;
import com.example.kidszonea4arctic3.repositories.ParentRepository;
import com.example.kidszonea4arctic3.services.MeetingService;



import org.ocpsoft.rewrite.el.ELBeanName;


@RequestScoped 
@Controller(value = "meetingcontroller") // Name of the bean in Spring IoC
@ELBeanName(value = "meetingcontroller") // Name of the bean used by JSF
public class MeetingController {
	
	
	public MeetingController() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	private MeetingService ms;
	
	@Autowired
	private HistoryRepository hr;
	
	@Autowired
	private MailController mc;
	
	@Autowired
	private MeetingRepository mr;
	@Autowired
	private ParentRepository pr;
	@Autowired
	private ChildRepository cr;
	
	@Autowired
	private EmployeeRepository er;
   
	private long MeetingIdToUpdate;


	private  long id;

	private  Employee employee;
		
	private  String reason;
	
	private  Date  date;

    private  boolean state;

    private  Type type;

	private  Parent parent;
   
    private long idparent;
    
    private long idemployee;


	

	public Type[] getTypes(){
		return Type.values();
	}
	private List<Child> child;
	
	private List<Parent> parente;
	
	private List<Meeting> meetings;

	

	public long getIdemployee() {
		return idemployee;
	}

	public void setIdemployee(long idemployee) {
		this.idemployee = idemployee;
	}
	
	public long getMeetingIdToUpdate() {
		return MeetingIdToUpdate;
	}

	public void setMeetingIdToUpdate(long meetingIdToUpdate) {
		MeetingIdToUpdate = meetingIdToUpdate;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public long getIdparent() {
		return idparent;
	}


	public void setIdparent(long idparent) {
		this.idparent = idparent;
	}
	public String getReason() {
		return reason;
	}


	public void setReason(String reason) {
		this.reason = reason;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public boolean isState() {
		return state;
	}


	public void setState(boolean state) {
		this.state = state;
	}


	public Type getType() {
		return type;
	}


	public void setType(Type type) {
		this.type = type;
	}


	public Parent getParent() {
		return parent;
	}


	public void setParent(Parent parent) {
		this.parent = parent;
	}


	public Employee getEmployee() {
		return employee;
	}


	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


	public List<Meeting> getMeetings() {
		return meetings;
	}

	public List<Meeting> getMeetingtolist() {
		if (null == meetings) {
			meetings = new ArrayList<>();
		}
		return meetings;
	}
	
	public void setMeetings(List<Meeting> meetings) {
		this.meetings = meetings;
	}
	
	public List<Child> getChild() {
		
		if (null == child) {
			child = new ArrayList<>();
		}
		return child;
	}

	public void setChild(List<Child> child) {
		this.child = child;
	}

	public List<Parent> getParente() {
		if (null == parente) {
			parente = new ArrayList<>();
		}
		return parente;
	}
	
	public void setParente(List<Parent> parente) {
		this.parente = parente;
	}
	
      //Add Meeting
	 public void addMeet() throws Exception{		 
		 System.err.println("*********"+this.idparent);
		 
		   this.idemployee = 68 ; 
			
			
		   SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
			 Date date1 = new Date(System.currentTimeMillis());
			 System.out.println(formatter.format(date1));
			 
			 if(date.before(date1)){
				  FacesMessage message1 = new FacesMessage( "date false" );
			      FacesContext.getCurrentInstance().addMessage( null, message1 );
				 
			 }
			 else{
			 
			 
			this.employee = ms.getEmployeeById(this.idemployee);
		    this.parent=ms.getParentById(this.idparent);
		    
           System.err.println("*********"+this.parent.getfName());
		   System.err.println("*********"+this.reason);
		   System.err.println("*********"+this.date);
		   System.err.println("*********"+this.type);
		   System.err.println("*********"+this.state); 
		  // System.err.println("USER ACTUEL"+UserControllerImpl.getT());
			ms.addMeeting(new Meeting(reason,date,state,type,parent,employee));
			mc.sendSimpleEmailParent(parent.getId()); 
			getAllMeet();
		      FacesMessage message = new FacesMessage( "Meeting Added !" );
		      FacesContext.getCurrentInstance().addMessage( null, message );
			
	    }
	 }
	    //Delete Meeting
		@DeleteMapping("/removeMeeting/{id}")  
		public void deleteMeeting(@PathVariable ("id") long id) throws Exception  
		{  
	       Optional<Meeting> meet= mr.findById(id);  	
		if(meet!=null){  
			ms.suppMeeting(id);
			//getAllMeet();

		}
		else
		{
		throw new Exception("meet not found: "+ id);  
		}
		}
	
		
		public void deleteMeeting(Meeting meet) { 
			
			ms.doDeleteMeet(meet);
			

			getAllMeet();
		}

		
		public void displayMeeting(Meeting meet)
		{        
	    
		this.setReason(meet.getReason());
		this.setDate(meet.getDate());
		this.setType(meet.getType());
		this.setIdparent(meet.getParent().getId());
		this.setIdemployee(meet.getEmployee().getId());
		this.setMeetingIdToUpdate(meet.getId());
		}	
		
		 public void updateMeeting()
		 { 		  
			 this.parent=ms.getParentById(this.idparent);
		  
		  
		  this.idemployee = 68 ; 	
		  this.employee = ms.getEmployeeById(this.idemployee);

		 System.err.println("*********"+this.MeetingIdToUpdate);
		 System.err.println("*********"+this.reason);
		 System.err.println("*********"+this.date);
		 System.err.println("*********"+this.state);
		 System.err.println("*********"+this.type);
		 System.err.println("*********"+this.parent);
		 System.err.println("*********"+this.employee);

		 ms.UpdateMeet(new Meeting(MeetingIdToUpdate, reason,date, state, type, parent, employee)); 
			getAllMeet();
   System.err.println("*********"+ms.UpdateMeet(new Meeting(MeetingIdToUpdate, reason,date, state, type, parent, employee)));

		 }
		 
		 @GetMapping("/getMeetParent")  
			@ResponseBody
			public List<Meeting> getMeetParent() throws Exception   
			{  
				return ms.getParentMeets() ; 
			}
		 
		 
		 
		 public String updateMeetingState(Long id){
		        System.out.println("updating Meeting :"+id);
		        try {
		            mr.updateMeetingState(id);
		        } catch (Exception exc) {
		            System.out.println(exc);
		            return null;
		        }

		        return "/MeetingParent.xhtml?faces-redirect=true";
		    }
		
		
		@GetMapping("/getEmailParent/{id}")  
		public String getEmailParentById(@PathVariable ("id") long id) throws Exception  
		{  
		Optional<Parent> parent= pr.findById(id);   
		if(!parent.isPresent())  
		{  
		throw new Exception("Parent not found: "+ id);  
		}  
		return parent.get().getEmail();  
		}

	@PostConstruct
	public void getAllMeet() { 
		if (!this.getMeetingtolist().isEmpty()) {
			this.getMeetingtolist().clear();
			this.getParente().clear();
		}
		System.out.println(" >>>>>>>>>>>>> " + ms);
		this.getMeetingtolist().addAll(ms.getAllMeetings());
		this.getParente().addAll(ms.getAllParents());

	}


	




	@GetMapping("/allMeetingsByDate")
	 @ResponseBody
	 public List<Date> getMeetingsByDateTrier() {
	 List<Date> list = (List<Date>) ms.ListMeetingByDateTrier();
	 return list;
}
	
	@GetMapping("/allMeetingsByNameParent")
	 @ResponseBody
	 public List<?> allMeetingsByNameParent() {
	 List<?> list = (List<?>) ms.allMeetingsByNameParent();
	 return list;
}

	
	@GetMapping("/getMeeting/parent/{idparent}/meeting")  
	public Set<Meeting> getMeetingByParent(@PathVariable ("idparent") long id) throws Exception  
	{  
	Optional<Parent> parents= pr.findById(id);   
	if(!parents.isPresent())  
	{  
	throw new Exception("parent not found: "+ id);  
	}  
	return parents.get().getMeetings();  
	}
	
	@GetMapping("/getEmail/{id}")  
	public String getEmailParentByChild(@PathVariable ("id") long id) throws Exception  
	{  
	Optional<Child> child= cr.findById(id);   
	if(!child.isPresent())  
	{  
	throw new Exception("child not found: "+ id);  
	}  
	return child.get().getParent().getEmail();  
	}
	
	
	/*
	
	 private List<?> parents;
	 

	public List<?> getParents() {
		return parents;
	}


	public void setParents(List<?> parents) {
		this.parents = parents;
	}


	@GetMapping("/getFnamParent")  
	@ResponseBody
	public List<?> getAllFnameParentByChild() throws Exception  
	{  
      parents = (List<?>) mr.allNameParent();

	return  parents;  
	}*/
	
	
	@GetMapping("/getAllEmailParent")  
	public String[] getAllEmailParent() throws Exception  {

	return mr.allEmailParent(); 
	}
	
	
	
	@GetMapping("/getParentIdByChild/{id}")  
	public Parent getParentIdByChild(@PathVariable ("id") long id) throws Exception  
	{  
	Optional<Child> child= cr.findById(id);   
	if(!child.isPresent())  
	{  
	throw new Exception("child not found: "+ id);  
	}  
	return child.get().getParent();  
	}
	
	
	/*@GetMapping("/allParentbyChild")  
	public List<Child> allChild() throws Exception  
	{  
 
	return (List<Child>) meetingRepository.allChild();  
	}*/
	

	@PostMapping("/add-Meeting/child/{idchild}/employee/{idemployee}/meeting")  
	public Meeting createMeeting(@PathVariable("idchild") long c,@PathVariable ("idemployee") long e, @RequestBody Meeting meet) throws Exception      
	{  
	//Optional<Parent> parents= parentRepository.findById(p);  
		Optional<Employee> employees= er.findById(e);
		Optional<Child> child= cr.findById(c);   
 
	
	//Optional<Child> child= childRepository.findById(p);  
		Employee employee=employees.get();
		Parent parent=getParentIdByChild(c);
	
	if(!child.isPresent()&&!employees.isPresent())  
	{  
	throw new Exception("erreur id: "+ c +e);  
	}
	

	 meet.setParent(parent);
	 meet.setEmployee(employee);
	 meet.setState(false);

	
	 mc.sendSimpleEmail(c);
	 
 
	return       ms.addMeeting(meet);
	}  
	
	
	
	
	
	@GetMapping("/getMeeting/employee/{idemployee}/meeting")  
	public Set<Meeting> getMeetingByEmployee(@PathVariable ("idemployee") long id) throws Exception  
	{  
	Optional<Employee> employees= er.findById(id);   
	if(!employees.isPresent())  
	{  
	throw new Exception("employee not found: "+ id);  
	}  
	return employees.get().getMeetings();  
	} 
	
	
	
	
	
    @PutMapping("/MeetingUpdateCauseById/{id}/{Cause}")
    public Meeting updateCauseById(@PathVariable Long id,@PathVariable String Cause){
        Meeting meet = new Meeting();
        if (mr.findById(id).isPresent()){
            meet = mr.findById(id).get();
            meet.setReason(Cause);
            return mr.save(meet);
        }
        else
        {
            return meet;
        }
    }
   
   /* @PutMapping("/MeetingUpdateEtatById/{id}/{state}")
    public Meeting updateEtatById(@PathVariable Long id,@PathVariable Boolean state){
        Meeting meet = new Meeting();
        if (meetingRepository.findById(id).isPresent()){
            meet = meetingRepository.findById(id).get();
            meet.setState(state);
            return meetingRepository.save(meet);
        }
        else
        {
            return meet;
        }
    }*/
  
    
    @PutMapping("/MeetingUpdateRefusedById/{id}")
    public Meeting updateRefusedById(@PathVariable Long id){
        Meeting meet = new Meeting();
        if (mr.findById(id).isPresent()){
            meet = mr.findById(id).get();
            meet.setState(false);
            return mr.save(meet);
        }
        else
        {
            return meet;
        }
    }
    
    
    
    @PutMapping("/MeetingUpdateDateById/{id}/{date}")
    public Meeting updateDateById(@PathVariable Long id, /*@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)*/Date  date){
        Meeting meet = new Meeting();
        if (mr.findById(id).isPresent()){
            meet = mr.findById(id).get();
            meet.setDate(date);
            return mr.save(meet);
        }
        else
        {
            return meet;
        }
    }
    
	 @PutMapping("/MeetingUpdateById/{id}")
	    public Meeting updateById(@PathVariable Long id,@RequestBody Meeting meet){
	        Meeting m = new Meeting();
	        if (mr.findById(id).isPresent()){
	            m = mr.findById(id).get();
	            m.setReason(meet.getReason());
	            m.setDate(meet.getDate());
	            m.setState(meet.isState());
	            m.setType(meet.getType());
	            return ms.updateMeeting(id, m);
	        }
	        else
	        {
	            return m;
	        }
	    }
	 @GetMapping("/getNewMeet")  
		@ResponseBody
		public List<Meeting> getNewMeets() throws Exception   
		{  
			return ms.getNewMeets() ; 
		}
	 
	/* @GetMapping("/allNewMeets")
	 @ResponseBody
	 public List<Meeting> getNewMeets() throws Exception {
	 List<Meeting> list = (List<Meeting>) ms.getAllMeetings();
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
		     
		     hr.save(h);
			 
			 deleteMeeting(m.getId());	 
      
}
	 return list;

}*/
	  /*  @Transactional
		@PostMapping("/createMultipleMeeting/employee/{idemployee}/meeting")  
		public Meeting createMultipleMeeting(@PathVariable ("idemployee") long e,@RequestBody Meeting meet ) throws Exception      
		{  
		Optional<Employee> employees= er.findById(e);
		
		Employee employee=employees.get();
		List<Child> child=(List<Child>) cr.findAll();		
		
		List<Parent> list=new ArrayList<>();	
		if(!employees.isPresent())  
		{  
		throw new Exception("erreur id: " +e);  
		}
		
		
		for (Child child1 : child) {
			list.add(child1.getParent());
			
		}
			 meet.setListParent(list);
			 meet.setEmployee(employee);
			 meet.setState(false);					
				//mc.sendMultipleEmail();

		return     ms.addMeeting(meet);   
		} */
	 
	 
	   /* @GetMapping("/ParentWithMostMeeting")
		 @ResponseBody
	    public List<?> ParentWithMostMeeting(){
			return ms.ParentWithMostMeeting();
			
	    }*/
	 
	 

	 
	 
	 }
