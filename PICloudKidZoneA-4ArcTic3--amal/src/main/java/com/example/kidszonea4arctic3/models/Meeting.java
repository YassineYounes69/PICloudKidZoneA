package com.example.kidszonea4arctic3.models;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
public class Meeting implements Serializable{

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
    @ManyToOne
	//@JsonIgnore                                  
	@JoinColumn(name="parent")
	private Parent parent;
	
	@JsonBackReference(value="employee")    
	@ManyToOne
	//@JsonIgnore
	@JoinColumn(name="employee")
	private Employee employee;
	

    

	public enum Type {
    	ReunionAllParents,  //all parents
    	ReunionSingelParents, //This type one parent

    }


	public Meeting(long id, boolean state, Parent parent) {
		super();
		this.id = id;
		this.state = state;
		this.parent = parent;
	}

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





	public Meeting() {
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



	public Meeting(long id, String reason, Date date, boolean state, Type type, Parent parent, Employee employee) {
		super();
		this.id = id;
		this.reason = reason;
		this.date = date;
		this.state = state;
		this.type = type;
		this.parent = parent;
		this.employee = employee;
	}

	public Meeting(String reason, Date  date, boolean state, Type type, Parent parent, Employee employee) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((reason == null) ? 0 : reason.hashCode());
		result = prime * result + (state ? 1231 : 1237);
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Meeting other = (Meeting) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id != other.id)
			return false;
		if (reason == null) {
			if (other.reason != null)
				return false;
		} else if (!reason.equals(other.reason))
			return false;
		if (state != other.state)
			return false;
		if (type != other.type)
			return false;
		return true;
	}


	



    
    
}
