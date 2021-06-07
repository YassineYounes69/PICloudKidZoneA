package com.example.kidszonea4arctic3.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table( name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String email;
    private String pw;
    private String fName; //first name
    private String lName; //Last name
    private Role role;
    @OneToMany
    @JoinColumn(name = "parent_id" )
    private Set<Child> children = new HashSet<>();
    
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "employee", fetch = FetchType.EAGER)
	private Set<Report> reports;

	
	//@JsonIgnore
	//@OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
	//private Set<Publication> publication;

    @ManyToOne
    private ChildCareCenter ccc; //the childcare center that the employee works at

    private boolean availability; //specific attribute to Doctor role
    public enum Role {
        Director,  //This type of user can manage the childcare center and its employees
        ERResponsible, //This type of user can take appointments with parents and message them
        CommunityManager, //This type of user can manage posts
        Doctor, //This type of user can manage his appointments with templates.templates
    }
  //@JsonManagedReference
    // @OneToMany(mappedBy="employee",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
     @OneToMany(mappedBy="employee")
     private Set<Meeting>meetings=new HashSet<>(); //employee meetings
 	  
      @JsonManagedReference
      @OneToMany(mappedBy="employee")
      private Set<History>history=new HashSet<>(); //employee meetings
     

     public Set<History> getHistory() {
 		return history;
 	}

 	public void setHistory(Set<History> history) {
 		this.history = history;
 	}

 	public Set<Meeting> getMeetings() {
 		return meetings;
 	}

 	public void setMeetings(Set<Meeting> meetings) {
 		this.meetings = meetings;
 	}

    public Employee() {
    }

    public Employee(String email, String pw, String fName, String lName, Role role, ChildCareCenter ccc) {
        this.email = email;
        this.pw = pw;
        this.fName = fName;
        this.lName = lName;
        this.role = role;
        this.ccc = ccc;
    }
    public Employee(String email, String pw, String fName, String lName, Role role) {
        this.email = email;
        this.pw = pw;
        this.fName = fName;
        this.lName = lName;
        this.role = role;
        
    }
    


    

	


	public Employee(Long id, String email, String pw, String fName, String lName, Role role, Set<Child> children,
			Set<Report> reports,  ChildCareCenter ccc,
			boolean availability) {
		super();
		this.id = id;
		this.email = email;
		this.pw = pw;
		this.fName = fName;
		this.lName = lName;
		this.role = role;
		this.children = children;
		this.reports = reports;
		
		this.ccc = ccc;
		this.availability = availability;
	}

	

	

	public ChildCareCenter getCcc() {
		return ccc;
	}

	public void setCcc(ChildCareCenter ccc) {
		this.ccc = ccc;
	}

	public boolean isAvailability() {
		return availability;
	}

	public Set<Child> getChildren() {
		return children;
	}

	public void setChildren(Set<Child> children) {
		this.children = children;
	}

	public Set<Report> getReports() {
		return reports;
	}

	public void setReports(Set<Report> reports) {
		this.reports = reports;
	}
	/*

	public Set<Publication> getPosts() {
		return publication;
	}

	public void setPosts(Set<Publication> posts) {
		this.publication = posts;
	}*/

	public Employee(String email, String pw, String fName, String lName, Role role, boolean availability, ChildCareCenter ccc) {
        this.email = email;
        this.pw = pw;
        this.fName = fName;
        this.lName = lName;
        this.role = role;
        this.availability = availability;
        this.ccc = ccc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isAvailable() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }


    
}
