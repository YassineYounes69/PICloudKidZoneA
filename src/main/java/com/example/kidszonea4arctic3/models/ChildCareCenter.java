package com.example.kidszonea4arctic3.models;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class ChildCareCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String descr; //CCC description
    private String logo; //logo of the CCC, to be implemented in the future releases
    //private Date creationDate;
    private int cccPNumber; //Childcare Center phone number
    private String adr; //CCC address
    private float cost; //CCC services cost

    @OneToMany
    @JoinColumn(name = "ccc_id" )
    private Set<Employee> employees = new HashSet<>();

    public ChildCareCenter() {
    }

    public ChildCareCenter(String desc, String logo, int cccPNumber, String adr, float cost) {
        this.descr = desc;
        this.logo = logo;
        this.cccPNumber = cccPNumber;
        this.adr = adr;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescr() { return descr; }

    public void setDescr(String desc) {
        this.descr = desc;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public int getCccPNumber() {
        return cccPNumber;
    }

    public void setCccPNumber(int cccPNumber) {
        this.cccPNumber = cccPNumber;
    }

    public String getAdr() {
        return adr;
    }

    public void setAdr(String adr) {
        this.adr = adr;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

}
