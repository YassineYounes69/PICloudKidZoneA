package com.example.kidszonea4arctic3.controllers;

import com.example.kidszonea4arctic3.repositories.ChildRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ChildController {
    private final ChildRepository childRepository;

    public ChildController(ChildRepository childRepository) {
        this.childRepository = childRepository;
    }

    @RequestMapping(value = "/childrenlist", method = RequestMethod.GET)
    public String getChildren(Model model){

        model.addAttribute("children",childRepository.findAll());

        return "childrenlist";
    }
}
