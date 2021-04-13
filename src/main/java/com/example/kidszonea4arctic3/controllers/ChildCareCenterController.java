package com.example.kidszonea4arctic3.controllers;

import com.example.kidszonea4arctic3.models.Child;
import com.example.kidszonea4arctic3.models.ChildCareCenter;
import com.example.kidszonea4arctic3.models.Parent;
import com.example.kidszonea4arctic3.repositories.ChildCareCenterRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class ChildCareCenterController {

    private final ChildCareCenterRepository cccRepository;

    public ChildCareCenterController(ChildCareCenterRepository cccRepository) {

        this.cccRepository = cccRepository;
    }

    @RequestMapping(value = "/CCCs", method = RequestMethod.GET)
    public Iterable<ChildCareCenter> getCccs(){
        return cccRepository.findAll();
    }
    @RequestMapping(value = "/CCCadd/{adr}/{cccPNumber}/{cost}/{descr}/{logo}", method = RequestMethod.GET)
    public ChildCareCenter addCCCs(@PathVariable String adr, @PathVariable int cccPNumber, @PathVariable float cost, @PathVariable String descr, @PathVariable String logo ){
        ChildCareCenter ChildCareCenter = new ChildCareCenter(descr,logo,cccPNumber,adr,cost);
        return cccRepository.save(ChildCareCenter);
    }
    @RequestMapping(value ="/CCCdelete/{id}", method = RequestMethod.GET)
    public String deleteCCCById(@PathVariable Long id){
        ChildCareCenter childCareCenter = new ChildCareCenter();
        if (cccRepository.findById(id).isPresent()) {
            childCareCenter = cccRepository.findById(id).get();
            cccRepository.delete(childCareCenter);
            System.out.println("Child Care Center Deleted");
            return "Child Care Center deleted";
        }
        else
        {
            System.out.println("Child Care Center not found");
            return "Child Care Center not found";
        }
    }
    @RequestMapping(value = "/ChildCareCenterUpdateAdrById/{id}/{adr}", method = RequestMethod.GET)
    public ChildCareCenter updateAdrById(@PathVariable Long id,@PathVariable String adr){
        ChildCareCenter childCareCenter = new ChildCareCenter();
        if (cccRepository.findById(id).isPresent()){
            childCareCenter = cccRepository.findById(id).get();
            childCareCenter.setAdr(adr);
            return cccRepository.save(childCareCenter);
        }
        else
        {
            return childCareCenter;
        }
    }

    @RequestMapping(value = "/ChildCareCenterUpdateNbrById/{id}/{cccPNumber}", method = RequestMethod.GET)
    public ChildCareCenter updateNbrById(@PathVariable Long id,@PathVariable int cccPNumber){
        ChildCareCenter childCareCenter = new ChildCareCenter();
        if (cccRepository.findById(id).isPresent()){
            childCareCenter = cccRepository.findById(id).get();
            childCareCenter.setCccPNumber(cccPNumber);
            return cccRepository.save(childCareCenter);
        }
        else
        {
            return childCareCenter;
        }
    }

    @RequestMapping(value = "/ChildCareCenterUpdateCostById/{id}/{cost}", method = RequestMethod.GET)
    public ChildCareCenter updateCostById(@PathVariable Long id,@PathVariable float cost){
        ChildCareCenter childCareCenter = new ChildCareCenter();
        if (cccRepository.findById(id).isPresent()){
            childCareCenter = cccRepository.findById(id).get();
            childCareCenter.setCost(cost);
            return cccRepository.save(childCareCenter);
        }
        else
        {
            return childCareCenter;
        }
    }

    @RequestMapping(value = "/ChildCareCenterUpdateDescById/{id}/{descr}", method = RequestMethod.GET)
    public ChildCareCenter updateDescById(@PathVariable Long id,@PathVariable String descr){
        ChildCareCenter childCareCenter = new ChildCareCenter();
        if (cccRepository.findById(id).isPresent()){
            childCareCenter = cccRepository.findById(id).get();
            childCareCenter.setDescr(descr);
            return cccRepository.save(childCareCenter);
        }
        else
        {
            return childCareCenter;
        }
    }
    @RequestMapping(value = "/ChildCareCenterUpdateLogoById/{id}/{logo}", method = RequestMethod.GET)
    public ChildCareCenter updateLogoById(@PathVariable Long id,@PathVariable String logo){
        ChildCareCenter childCareCenter = new ChildCareCenter();
        if (cccRepository.findById(id).isPresent()){
            childCareCenter = cccRepository.findById(id).get();
            childCareCenter.setLogo(logo);
            return cccRepository.save(childCareCenter);
        }
        else
        {
            return childCareCenter;
        }
    }
}
