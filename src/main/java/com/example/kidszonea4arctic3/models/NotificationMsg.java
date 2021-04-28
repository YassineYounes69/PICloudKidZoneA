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
import javax.persistence.Transient;

@Entity
@Table(name = "notificationMsg")
public class NotificationMsg implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;

	@Column(name = "content")
	private String content;

	@Temporal(TemporalType.DATE)
	@Column(name = "createdAt")
	private Date createdAt;

	@Temporal(TemporalType.TIME)
	@Column(name = "time")
	private Date time;

	@Temporal(TemporalType.TIME)
	@Transient
	private Date timeChecked;

	@Column(name = "isRead")
	private boolean isRead;

	@ManyToOne
	@JoinColumn(name = "userSend")
	private Parent ParentSend;
	
	@ManyToOne
	@JoinColumn(name = "userReceive")
	private Parent ParentReceive;
	
	@ManyToOne
	@JoinColumn(name = "userSend")
	private Employee EmpSend;
	
	@ManyToOne
	@JoinColumn(name = "userReceive")
	private Employee EmpReceive;
	

	public NotificationMsg() {
		super();
		// TODO Auto-generated constructor stub
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public Date getTime() {
		return time;
	}


	public void setTime(Date time) {
		this.time = time;
	}


	public Date getTimeChecked() {
		return timeChecked;
	}


	public void setTimeChecked(Date timeChecked) {
		this.timeChecked = timeChecked;
	}


	public boolean isRead() {
		return isRead;
	}


	public void setRead(boolean isRead) {
		this.isRead = isRead;
	}


	public Parent getParentSend() {
		return ParentSend;
	}


	public void setParentSend(Parent parentSend) {
		ParentSend = parentSend;
	}


	public Parent getParentReceive() {
		return ParentReceive;
	}


	public void setParentReceive(Parent parentReceive) {
		ParentReceive = parentReceive;
	}


	public Employee getEmpSend() {
		return EmpSend;
	}


	public void setEmpSend(Employee empSend) {
		EmpSend = empSend;
	}


	public Employee getEmpReceive() {
		return EmpReceive;
	}


	public void setEmpReceive(Employee empReceive) {
		EmpReceive = empReceive;
	}


	public NotificationMsg(long id, String content, Date createdAt, Date time, Date timeChecked, boolean isRead,
			Parent parentSend, Parent parentReceive, Employee empSend, Employee empReceive) {
		super();
		this.id = id;
		this.content = content;
		this.createdAt = createdAt;
		this.time = time;
		this.timeChecked = timeChecked;
		this.isRead = isRead;
		ParentSend = parentSend;
		ParentReceive = parentReceive;
		EmpSend = empSend;
		EmpReceive = empReceive;
	}


	@Override
	public String toString() {
		return "NotificationMsg [id=" + id + ", content=" + content + ", createdAt=" + createdAt + ", time=" + time
				+ ", timeChecked=" + timeChecked + ", isRead=" + isRead + ", ParentSend=" + ParentSend
				+ ", ParentReceive=" + ParentReceive + ", EmpSend=" + EmpSend + ", EmpReceive=" + EmpReceive + "]";
	}
	
	
	
	
	

	


}
