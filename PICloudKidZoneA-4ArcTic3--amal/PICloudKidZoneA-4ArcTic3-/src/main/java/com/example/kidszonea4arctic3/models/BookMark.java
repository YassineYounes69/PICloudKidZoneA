package com.example.kidszonea4arctic3.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class BookMark {

	    @JsonBackReference(value="feedback")
	    @ManyToOne
		@JoinColumn(name="feedback")
	    private Feedback feedback;
	    
	    
	    @JsonBackReference(value="parent")
	    @ManyToOne
		@JoinColumn(name="parent")
	    private Parent parent;

	    @Id
	    @GeneratedValue
	    private Long id;

	 
	

	    public Parent getParent() {
			return parent;
		}



		public void setParent(Parent parent) {
			this.parent = parent;
		}



		public String description;

	

	    public Feedback getFeedback() {
			return feedback;
		}



		public void setFeedback(Feedback feedback) {
			this.feedback = feedback;
		}



		public void setId(Long id) {
			this.id = id;
		}



		public void setDescription(String description) {
			this.description = description;
		}



		public Long getId() {
	        return id;
	    }

	

	    public String getDescription() {
	        return description;
	    }



		public BookMark() {
			super();
			// TODO Auto-generated constructor stub
		}



		public BookMark(Feedback feedback, Parent parent, String description) {
			super();
			this.feedback = feedback;
			this.parent = parent;
			this.description = description;
		}



		public BookMark(Feedback feedback, Long id, String description) {
			super();
			this.feedback = feedback;
			this.id = id;
			this.description = description;
		}



		public BookMark(Feedback feedback, String description) {
			super();
			this.feedback = feedback;
			this.description = description;
		}



		@Override
		public String toString() {
			return "BookMark [feedback=" + feedback + ", id=" + id + ", description=" + description + "]";
		}
	    
	    
	    
	}


