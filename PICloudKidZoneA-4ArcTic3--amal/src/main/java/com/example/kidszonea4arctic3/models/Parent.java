package com.example.kidszonea4arctic3.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table( name = "parent")

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
	
	 @OneToMany(mappedBy="parent")
	    private Set<Meeting>meetings=new HashSet<>(); //parent meetings
		
	 
	   @OneToMany(cascade = CascadeType.ALL, mappedBy="parent",fetch=FetchType.LAZY)
		private Set<Reclamation> reclamations;
		
		
		@OneToMany(cascade = CascadeType.ALL, mappedBy="parent",fetch=FetchType.LAZY)
		private Set<Notification> notifications;
		
		@OneToMany(cascade = CascadeType.ALL, mappedBy="parent",fetch=FetchType.LAZY)
		private Set<Message> messages;
		
		  @JsonManagedReference
			//@JsonIgnore
		    @OneToMany(mappedBy="parent")
		    private Set<History>history=new HashSet<>(); //parent meetings
	   
	   
		  
		  

		public Set<Reclamation> getReclamations() {
			return reclamations;
		}


		public void setReclamations(Set<Reclamation> reclamations) {
			this.reclamations = reclamations;
		}


		public Set<Notification> getNotifications() {
			return notifications;
		}


		public void setNotifications(Set<Notification> notifications) {
			this.notifications = notifications;
		}


		public Set<Message> getMessages() {
			return messages;
		}


		public void setMessages(Set<Message> messages) {
			this.messages = messages;
		}


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


	

	

    public Parent() {
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
			String parentPic, Set<Child> children, Set<Report> reports, Set<Child> kids, Set<Publication> posts) {
		super();
		this.id = id;
		this.email = email;
		this.pw = pw;
		this.fName = fName;
		this.lName = lName;
		this.pTel = pTel;
		this.accStatus = accStatus;
		this.parentPic = parentPic;
		this.children = children;
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

    public Set<Child> getChildren() {
        return children;
    }

    public void setChildren(Set<Child> children) {
        this.children = children;
    }


    

	


	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Parent other = (Parent) obj;
		if (accStatus != other.accStatus)
			return false;
		if (children == null) {
			if (other.children != null)
				return false;
		} else if (!children.equals(other.children))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (fName == null) {
			if (other.fName != null)
				return false;
		} else if (!fName.equals(other.fName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (kids == null) {
			if (other.kids != null)
				return false;
		} else if (!kids.equals(other.kids))
			return false;
		if (lName == null) {
			if (other.lName != null)
				return false;
		} else if (!lName.equals(other.lName))
			return false;
		
		if (pTel != other.pTel)
			return false;
		if (parentPic == null) {
			if (other.parentPic != null)
				return false;
		} else if (!parentPic.equals(other.parentPic))
			return false;
		if (posts == null) {
			if (other.posts != null)
				return false;
		} else if (!posts.equals(other.posts))
			return false;
		if (pw == null) {
			if (other.pw != null)
				return false;
		} else if (!pw.equals(other.pw))
			return false;
		if (reports == null) {
			if (other.reports != null)
				return false;
		} else if (!reports.equals(other.reports))
			return false;
		return true;
	}

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (accStatus ? 1231 : 1237);
		result = prime * result + ((children == null) ? 0 : children.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((fName == null) ? 0 : fName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((kids == null) ? 0 : kids.hashCode());
		result = prime * result + ((lName == null) ? 0 : lName.hashCode());
		result = prime * result + pTel;
		result = prime * result + ((parentPic == null) ? 0 : parentPic.hashCode());
		result = prime * result + ((posts == null) ? 0 : posts.hashCode());
		result = prime * result + ((pw == null) ? 0 : pw.hashCode());
		result = prime * result + ((reports == null) ? 0 : reports.hashCode());
		return result;
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


	public Parent(Long id, String email, String pw, String fName, String lName, int pTel, boolean accStatus,
			String parentPic, Set<Child> children, Set<Report> reports, Set<Child> kids, Set<Publication> posts,
			Set<Meeting> meetings, Set<History> history, Set<Feedback> feedbacks) {
		super();
		this.id = id;
		this.email = email;
		this.pw = pw;
		this.fName = fName;
		this.lName = lName;
		this.pTel = pTel;
		this.accStatus = accStatus;
		this.parentPic = parentPic;
		this.children = children;
		this.reports = reports;
		this.kids = kids;
		this.posts = posts;
		this.meetings = meetings;
		this.history = history;
		this.feedbacks = feedbacks;
	}

    


    
}
