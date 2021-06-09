package com.example.kidszonea4arctic3.models;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Feedback implements Serializable{
	
	
private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	
	@Column
    private String feedback;
	
	
	@JsonBackReference(value="parent")
	@ManyToOne
	@JoinColumn(name="parent")
	private Parent parent;
	
	@JsonBackReference(value="childCareCenter")
	@ManyToOne
	@JoinColumn(name="childCareCenter")
	private ChildCareCenter childCareCenter;
	
	
	//@JsonManagedReference
    //@OneToMany(mappedBy="feedback")
  //  private Set<BookMark>bookarks=new HashSet<>(); //parent feedbacks

	
	
	
	
/*
	public Set<BookMark> getBookarks() {
		return bookarks;
	}

	public void setBookarks(Set<BookMark> bookarks) {
		this.bookarks = bookarks;
	}*/

	public Feedback(String feedback, Parent parent, ChildCareCenter childCareCenter) {
		super();
		this.feedback = feedback;
		this.parent = parent;
		this.childCareCenter = childCareCenter;
	}

	public Feedback(long id, String feedback, Parent parent, ChildCareCenter childCareCenter) {
		super();
		this.id = id;
		this.feedback = feedback;
		this.parent = parent;
		this.childCareCenter = childCareCenter;
	}

	public Feedback() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public Parent getParent() {
		return parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}

	public ChildCareCenter getChildCareCenter() {
		return childCareCenter;
	}

	public void setChildCareCenter(ChildCareCenter childCareCenter) {
		this.childCareCenter = childCareCenter;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
	public String toString() {
		return "Feedback [id=" + id + ", feedback=" + feedback + ", parent=" + parent + ", childCareCenter="
				+ childCareCenter + "]";
	}

    
  

}
