package com.example.kidszonea4arctic3.models;

import javax.persistence.*;

@Entity
public class Child {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fName;   //child first name
    private String lName;   //child last name
    private int age;    //child's age
    private String childPic;    //Child's picture, to be implemented in future releases

    @ManyToOne
    private Parent parent;  //child's parent on our platform
    //insert here child's childcare center


    public Child() {
    }
    
    

    public Child(String fName, String lName, int age, String childPic) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.age = age;
		this.childPic = childPic;
	}



	public Child(String fName, String lName, int age) {
        this.fName = fName;
        this.lName = lName;
        this.age = age;
    }

    public Child(String fName, String lName, int age, Parent parent) {
        this.fName = fName;
        this.lName = lName;
        this.age = age;
        this.parent = parent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getChildPic() {
        return childPic;
    }

    public void setChildPic(String childPic) {
        this.childPic = childPic;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

	





  
    
    
}
