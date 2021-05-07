package com.example.kidszonea4arctic3.controllers;

import com.example.kidszonea4arctic3.models.Parent;
import com.example.kidszonea4arctic3.repositories.ParentRepository;
import com.example.kidszonea4arctic3.services.ParentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Scope(value = "session")
@Controller(value = "parentController")
@ELBeanName(value = "parentController")
public class ParentController {

    @Autowired
    ParentService parentService;

    private List<Parent> parents;

    private Parent parent = new Parent();

    private final ParentRepository parentRepository;

    public ParentController(ParentRepository parentRepository) {
        this.parentRepository = parentRepository;
    }

    @RequestMapping(value = "/Parents", method = RequestMethod.GET)
    public Iterable<Parent> getParentsA(){
        return parentRepository.findAll();
        // model.addAttribute("Parents",parentRepository.findAll());
        //return "Parents";
    }

    public void addParent(){
        System.out.println("parent add method fired");
        parentService.addParent(parent);
    }

    public List<Parent> getParents() {
        parents = parentService.getAllParents();
        return parents;
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

    @RequestMapping(value="/updateWholeParent", method = RequestMethod.GET)
    @ResponseBody
    public Parent modifyWholeUser(Parent parent){
        Parent newParent = parentRepository.findById(parent.getId()).get();

        return parentRepository.save(parent);
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }
}
