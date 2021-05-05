package com.example.kidszonea4arctic3.models;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.ToString;


@Entity
@Table( name = "publication")
@Data
@ToString(exclude = "Publication")
public class Publication implements Serializable{
	
	
	private static final long serialVersionUID = -1651293839698060258L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private long idpub; 
	
	@Enumerated(EnumType.ORDINAL)  
	 @Column(name="TypePub")
	 private TypePub type_pub ;
	@Column(name= "pubContent")
	private String pubContent;
	 @Column(name="date_pub")
	 private LocalDateTime date_pub ;
	 
	 @Column(name="titre_pub")
	 private String titre_pub ; 
	 
	 @Column(name="is_visible")
	 private int is_visible ;
	 
	 @Column(name="views")
	 private int views ;
	 
	 
	 @Column(name="src_pub")
	 private String src_pub ;
	 @JsonIgnore
	 @ManyToOne private Employee employe;
	 @JsonIgnore
	 @ManyToOne private Parent parent ; 
	 @JsonIgnore
    @OneToMany(mappedBy="publication",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@OrderBy("desc")
	 private List<Commentaire> comm = new ArrayList<Commentaire>();
	 
	 @JsonIgnore
	 @OneToMany(cascade = CascadeType.ALL, mappedBy = "publication", fetch= FetchType.EAGER)	
     private Set<Likes> likes = new HashSet<Likes>() ;
	 @JsonIgnore
		@OneToMany(cascade=CascadeType.ALL, mappedBy="publication")
		private Set<Report> reports;
		
	

	public Publication() {
		super();
	}




	public long getIdpub() {
		return idpub;
	}




	public void setIdpub(long idpub) {
		this.idpub = idpub;
	}




	public TypePub getType_pub() {
		return type_pub;
	}




	public void setType_pub(TypePub type_pub) {
		this.type_pub = type_pub;
	}




	public LocalDateTime getDate_pub() {
		return date_pub;
	}




	public void setDate_pub(LocalDateTime date_pub) {
		this.date_pub = date_pub;
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




	public String getSrc_pub() {
		return src_pub;
	}




	public void setSrc_pub(String src_pub) {
		this.src_pub = src_pub;
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









/*



*/

	public String getPubContent() {
		return pubContent;
	}




	public void setPubContent(String pubContent) {
		this.pubContent = pubContent;
	}




	public List<Commentaire> getComm() {
		return comm;
	}




	public void setComm(List<Commentaire> comm) {
		this.comm = comm;
	}




	public Set<Likes> getLikes() {
		return likes;
	}




	public void setLikes(Set<Likes> likes) {
		this.likes = likes;
	}




	public Set<Report> getReports() {
		return reports;
	}




	public void setReports(Set<Report> reports) {
		this.reports = reports;
	}







	public Publication(long idpub, TypePub type_pub, String pubContent, LocalDateTime date_pub, String titre_pub,
			int is_visible, int views, String src_pub, Employee employe, Parent parent, List<Commentaire> comm,
			Set<Likes> likes, Set<Report> reports) {
		super();
		this.idpub = idpub;
		this.type_pub = type_pub;
		this.pubContent = pubContent;
		this.date_pub = date_pub;
		this.titre_pub = titre_pub;
		this.is_visible = is_visible;
		this.views = views;
		this.src_pub = src_pub;
		this.employe = employe;
		this.parent = parent;
		this.comm = comm;
		this.likes = likes;
		this.reports = reports;
	}
	

	public Publication(long idpub,String pubContent, LocalDateTime date_pub, String src_pub,Parent parent ){
		super();
		this.idpub = idpub;
		this.pubContent = pubContent;
		this.date_pub = date_pub;
		
		this.src_pub = src_pub;
		this.parent = parent;
	
	}
	



	public Publication(long idpub,Parent parent , TypePub type_pub , String pubContent, LocalDateTime date_pub,String titre_pub, String src_pub ){
		super();
		this.idpub = idpub;
		this.pubContent = pubContent;
		this.date_pub = date_pub;
		this.type_pub=type_pub;
		this.titre_pub=titre_pub;
		this.src_pub = src_pub;
		this.parent = parent;
	
	}
	





	public Publication( TypePub type_pub, String pubContent, LocalDateTime date_pub, String titre_pub,
			 String src_pub, Parent parent) {
		super();
		this.type_pub = type_pub;
		this.pubContent = pubContent;
		this.date_pub = date_pub;
		this.titre_pub = titre_pub;
		this.src_pub = src_pub;
		this.parent = parent;

	}








	public Publication(Parent parent ,  TypePub type_pub, String pubContent, LocalDateTime date_pub, String titre_pub,
			 String src_pub) {
		super();
		this.type_pub = type_pub;
		this.pubContent = pubContent;
		this.date_pub = date_pub;
		this.titre_pub = titre_pub;
		this.src_pub = src_pub;
		this.parent=parent ; 

	}















	 
	 
	
}
