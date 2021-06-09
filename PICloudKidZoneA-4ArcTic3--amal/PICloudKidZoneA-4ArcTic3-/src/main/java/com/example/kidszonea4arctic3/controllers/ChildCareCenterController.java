package com.example.kidszonea4arctic3.controllers;

import com.example.kidszonea4arctic3.repositories.ChildCareCenterRepository;
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

    @RequestMapping("/CCCs")
    public String getCccs(Model model){

        model.addAttribute("CCCs",cccRepository.findAll());

        return "CCCs";
    }
}
