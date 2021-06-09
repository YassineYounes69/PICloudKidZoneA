package com.example.kidszonea4arctic3.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Notification implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String content;
	private String link;
	private Date date_notif;
	private boolean isRead;
	
	
	
	@ManyToOne
	Parent parent;
	
	
	@ManyToOne
	Employee directeur;
	
	public Notification() {
		// TODO Auto-generated constructor stub
	}


	public Notification(Long id, String name, String content, String link, Date date_notif, boolean isRead) {
		super();
		this.id = id;
		this.name = name;
		this.content = content;
		this.link = link;
		this.date_notif = date_notif;
		this.isRead = isRead;
	}
	
	


	public Notification(String name, String content, String link, Date date_notif, boolean isRead, Parent parent,
			Employee directeur) {
		super();
		this.name = name;
		this.content = content;
		this.link = link;
		this.date_notif = date_notif;
		this.isRead = isRead;
		this.parent = parent;
		this.directeur = directeur;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getLink() {
		return link;
	}


	public void setLink(String link) {
		this.link = link;
	}


	public Date getDate_notif() {
		return date_notif;
	}


	public void setDate_notif(Date date_notif) {
		this.date_notif = date_notif;
	}


	public boolean isRead() {
		return isRead;
	}


	public void setRead(boolean isRead) {
		this.isRead = isRead;
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
		return "Notification [id=" + id + ", name=" + name + ", content=" + content + ", link=" + link + ", date_notif="
				+ date_notif + ", isRead=" + isRead + "]";
	}
	
	
	
	
	
	
}
