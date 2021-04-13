package com.example.kidszonea4arctic3.controllers;

import com.example.kidszonea4arctic3.models.Child;
import com.example.kidszonea4arctic3.models.ChildCareCenter;
import com.example.kidszonea4arctic3.repositories.ChildRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChildController {
    private final ChildRepository childRepository;

    public ChildController(ChildRepository childRepository) {
        this.childRepository = childRepository;
    }

    @RequestMapping(value = "/childrenlist", method = RequestMethod.GET)
    public Iterable<Child> getchildren(){
        return childRepository.findAll();
    }
    @RequestMapping(value = "/Childadd/{fName}/{lName}/{age}/{childPic}", method = RequestMethod.GET)
    public Child addChild(@PathVariable String fName, @PathVariable String lName, @PathVariable int age, @PathVariable String childPic ){
        Child Child = new Child(fName,lName,age,childPic);
        return childRepository.save(Child);
    }
    @RequestMapping(value ="/ChildDelted/{id}", method = RequestMethod.GET)
    public String DeleteChildById(@PathVariable Long id){
        Child child = new Child();
        if (childRepository.findById(id).isPresent()) {
            child = childRepository.findById(id).get();
            childRepository.delete(child);
            System.out.println("Child Deleted");
            return "Child deleted";
        }
        else
        {
            System.out.println("Child not found");
            return "Child not found";
        }
    }
    @RequestMapping(value = "/ChildUpdateFNameById/{id}/{fName}", method = RequestMethod.GET)
    public Child updateFnameById(@PathVariable Long id, @PathVariable String fName){
        Child child = new Child();
        if (childRepository.findById(id).isPresent()){
            child = childRepository.findById(id).get();
            child.setfName(fName);
            return childRepository.save(child);
        }
        else
        {
            return child;
        }
    }
    @RequestMapping(value = "/ChildUpdateLNameById/{id}/{lName}", method = RequestMethod.GET)
    public Child updateLnameById(@PathVariable Long id, @PathVariable String lName){
        Child child = new Child();
        if (childRepository.findById(id).isPresent()){
            child = childRepository.findById(id).get();
            child.setlName(lName);
            return childRepository.save(child);
        }
        else
        {
            return child;
        }
    }
    @RequestMapping(value = "/ChildUpdateAgeById/{id}/{age}", method = RequestMethod.GET)
    public Child updateAgeById(@PathVariable Long id, @PathVariable int age){
        Child child = new Child();
        if (childRepository.findById(id).isPresent()){
            child = childRepository.findById(id).get();
            child.setAge(age);
            return childRepository.save(child);
        }
        else
        {
            return child;
        }
    }
    @RequestMapping(value = "/ChildUpdateChildPicById/{id}/{childPic}", method = RequestMethod.GET)
    public Child updateChildPicById(@PathVariable Long id, @PathVariable String childPic){
        Child child = new Child();
        if (childRepository.findById(id).isPresent()){
            child = childRepository.findById(id).get();
            child.setChildPic(childPic);
            return childRepository.save(child);
        }
        else
        {
            return child;
        }
    }
}
