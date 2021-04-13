package com.example.kidszonea4arctic3.controllers;

import com.example.kidszonea4arctic3.models.Child;
import com.example.kidszonea4arctic3.repositories.ChildRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class ChildController {
    private final ChildRepository childRepository;

    public ChildController(ChildRepository childRepository) {
        this.childRepository = childRepository;
    }

    @RequestMapping(value = "/childrenlist", method = RequestMethod.GET)
    public List<Child> getChildren(){
        /*Child newChild = new Child();
        List<Child> getChildrenFromDb=childRepository.findAll();
        Set<Child> newChildList = new HashSet<>();

        getChildrenFromDb.forEach(
                child -> newChildList.add(new Child(child.getId(),child.getfName(),child.getlName(),child.getAge()))
        );*/
        return childRepository.findAll();
        //model.addAttribute("children",childRepository.findAll());

        //return "childrenlist";
    }
}
