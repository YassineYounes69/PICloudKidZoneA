package com.example.kidszonea4arctic3.controllers;

import com.example.kidszonea4arctic3.repositories.ParentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ParentController {
    private final ParentRepository parentRepository;

    public ParentController(ParentRepository parentRepository) {
        this.parentRepository = parentRepository;
    }

    @RequestMapping("/Parents")
    public String getParents(Model model){

        model.addAttribute("Parents",parentRepository.findAll());

        return "Parents";
    }
}
