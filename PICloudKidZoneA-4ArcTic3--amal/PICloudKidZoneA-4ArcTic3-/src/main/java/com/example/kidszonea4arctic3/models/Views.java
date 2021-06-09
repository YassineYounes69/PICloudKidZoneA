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
@Table( name = "Views")
public class Views implements Serializable {


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private long id_views; 
	
    @ManyToOne private Employee employe;
    @ManyToOne private Publication publication;
    @ManyToOne private Parent parent ;
    
	public long getId_views() {
		return id_views;
	}
	public void setId_views(long id_views) {
		this.id_views = id_views;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Views(long id_views, Employee employe, Publication publication, Parent parent) {
		super();
		this.id_views = id_views;
		this.employe = employe;
		this.publication = publication;
		this.parent = parent;
	}

	
	


}
