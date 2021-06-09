package com.example.kidszonea4arctic3.controllers;

import com.example.kidszonea4arctic3.repositories.EmployeeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmployeeController {
    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @RequestMapping("/Employees")
    public String getEmployees(Model model){

        model.addAttribute("Employees",employeeRepository.findAll());

        return "Employees";
    }

}
