package com.example.kidszonea4arctic3.models;


import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;


@Entity
@Table( name = "Publication")
public class Publication implements Serializable{
	
	
   


	private static final long serialVersionUID = -3594204396778234555L;


	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private long idpub; 
	

	 @Column(name="type_pub")
	 private String typ_epub ;
	 
	 @Column(name="date_pub")
	 private String date_epub ;
	 
	 @Column(name="titre_pub")
	 private String titre_pub ;
	 
	 @Column(name="is_visible")
	 private int is_visible ;
	 
	 @Column(name="views")
	 private int views ;
	 
	 @Column(name="likes")
	 private int likes ;
	 
	 @ManyToOne private Employee employe;
	 @ManyToOne private Parent parent ;
	 

	public Publication() {
		super();
	}

	public Publication(long idpub, String typ_epub, String date_epub, String titre_pub, int is_visible, int views,
			int likes, Employee employe, Parent parent) {
		super();
		this.idpub = idpub;
		this.typ_epub = typ_epub;
		this.date_epub = date_epub;
		this.titre_pub = titre_pub;
		this.is_visible = is_visible;
		this.views = views;
		this.likes = likes;
		this.employe = employe;
		this.parent = parent;
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

	public long getIdpub() {
		return idpub;
	}

	public void setIdpub(long idpub) {
		this.idpub = idpub;
	}

	public String getTyp_epub() {
		return typ_epub;
	}

	public void setTyp_epub(String typ_epub) {
		this.typ_epub = typ_epub;
	}

	public String getDate_epub() {
		return date_epub;
	}

	public void setDate_epub(String date_epub) {
		this.date_epub = date_epub;
	}

	public String getTitre_pub() {
		return titre_pub;
	}

	public void setTitre_pub(String titre_pub) {
		this.titre_pub = titre_pub;
	}

	public int getIs_visible() {
		return is_visible;
	}

	public void setIs_visible(int is_visible) {
		this.is_visible = is_visible;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}


	 
	 
	
}
