package com.example.kidszonea4arctic3.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String email;
    private String pw;
    private String fName; //first name
    private String lName; //Last name
    private String role;


    public Employee() {
    }

    @ManyToOne
    private ChildCareCenter ccc; //the childcare center that the employee works at

    private boolean availability; //specific attribute to Doctor role






    public Employee(String email, String pw, String fName, String lName, String role, boolean availability, ChildCareCenter ccc) {
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isAvailable() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
}
