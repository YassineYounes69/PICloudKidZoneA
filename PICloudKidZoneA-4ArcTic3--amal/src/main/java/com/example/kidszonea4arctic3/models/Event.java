package com.example.kidszonea4arctic3.models;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")

@Entity
public class Event implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date_event;
	private String name;
	private String description;
	
	@Lob 
	@Column(name="image", length=512)
	private String image;
	private int nb_participants;
	
	@Transient
	private float totalRates;
	
	
	@Transient
	private String imagePath;
	
	@Transient
	private int rateValue;
	
	
	
	@Enumerated(EnumType.STRING)
	private CategoryEvent category;
	
	@ManyToMany(mappedBy="events", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Set<Rate> rates;
	

	
	@ManyToOne
	ChildCareCenter childCareCenter;
	
	public Event() {
		// TODO Auto-generated constructor stub
	}

	



	

	public Event(Long id, Date date_event, String name, String description, String image, int nb_participants,
			CategoryEvent category, Set<Rate> rates, ChildCareCenter jardin_enfant) {
		super();
		this.id = id;
		this.date_event = date_event;
		this.name = name;
		this.description = description;
		this.image = image;
		this.nb_participants = nb_participants;
		this.category = category;
		this.rates = rates;
		this.childCareCenter = jardin_enfant;
	}

	public Event( Date date_event, String name, String description, String image, int nb_participants,
			CategoryEvent category, ChildCareCenter jardin_enfant) {
		super();
		this.date_event = date_event;
		this.name = name;
		this.description = description;
		this.image = image;
		this.nb_participants = nb_participants;
		this.category = category;
		this.childCareCenter = jardin_enfant;
	}



	


	public int getRateValue() {
		return rateValue;
	}







	public void setRateValue(int rateValue) {
		this.rateValue = rateValue;
	}







	public Set<Rate> getRates() {
		return rates;
	}



	public void setRates(Set<Rate> rates) {
		this.rates = rates;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate_event() {
		return date_event;
	}

	public void setDate_event(Date date_event) {
		this.date_event = date_event;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public ChildCareCenter getJardin_enfant() {
		return childCareCenter;
	}

	public void setJardin_enfant(ChildCareCenter jardin_enfant) {
		this.childCareCenter = jardin_enfant;
	}

	
	
	public int getNb_participants() {
		return nb_participants;
	}

	public void setNb_participants(int nb_participants) {
		this.nb_participants = nb_participants;
	}

	public CategoryEvent getCategory() {
		return category;
	}

	public void setCategory(CategoryEvent category) {
		this.category = category;
	}

	
	
	
	







	public ChildCareCenter getChildCareCenter() {
		return childCareCenter;
	}







	public void setChildCareCenter(ChildCareCenter childCareCenter) {
		this.childCareCenter = childCareCenter;
	}







	@Override
	public String toString() {
		return "Events [id=" + id + ", date_event=" + date_event + ", name=" + name + ", description=" + description
				+ ", image=" + image + ", nb_participants=" + nb_participants + ", category=" + category
				+ ", childCareCenter=" + childCareCenter + "]";
	}







	public String getImagePath() {
		return "/event-photos/"+image;
	}







	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}







	public float getTotalRates() {
		return totalRates;
	}







	public void setTotalRates(float totalRates) {
		this.totalRates = totalRates;
	}

	
	
	
	
	
	
	
}
