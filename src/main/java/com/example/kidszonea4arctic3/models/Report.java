package com.example.kidszonea4arctic3.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name= "report")

public class Report implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7894616092283784794L;
	@EmbeddedId
	private ReportPK reportPK;
	@Column(name= "reportDate")
	private LocalDateTime reportDate;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "idParent", referencedColumnName = "id", insertable = false, updatable = false)
	private Parent parent;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "idEmployee", referencedColumnName = "id", insertable = false, updatable = false)
	private Employee employee;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "idPost", referencedColumnName = "id", insertable = false, updatable = false)
	private Publication publication;
	
	
	public Report(ReportPK reportPK, LocalDateTime reportDate, Parent parent, Employee employee,
			Publication publication) {
		super();
		this.reportPK = reportPK;
		this.reportDate = reportDate;
		this.parent = parent;
		this.employee = employee;
		this.publication = publication;
	}

	




	public ReportPK getReportPK() {
		return reportPK;
	}






	public void setReportPK(ReportPK reportPK) {
		this.reportPK = reportPK;
	}






	public LocalDateTime getReportDate() {
		return reportDate;
	}






	public void setReportDate(LocalDateTime reportDate) {
		this.reportDate = reportDate;
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






	public Publication getPublication() {
		return publication;
	}






	public void setPublication(Publication publication) {
		this.publication = publication;
	}






	public Report() {
		super();
	}








	
	
	
}