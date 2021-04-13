package com.example.kidszonea4arctic3.controllers;

import com.example.kidszonea4arctic3.models.Parent;
import com.example.kidszonea4arctic3.repositories.ParentRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class ParentController {
    private final ParentRepository parentRepository;

    public ParentController(ParentRepository parentRepository) {
        this.parentRepository = parentRepository;
    }

    @RequestMapping(value = "/Parents", method = RequestMethod.GET)
    public Iterable<Parent> getParents(){
        return parentRepository.findAll();
        // model.addAttribute("Parents",parentRepository.findAll());
        //return "Parents";
    }

    @RequestMapping(value = "/ParentAdd/{email}/{pw}/{fname}/{lname}/{pTel}", method = RequestMethod.GET)
    public Parent addParent(@PathVariable String email, @PathVariable String pw, @PathVariable String fname, @PathVariable String lname, @PathVariable int pTel){
        Parent parent = new Parent(email,pw,fname,lname,pTel,false);
        return parentRepository.save(parent);
    }

    @RequestMapping(value ="/ParentDelete/{id}", method = RequestMethod.GET)
    public String deleteParentById(@PathVariable Long id){
        Parent parent = new Parent();
        if (parentRepository.findById(id).isPresent()) {
            parent = parentRepository.findById(id).get();
            parentRepository.delete(parent);
            System.out.println("Parent Deleted");
            return "parent deleted";
        }
        else
        {
            System.out.println("Parent not found");
            return "parent not found";
        }
    }

    /*@RequestMapping(value = "/ParentUpdateById}", method = RequestMethod.GET)
    public List<Object> updateParentById(@RequestParam(value = "parentDTO") String parentDTO) throws JsonProcessingException {
        final Parent parent = new ObjectMapper().readValue(parentDTO,Parent.class);
        return Arrays.asList(
                parent.getId(),
                parent.getlName()
                );
        //System.out.println(parent);
        *//*if (parentRepository.findById(parent.getId()).isPresent()) {
            System.out.println("Parent Updated");
            return parentRepository.save(parent);
        }
        else
        {
            System.out.println("Parent not found");
            return parent;
        }*//*
    }*/

    @RequestMapping(value = "/ParentUpdateLastNameById/{id}/{LastName}", method = RequestMethod.GET)
    public Parent updateLastNameById(@PathVariable Long id,@PathVariable String LastName){
        Parent parent = new Parent();
        if (parentRepository.findById(id).isPresent()){
            parent = parentRepository.findById(id).get();
            parent.setlName(LastName);
            return parentRepository.save(parent);
        }
        else
        {
            return parent;
        }
    }

    @RequestMapping(value = "/ParentUpdateFirstNameById/{id}/{FirstName}", method = RequestMethod.GET)
    public Parent updateFirstNameById(@PathVariable Long id,@PathVariable String FirstName){
        Parent parent = new Parent();
        if (parentRepository.findById(id).isPresent()){
            parent = parentRepository.findById(id).get();
            parent.setfName(FirstName);
            return parentRepository.save(parent);
        }
        else
        {
            return parent;
        }
    }

    @RequestMapping(value = "/ParentUpdatePwById/{id}/{Pw}", method = RequestMethod.GET)
    public Parent updateLastPwById(@PathVariable Long id,@PathVariable String Pw){
        Parent parent = new Parent();
        if (parentRepository.findById(id).isPresent()){
            parent = parentRepository.findById(id).get();
            parent.setPw(Pw);
            return parentRepository.save(parent);
        }
        else
        {
            return parent;
        }
    }

    @RequestMapping(value = "/ParentUpdateEmailById/{id}/{Email}", method = RequestMethod.GET)
    public Parent updateLastEmailById(@PathVariable Long id,@PathVariable String Email){
        Parent parent = new Parent();
        if (parentRepository.findById(id).isPresent()){
            parent = parentRepository.findById(id).get();
            parent.setEmail(Email);
            return parentRepository.save(parent);
        }
        else
        {
            return parent;
        }
    }

    @RequestMapping(value = "/ParentActivate/{id}", method = RequestMethod.GET)
    public Parent parentActivate(@PathVariable Long id){
        Parent parent = new Parent();
        if (parentRepository.findById(id).isPresent()){
            parent = parentRepository.findById(id).get();
            parent.setAccStatus(true);
            return parentRepository.save(parent);
        }
        else
        {
            return parent;
        }
    }

    @RequestMapping(value = "/ParentDeactivate/{id}", method = RequestMethod.GET)
    public Parent parentDeactivate(@PathVariable Long id){
        Parent parent = new Parent();
        if (parentRepository.findById(id).isPresent()){
            parent = parentRepository.findById(id).get();
            parent.setAccStatus(false);
            return parentRepository.save(parent);
        }
        else
        {
            return parent;
        }
    }

    @RequestMapping(value = "/ParentUpdatePNById/{id}/{pn}", method = RequestMethod.GET)
    public Parent updatePNById(@PathVariable Long id,@PathVariable int pn){
        Parent parent = new Parent();
        if (parentRepository.findById(id).isPresent()){
            parent = parentRepository.findById(id).get();
            parent.setpTel(pn);
            return parentRepository.save(parent);
        }
        else
        {
            return parent;
        }
    }

}
