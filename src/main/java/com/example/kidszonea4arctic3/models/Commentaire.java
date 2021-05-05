package com.example.kidszonea4arctic3.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.ToString;


@Entity
@Table( name = "Commentaire")
@Data
@ToString(exclude = "Commentaire")
public class Commentaire  implements Serializable{


	

	/**
	 * 
	 */
	private static final long serialVersionUID = -1600290596005764244L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private long id; 
	 @JsonIgnore
	 @ManyToOne
	 private Employee employe;
	 @JsonIgnore
	 @ManyToOne
	 private Parent parent ; 
	 @JsonIgnore
	 @ManyToOne
	 private Publication publication;
	@Column(name="commentContent")
	private String commentContent;
	
	 @Column(name="date_com")
	 private LocalDateTime date_com ;


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

	public Commentaire(long id, Employee employe, Parent parent, Publication publication, LocalDateTime date_com) {
		super();
		this.id = id;
		this.employe = employe;
		this.parent = parent;
		this.publication = publication;
		this.date_com = date_com;
	}

	public Commentaire() {
		super();
	}

	public long getId_com() {
		return id;
	}

	public void setId_com(long id_com) {
		this.id = id_com;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Commentaire(long id, Employee employe, Parent parent, Publication publication, String commentContent,
			LocalDateTime date_com) {
		super();
		this.id= id;
		this.employe = employe;
		this.parent = parent;
		this.publication = publication;
		this.commentContent = commentContent;
		this.date_com = date_com;
	}

	@Override
	public String toString() {
		return "Commentaire [id=" + id + ", employe=" + employe + ", parent=" + parent + ", publication=" + publication
				+ ", commentContent=" + commentContent + ", date_com=" + date_com + "]";
	}

	
	 
	

}
