package com.example.kidszonea4arctic3.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name= "notification")
public class Notification implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name= "id")
	private int idNotif;
	@Column(name= "subject")
	private String subject;
	@Column(name= "description")
	private String description;
	@Temporal(TemporalType.DATE)
	@Column(name= "date")
	private Date date;
	@Temporal(TemporalType.TIME)
	@Column(name= "time")
	private Date time;
	
	private String status;
	
	
	private String target ;
	@JsonIgnore
	@ManyToOne
	private  Parent parent;
	@JsonIgnore
	@ManyToOne
	private  Employee employee;
	
	@JsonIgnore
	@ManyToOne private Publication publication;

	
	public Notification() {
		super();
	}

	public int getIdNotif() {
		return idNotif;
	}

	public void setIdNotif(int idNotif) {
		this.idNotif = idNotif;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
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

	public Publication getPublication() {
		return publication;
	}

	public void setPublication(Publication publication) {
		this.publication = publication;
	}

	public Notification(int idNotif, String subject, String description, Date date, Date time, String status,
			String target, Parent parent, Employee employee, Publication publication) {
		super();
		this.idNotif = idNotif;
		this.subject = subject;
		this.description = description;
		this.date = date;
		this.time = time;
		this.status = status;
		this.target = target;
		this.parent = parent;
		this.employee = employee;
		this.publication = publication;
	}

	@Override
	public String toString() {
		return "Notification [idNotif=" + idNotif + ", subject=" + subject + ", description=" + description + ", date="
				+ date + ", time=" + time + ", status=" + status + ", target=" + target + ", parent=" + parent
				+ ", employee=" + employee + ", publication=" + publication + "]";
	}


	
	
	

	
	
	
	

}
