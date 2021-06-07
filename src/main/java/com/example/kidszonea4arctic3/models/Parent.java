package com.example.kidszonea4arctic3.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Parent {

//	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String email;
    private String pw;  //password
    private String fName; //first name
    private String lName;   //last name
    private int pTel;   //Parent Phone Number
    private boolean accStatus;  //Parent account status ( can be true or false )
    private String parentPic;   //Parent picture, to be implemented in future releases

    @OneToMany
    @JoinColumn(name = "parent_id" )
    private Set<Child> children = new HashSet<>();
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "parent", fetch = FetchType.EAGER)
	private Set<Report> reports;
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "parent", fetch = FetchType.EAGER)
	private Set<Child> kids;
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "parent")
	private Set<Publication> posts;
	
	  //@JsonManagedReference
   // @OneToMany(mappedBy="parent",cascade = CascadeType.PERSIST)
	@JsonIgnore
   // @OneToMany(mappedBy="parent",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @OneToMany(mappedBy="parent")
    private Set<Meeting>meetings=new HashSet<>(); //parent meetings
	
	
	  @JsonManagedReference
		//@JsonIgnore
	    @OneToMany(mappedBy="parent")
	    private Set<History>history=new HashSet<>(); //parent meetings
   
   

	public Set<History> getHistory() {
			return history;
		}


		public void setHistory(Set<History> history) {
			this.history = history;
		}


	@JsonManagedReference
	@JsonIgnore
    @OneToMany(mappedBy="parent")
    private Set<Feedback>feedbacks=new HashSet<>(); //parent feedbacks
	
	@JsonManagedReference
	@JsonIgnore
    @OneToMany(mappedBy="parent")
    private Set<BookMark>bookmarks=new HashSet<>(); //parent Bookmark
	
	

    public Set<BookMark> getBookmarks() {
		return bookmarks;
	}


	public void setBookmarks(Set<BookMark> bookmarks) {
		this.bookmarks = bookmarks;
	}


	public Parent() {
    }

    
    public Parent(String email, String pw, String fName, String lName, int pTel, boolean accStatus, String parentPic) {
		super();
		this.email = email;
		this.pw = pw;
		this.fName = fName;
		this.lName = lName;
		this.pTel = pTel;
		this.accStatus = accStatus;
		this.parentPic = parentPic;
	}


	public Parent(String email, String pw, String fName, String lName, int pTel, boolean accStatus) {
        this.email = email;
        this.pw = pw;
        this.fName = fName;
        this.lName = lName;
        this.pTel = pTel;
        this.accStatus = accStatus;
    }

    public Parent(String email, String pw, String fName, String lName, int pTel) {
        this.email = email;
        this.pw = pw;
        this.fName = fName;
        this.lName = lName;
        this.pTel = pTel;
       // this.accStatus = accStatus;
    }
    
    


    public Parent(Long id, String email, String pw, String fName, String lName, int pTel, boolean accStatus,
			String parentPic, Set<Report> reports, Set<Child> kids, Set<Publication> posts) {
		super();
		this.id = id;
		this.email = email;
		this.pw = pw;
		this.fName = fName;
		this.lName = lName;
		this.pTel = pTel;
		this.accStatus = accStatus;
		this.parentPic = parentPic;
		this.reports = reports;
		this.kids = kids;
		this.posts = posts;
	}


	public Set<Report> getReports() {
		return reports;
	}


	public void setReports(Set<Report> reports) {
		this.reports = reports;
	}


	public Set<Child> getKids() {
		return kids;
	}


	public void setKids(Set<Child> kids) {
		this.kids = kids;
	}


	public Set<Publication> getPosts() {
		return posts;
	}


	public void setPosts(Set<Publication> posts) {
		this.posts = posts;
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

    public int getpTel() {
        return pTel;
    }

    public void setpTel(int pTel) {
        this.pTel = pTel;
    }

    public boolean isAccStatus() {
        return accStatus;
    }

    public void setAccStatus(boolean accStatus) {
        this.accStatus = accStatus;
    }

    public String getParentPic() {
        return parentPic;
    }

    public void setParentPic(String parentPic) {
        this.parentPic = parentPic;
    }

 

    

	


	
	public Set<Meeting> getMeetings() {
		return meetings;
	}


	public void setMeetings(Set<Meeting> meetings) {
		this.meetings = meetings;
	}


	public Set<Feedback> getFeedbacks() {
		return feedbacks;
	}


	public void setFeedbacks(Set<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}


	




	


	@Override
	public String toString() {
		return "Parent [fName=" + fName + "]";
	}



  



    
}
