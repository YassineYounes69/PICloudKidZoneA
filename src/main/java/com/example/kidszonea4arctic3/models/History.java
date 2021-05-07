package com.example.kidszonea4arctic3.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.junit.jupiter.params.shadow.com.univocity.parsers.conversions.DateConversion;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters.LocalDateConverter;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters.LocalDateTimeConverter;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import ch.qos.logback.classic.pattern.DateConverter;

@Entity
public class History implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	
	@Column
    private String reason;
	
	@Column
	//@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date  date;
	
	
	@Column
    private boolean state;
	
	@Column
    private Type type;
	
	@JsonBackReference(value="parent")
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
	@JoinColumn(name="parent")
	private Parent parent;
	
	@JsonBackReference(value="employee")
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
	@JoinColumn(name="employee")
	private Employee employee;
    
  
	


	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Parent getParent() {
		return parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}



	public Employee getEmployee() {
		return employee;
	}



	public void setEmployee(Employee employee) {
		this.employee = employee;
	}



	public enum Type {
    	ReunionAllParents,  //all parents
    	ReunionSingelParents, //This type one parent

    }



	public History() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getReason() {
		return reason;
	}



	public void setReason(String reason) {
		this.reason = reason;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date  date) {
		this.date = date;
	}



	public boolean isState() {
		return state;
	}



	public void setState(boolean state) {
		this.state = state;
	}



	public Type getType() {
		return type;
	}



	public void setType(Type type) {
		this.type = type;
	}

	public History(long id, String reason, Date  date, boolean state, Type type, Parent parent, Employee employee) {
		super();
		this.id = id;
		this.reason = reason;
		this.date = date;
		this.state = state;
		this.type = type;
		this.parent = parent;
		this.employee = employee;
	}

	public History(String reason, Date  date, boolean state, Type type, Parent parent, Employee employee) {
		super();
		this.reason = reason;
		this.date = date;
		this.state = state;
		this.type = type;
		this.parent = parent;
		this.employee = employee;
	}
	

	@Override
	public String toString() {
		return "Meeting [id=" + id + ", reason=" + reason + ", date=" + date + ", state=" + state + ", type=" + type
				+ ", parent=" + parent + ", employee=" + employee + "]";
	}



    
    
}
