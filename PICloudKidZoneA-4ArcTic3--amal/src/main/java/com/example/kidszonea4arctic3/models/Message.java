package com.example.kidszonea4arctic3.models;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
@Entity
public class Message implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String content;
	private Date date_message;
	

	@ManyToOne
	Parent parent;
	
	
	@ManyToOne
	Employee directeur;
	
	public Message() {
		// TODO Auto-generated constructor stub
	}

	public Message(Long id, String content, Date date_message, Parent parent, Employee directeur) {
		super();
		this.id = id;
		this.content = content;
		this.date_message = date_message;
		this.parent = parent;
		this.directeur = directeur;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate_message() {
		return date_message;
	}

	public void setDate_message(Date date_message) {
		this.date_message = date_message;
	}

	public Parent getParent() {
		return parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}

	public Employee getDirecteur() {
		return directeur;
	}

	public void setDirecteur(Employee directeur) {
		this.directeur = directeur;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", content=" + content + ", date_message=" + date_message + ", parent=" + parent
				+ ", directeur=" + directeur + "]";
	}
	
	
	
	
	
	
	
	
}
