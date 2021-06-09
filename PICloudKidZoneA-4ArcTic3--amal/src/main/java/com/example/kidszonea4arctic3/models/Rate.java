package com.example.kidszonea4arctic3.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
@Entity
public class Rate implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int value;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Event> events;
	
	
	public Rate() {
		// TODO Auto-generated constructor stub
	}


	public Rate(Long id, int value, Set<Event> events) {
		super();
		this.id = id;
		this.value = value;
		this.events = events;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public int getValue() {
		return value;
	}


	public void setValue(int value) {
		this.value = value;
	}


	public Set<Event> getEvents() {
		return events;
	}


	public void setEvents(Set<Event> events) {
		this.events = events;
	}


	@Override
	public String toString() {
		return "Rates [id=" + id + ", value=" + value + ", events=" + events + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
