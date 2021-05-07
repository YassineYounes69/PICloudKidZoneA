package com.example.kidszonea4arctic3.controllers;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.transaction.Transactional;

import org.hibernate.query.criteria.internal.expression.function.CurrentDateFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jooq.JooqTest;
import org.springframework.context.annotation.Scope;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.kidszonea4arctic3.models.Child;
import com.example.kidszonea4arctic3.models.Employee;
import com.example.kidszonea4arctic3.models.History;
import com.example.kidszonea4arctic3.models.Meeting;
import com.example.kidszonea4arctic3.models.Parent;
import com.example.kidszonea4arctic3.models.Meeting.Type;
import com.example.kidszonea4arctic3.repositories.ChildRepository;
import com.example.kidszonea4arctic3.repositories.EmployeeRepository;
import com.example.kidszonea4arctic3.repositories.HistoryRepository;
import com.example.kidszonea4arctic3.repositories.MeetingRepository;
import com.example.kidszonea4arctic3.repositories.ParentRepository;
import com.example.kidszonea4arctic3.services.MeetingService;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.ocpsoft.rewrite.annotation.Join;

@Controller(value = "meetingController") // Name of the bean in Spring IoC
@ELBeanName(value = "meetingController") // Name of the bean used by JSF
@Join(path = "/", to = "/list.jsf")
public class MeetingController {
	
	@Autowired
	private MeetingService ms;
	
	@Autowired
	private HistoryRepository hr;
	
	@Autowired
	private MailController mc;
	
	private final MeetingRepository meetingRepository;
	private final ParentRepository parentRepository;
	private final EmployeeRepository employeeRepository;
	
	private final ChildRepository childRepository;



    public MeetingController(MeetingRepository meetingRepository,ParentRepository parentRepository,EmployeeRepository employeeRepository,ChildRepository childRepository) {
        this.meetingRepository = meetingRepository;
        this.parentRepository=parentRepository;
        this.employeeRepository=employeeRepository;
        this.childRepository=childRepository;
    }
	
    private List<Meeting> meetings;
	
    @GetMapping("/allMeetings")
	 @ResponseBody
	 public List<Meeting> allMeetings() {
	 meetings = ms.getAllMeetings();
	 return meetings;
}


	public void setMeetings(List<Meeting> meetings) {
		this.meetings = meetings;
	}

	public List<Meeting> getMeetings() {
		return meetings;
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
	Optional<Parent> parents= parentRepository.findById(id);   
	if(!parents.isPresent())  
	{  
	throw new Exception("parent not found: "+ id);  
	}  
	return parents.get().getMeetings();  
	}
	
	@GetMapping("/getEmail/{id}")  
	public String getEmailParentByChild(@PathVariable ("id") long id) throws Exception  
	{  
	Optional<Child> child= childRepository.findById(id);   
	if(!child.isPresent())  
	{  
	throw new Exception("child not found: "+ id);  
	}  
	return child.get().getParent().getEmail();  
	}
	
	
	@GetMapping("/getAllEmailParent")  
	public String[] getAllEmailParent() throws Exception  {

	return meetingRepository.allEmailParent(); 
	}
	
	
	
	@GetMapping("/getParentIdByChild/{id}")  
	public Parent getParentIdByChild(@PathVariable ("id") long id) throws Exception  
	{  
	Optional<Child> child= childRepository.findById(id);   
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
	

	   
		private String reason;
		

		private Date  date;

	    private boolean state;

	    private Type type;

		private Parent parent;
		
		private Employee employee;
		
		Meeting meeting=new Meeting();
		
		public void addMeeting() {
			ms.addMeeting(new Meeting(reason, date, state, type, parent, employee));
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


	@PostMapping("/add-Meeting/child/{idchild}/employee/{idemployee}/meeting")  
	public Meeting createMeeting(@PathVariable("idchild") long c,@PathVariable ("idemployee") long e, @RequestBody Meeting meet) throws Exception      
	{  
	//Optional<Parent> parents= parentRepository.findById(p);  
	Optional<Employee> employees= employeeRepository.findById(e);
	Optional<Child> child= childRepository.findById(c);   
 
	
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
	Optional<Employee> employees= employeeRepository.findById(id);   
	if(!employees.isPresent())  
	{  
	throw new Exception("employee not found: "+ id);  
	}  
	return employees.get().getMeetings();  
	} 
	
	//Delete Meeting
	@DeleteMapping("/removeMeeting/{id}")  
	public void deleteMeeting(@PathVariable ("id") long id) throws Exception  
	{  
       Optional<Meeting> meet= meetingRepository.findById(id);  	
	if(meet!=null){  
		//meetingRepository.deleteById(id);
		ms.suppMeeting(id);
	}
	else
	{
	throw new Exception("meet not found: "+ id);  
	}
	} 
	
    @PutMapping("/MeetingUpdateCauseById/{id}/{Cause}")
    public Meeting updateCauseById(@PathVariable Long id,@PathVariable String Cause){
        Meeting meet = new Meeting();
        if (meetingRepository.findById(id).isPresent()){
            meet = meetingRepository.findById(id).get();
            meet.setReason(Cause);
            return meetingRepository.save(meet);
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
    @PutMapping("/MeetingUpdateConfirmedById/{id}")
    public Meeting updateConfimedById(@PathVariable Long id){
        Meeting meet = new Meeting();
        if (meetingRepository.findById(id).isPresent()){
            meet = meetingRepository.findById(id).get();
            meet.setState(true);
            return meetingRepository.save(meet);
        }
        else
        {
            return meet;
        }
    }
    
    @PutMapping("/MeetingUpdateRefusedById/{id}")
    public Meeting updateRefusedById(@PathVariable Long id){
        Meeting meet = new Meeting();
        if (meetingRepository.findById(id).isPresent()){
            meet = meetingRepository.findById(id).get();
            meet.setState(false);
            return meetingRepository.save(meet);
        }
        else
        {
            return meet;
        }
    }
    
    
    
    @PutMapping("/MeetingUpdateDateById/{id}/{date}")
    public Meeting updateDateById(@PathVariable Long id, /*@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)*/Date  date){
        Meeting meet = new Meeting();
        if (meetingRepository.findById(id).isPresent()){
            meet = meetingRepository.findById(id).get();
            meet.setDate(date);
            return meetingRepository.save(meet);
        }
        else
        {
            return meet;
        }
    }
    
	 @PutMapping("/MeetingUpdateById/{id}")
	    public Meeting updateById(@PathVariable Long id,@RequestBody Meeting meet){
	        Meeting m = new Meeting();
	        if (meetingRepository.findById(id).isPresent()){
	            m = meetingRepository.findById(id).get();
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
	 
	 @GetMapping("/allNewMeets")
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

}
	  /*  @Transactional
		@PostMapping("/createMultipleMeeting/employee/{idemployee}/meeting")  
		public Meeting createMultipleMeeting(@PathVariable ("idemployee") long e,@RequestBody Meeting meet ) throws Exception      
		{  
		Optional<Employee> employees= employeeRepository.findById(e);
		
		Employee employee=employees.get();
		List<Child> child=(List<Child>) childRepository.findAll();		
		
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
	 
	 
	 /* <dependency>
     <groupId>org.springframework.boot</groupId>
     <artifactId>spring-boot-starter-thymeleaf</artifactId>
 </dependency>*/


/*  <dependency>
<groupId>org.apache.myfaces.core</groupId>
<artifactId>myfaces-impl</artifactId>
<version>2.3.3</version>
</dependency>
<dependency>
<groupId>org.apache.myfaces.core</groupId>
<artifactId>myfaces-api</artifactId>
<version>2.3.3</version>
</dependency>

<dependency>
<groupId>org.ocpsoft.rewrite</groupId>
<artifactId>rewrite-servlet</artifactId>
<version>3.4.2.Final</version>
</dependency>
<dependency>
<groupId>org.ocpsoft.rewrite</groupId>
<artifactId>rewrite-integration-faces</artifactId>
<version>3.4.2.Final</version>
</dependency>
<dependency>
<groupId>org.ocpsoft.rewrite</groupId>
<artifactId>rewrite-config-prettyfaces</artifactId>
<version>3.4.2.Final</version>
</dependency>
<dependency>
 <groupId>org.apache.tomcat.embed</groupId>
 <artifactId>tomcat-embed-jasper</artifactId>
 <version>10.0.4</version>
</dependency>

<dependency>
<groupId>org.primefaces</groupId>
<artifactId>primefaces</artifactId>
<version>6.1</version>
</dependency>
<dependency>
<groupId>org.projectlombok</groupId>
<artifactId>lombok</artifactId>
<version>1.16.16</version>
</dependency>
<dependency>
<groupId>org.glassfish</groupId>
<artifactId>javax.faces</artifactId>
<version>2.4.0</version>
</dependency>
<dependency>
<groupId>org.ocpsoft.rewrite</groupId>
<artifactId>rewrite-api-el</artifactId>
<version>3.4.2.Final</version>
<scope>provided</scope>
</dependency>

<dependency>
<groupId>org.ocpsoft.rewrite</groupId>
<artifactId>rewrite-config-annotations</artifactId>
<version>3.4.2.Final</version>
<scope>test</scope>
</dependency>*/


	 
	 
	 
	 /*<dependency>
			<groupId>org.apache.myfaces.core</groupId>
			<artifactId>myfaces-impl</artifactId>
			<version>2.2.12</version>
		</dependency>
		<dependency>
			<groupId>org.apache.myfaces.core</groupId>
			<artifactId>myfaces-api</artifactId>
			<version>2.2.12</version>
		</dependency>
		<dependency>
			<groupId>org.apache.tomcat.embed</groupId>
			<artifactId>tomcat-embed-jasper</artifactId>
		</dependency>
		<dependency>
			<groupId>org.ocpsoft.rewrite</groupId>
			<artifactId>rewrite-servlet</artifactId>
			<version>3.4.1.Final</version>
		</dependency>
		<dependency>
			<groupId>org.ocpsoft.rewrite</groupId>
			<artifactId>rewrite-integration-faces</artifactId>
			<version>3.4.1.Final</version>
		</dependency>
			<dependency>
<groupId>org.ocpsoft.rewrite</groupId>
<artifactId>rewrite-config-prettyfaces</artifactId>
<version>3.4.1.Final</version>
</dependency>
		<dependency>
			<groupId>org.primefaces</groupId>
			<artifactId>primefaces</artifactId>
			<version>6.1</version>
		</dependency>
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<version>1.16.16</version>
		</dependency>
	<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>jstl</artifactId>
    <version>1.2</version>
</dependency>*/
	 
	 
	 
	 }
