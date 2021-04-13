package com.example.kidszonea4arctic3.models;

import javax.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String email;
    private String pw;
    private String fName; //first name
    private String lName; //Last name
    private Role role;

    @ManyToOne
    private ChildCareCenter ccc; //the childcare center that the employee works at

    private boolean availability; //specific attribute to Doctor role

    public Employee(String email, String pw, String fName, String lName) {
        this.email = email;
        this.pw = pw;
        this.fName = fName;
        this.lName = lName;
    }

    public enum Role {
        Director,  //This type of user can manage the childcare center and its employees
        ERResponsible, //This type of user can take appointments with parents and message them
        CommunityManager, //This type of user can manage posts
        Doctor, //This type of user can manage his appointments with templates.templates
    }

    public Employee() {
    }

    public Employee(String email, String pw, String fName, String lName, Role role, ChildCareCenter ccc) {
        this.email = email;
        this.pw = pw;
        this.fName = fName;
        this.lName = lName;
        this.role = role;
        this.ccc = ccc;
    }

    public Employee(String email, String pw, String fName, String lName, Role role, boolean availability, ChildCareCenter ccc) {
        this.email = email;
        this.pw = pw;
        this.fName = fName;
        this.lName = lName;
        this.role = role;
        this.availability = availability;
        this.ccc = ccc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isAvailable() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
}
