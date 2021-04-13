package com.example.kidszonea4arctic3.models;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import java.util.Date;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.TemporalType;



@Entity
@Table( name = "Publication")
public class Publication implements Serializable{
	
	
   


	private static final long serialVersionUID = -3594204396778234555L;


	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private long idpub; 
	
	@Enumerated(EnumType.ORDINAL)  
	 @Column(name="TypePub")
	 private TypePub type_pub ;
	
	 @Temporal (TemporalType.DATE)
	 @Column(name="date_pub")
	 private Date date_pub ;
	 
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
	


	public TypePub getType_pub() {
		return type_pub;
	}


	public void setType_pub(TypePub type_pub) {
		this.type_pub = type_pub;
	}


	public Date getDate_epub() {
		return date_pub;
	}


	public void setDate_epub(Date date_epub) {
		this.date_pub = date_epub;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Publication(long idpub, TypePub type_pub, Date date_epub, String titre_pub, int is_visible, int views,
			int likes, Employee employe, Parent parent) {
		super();
		this.idpub = idpub;
		this.type_pub = type_pub;
		this.date_pub = date_epub;
		this.titre_pub = titre_pub;
		this.is_visible = is_visible;
		this.views = views;
		this.likes = likes;
		this.employe = employe;
		this.parent = parent;
	}

	public Publication(long idpub, TypePub type_pub, String titre_pub, int is_visible, int views,
			int likes, Employee employe, Parent parent) {
		super();
		this.idpub = idpub;
		this.type_pub = type_pub;
	    //this.date_epub = date_epub;
		this.titre_pub = titre_pub;
		this.is_visible = is_visible;
		this.views = views;
		this.likes = likes;
		this.employe = employe;
		this.parent = parent;
	}



	 
	 
	
}
