package com.example.kidszonea4arctic3.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table( name = "Commentaire")
public class Commentaire  implements Serializable{


	

	/**
	 * 
	 */
	private static final long serialVersionUID = -1600290596005764244L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private long id_com; 
	 @JsonIgnore
	 @ManyToOne private Employee employe;
	 @JsonIgnore
	 @ManyToOne private Parent parent ;
	 @JsonIgnore
	 @ManyToOne private Publication publication;
	 
	 @Column(name="date_com")
	 private LocalDateTime date_com ;

	public long getIdcom() {
		return id_com;
	}

	public void setIdcom(long idcom) {
		this.id_com = idcom;
	}
	

	public Employee getEmploye() {
		return employe;
	}

	public void setEmploye(Employee employe) {
		this.employe = employe;
	}

	public Parent getParent() {
		return parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}

	public Publication getPublication() {
		return publication;
	}

	public void setPublication(Publication publication) {
		this.publication = publication;
	}


	public LocalDateTime getDate_com() {
		return date_com;
	}

	public void setDate_com(LocalDateTime date_com) {
		this.date_com = date_com;
	}

	public Commentaire(long idcom, Employee employe, Parent parent, Publication publication, LocalDateTime date_com) {
		super();
		this.id_com = idcom;
		this.employe = employe;
		this.parent = parent;
		this.publication = publication;
		this.date_com = date_com;
	}

	public Commentaire() {
		super();
	}
	 
	
	 
	

}
