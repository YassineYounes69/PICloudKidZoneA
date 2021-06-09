package com.example.kidszonea4arctic3.controllers;

import com.example.kidszonea4arctic3.repositories.ChildCareCenterRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChildCareCenterController {

    private final ChildCareCenterRepository cccRepository;

    public ChildCareCenterController(ChildCareCenterRepository cccRepository) {
        this.cccRepository = cccRepository;
    }

    @RequestMapping("/CCCs")
    public String getCccs(Model model){

        model.addAttribute("CCCs",cccRepository.findAll());

        return "CCCs";
    }
}
