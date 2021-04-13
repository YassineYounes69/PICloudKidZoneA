package com.example.kidszonea4arctic3.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table( name = "Likes")
public class Likes implements Serializable {
	private static final long serialVersionUID = 1L;



	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private long id_likes; 
	
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
	public Likes(long id_likes, Employee employe, Publication publication, Parent parent) {
		super();
		this.id_likes = id_likes;
		this.employe = employe;
		this.publication = publication;
		this.parent = parent;
	}
	public Likes() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
