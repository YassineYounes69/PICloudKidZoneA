package com.example.kidszonea4arctic3.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table( name = "Likes")
public class Likes implements Serializable {

	private static final long serialVersionUID = 1056884502381549146L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private long id_likes; 
	@Column(name= "likeDate")
	private LocalDateTime likeDate;
    @ManyToOne private Employee employe;
    @ManyToOne private Publication publication;
    @ManyToOne private Parent parent ;
	public long getId_likes() {
		return id_likes;
	}
	public void setId_likes(long id_likes) {
		this.id_likes = id_likes;
	}
	public Employee getEmploye() {
		return employe;
	}
	public void setEmploye(Employee employe) {
		this.employe = employe;
	}
	public Publication getPublication() {
		return publication;
	}
	public void setPublication(Publication publication) {
		this.publication = publication;
	}
	public Parent getParent() {
		return parent;
	}
	public void setParent(Parent parent) {
		this.parent = parent;
	}

	public Likes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LocalDateTime getLikeDate() {
		return likeDate;
	}
	public void setLikeDate(LocalDateTime likeDate) {
		this.likeDate = likeDate;
	}
	public Likes(long id_likes, LocalDateTime likeDate, Employee employe, Publication publication, Parent parent) {
		super();
		this.id_likes = id_likes;
		this.likeDate = likeDate;
		this.employe = employe;
		this.publication = publication;
		this.parent = parent;
	}

    
}
