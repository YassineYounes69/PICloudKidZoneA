package com.example.kidszonea4arctic3.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity
@Table(name= "notificationSNW")
public class NotificationSNW  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name= "id")
	private long idNotificationsnw;
	@Column(name= "subject")
	private String subject;
	@Column(name= "Date")
	private LocalDateTime date;
	@Column(name= "sender")
	private int sender;
	@Column(name= "receiver")
	private int receiver;
	@JsonIgnore
	@OneToOne(mappedBy="notificationsnw")
	private Commentaire comment;
	@JsonIgnore
	@OneToOne(mappedBy="notificationsnw")
	private Likes liking;
	public long getIdNotificationsnw() {
		return idNotificationsnw;
	}
	public void setIdNotificationsnw(long idNotificationsnw) {
		this.idNotificationsnw = idNotificationsnw;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public int getSender() {
		return sender;
	}
	public void setSender(int sender) {
		this.sender = sender;
	}
	public int getReceiver() {
		return receiver;
	}
	public void setReceiver(int receiver) {
		this.receiver = receiver;
	}
	public Commentaire getComment() {
		return comment;
	}
	public void setComment(Commentaire comment) {
		this.comment = comment;
	}
	public Likes getLiking() {
		return liking;
	}
	public void setLiking(Likes liking) {
		this.liking = liking;
	}
	public NotificationSNW(long idNotificationsnw, String subject, LocalDateTime date, int sender, int receiver,
			Commentaire comment, Likes liking) {
		super();
		this.idNotificationsnw = idNotificationsnw;
		this.subject = subject;
		this.date = date;
		this.sender = sender;
		this.receiver = receiver;
		this.comment = comment;
		this.liking = liking;
	}
	@Override
	public String toString() {
		return "NotificationSNW [idNotificationsnw=" + idNotificationsnw + ", subject=" + subject + ", date=" + date
				+ ", sender=" + sender + ", receiver=" + receiver + ", comment=" + comment + ", liking=" + liking + "]";
	}
	
	
	
	
	

}
