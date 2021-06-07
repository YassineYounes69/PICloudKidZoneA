package com.example.kidszonea4arctic3.controllers;

import com.example.kidszonea4arctic3.models.Child;
import com.example.kidszonea4arctic3.models.ChildCareCenter;
import com.example.kidszonea4arctic3.repositories.ChildCareCenterRepository;
import com.example.kidszonea4arctic3.services.CccSpecification;
import com.example.kidszonea4arctic3.services.SearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.ManagedBean;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScope
@ManagedBean
@Controller
public class ChildCareCenterController {
    List<String> roles;

    @Autowired
    private ChildCareCenterRepository cccRepository;

    public ChildCareCenterController(ChildCareCenterRepository cccRepository) {
        this.cccRepository = cccRepository;
    }

    public ChildCareCenterController() {
        roles = new ArrayList<>();
        roles.add("Director");
        roles.add("ERResponsible");
        roles.add("CommunityManager");
        roles.add("Doctor");
    }


    public List<ChildCareCenter> getCccs(){
        return cccRepository.findAll();
    }

    public List<ChildCareCenter> searchWithCost(String key,String operation,Object value){
        CccSpecification spec = new CccSpecification(new SearchCriteria(key,operation,value));

        List<ChildCareCenter> results = cccRepository.findAll(spec);
        System.out.println(results.toString());
        return results;
    }

}
