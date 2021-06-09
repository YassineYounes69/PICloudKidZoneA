package com.example.kidszonea4arctic3.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Reclamation implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	private String content;
	
	@Enumerated(EnumType.STRING)
	private Category category;
	
	@ManyToOne
	Parent parent;
	
	public Reclamation() {
		// TODO Auto-generated constructor stub
	}

	public Reclamation(Long id, String title, String content, Category category, Parent parent) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.category = category;
		this.parent = parent;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Parent getParent() {
		return parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}

	@Override
	public String toString() {
		return "Reclamations [id=" + id + ", title=" + title + ", content=" + content + ", category=" + category
				+ ", parent=" + parent + "]";
	}
	
	
	
	
	
}
