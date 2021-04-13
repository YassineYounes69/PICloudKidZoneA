package com.example.kidszonea4arctic3.controllers;

import com.example.kidszonea4arctic3.models.Child;
import com.example.kidszonea4arctic3.models.Employee;
import com.example.kidszonea4arctic3.models.Parent;
import com.example.kidszonea4arctic3.repositories.EmployeeRepository;
import com.example.kidszonea4arctic3.repositories.ParentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @RequestMapping(value = "/Employees", method = RequestMethod.GET)
    public Iterable<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    @RequestMapping(value = "/Employeeadd/{email}/{pw}/{fName}/{lName}", method = RequestMethod.GET)
    public Employee addEmployee(@PathVariable String email, @PathVariable String pw, @PathVariable String fName, @PathVariable String lName){
        Employee employee = new Employee(email,pw,fName,lName);
        return employeeRepository.save(employee);
    }

    @RequestMapping(value ="/EmployeeDelete/{id}", method = RequestMethod.GET)
    public String deleteEmployeeById(@PathVariable Long id){
        Employee employee = new Employee();
        if (employeeRepository.findById(id).isPresent()) {
            employee = employeeRepository.findById(id).get();
            employeeRepository.delete(employee);
            System.out.println("employee Deleted");
            return "employee deleted";
        }
        else
        {
            System.out.println("employee not found");
            return "employee not found";
        }
    }
    @RequestMapping(value = "/EmployeeUpdateEmailById/{id}/{Email}", method = RequestMethod.GET)
    public Employee updateEmailById(@PathVariable Long id, @PathVariable String Email){
        Employee employee = new Employee();
        if (employeeRepository.findById(id).isPresent()){
            employee = employeeRepository.findById(id).get();
            employee.setEmail(Email);
            return employeeRepository.save(employee);
        }
        else
        {
            return employee;
        }
    }
    @RequestMapping(value = "/EmployeeUpdatePwById/{id}/{Email}", method = RequestMethod.GET)
    public Employee updatePwById(@PathVariable Long id, @PathVariable String pw){
        Employee employee = new Employee();
        if (employeeRepository.findById(id).isPresent()){
            employee = employeeRepository.findById(id).get();
            employee.setPw(pw);
            return employeeRepository.save(employee);
        }
        else
        {
            return employee;
        }
    }
    @RequestMapping(value = "/EmployeeUpdateFNameById/{id}/{fName}", method = RequestMethod.GET)
    public Employee updatefNameById(@PathVariable Long id, @PathVariable String fName){
        Employee employee = new Employee();
        if (employeeRepository.findById(id).isPresent()){
            employee = employeeRepository.findById(id).get();
            employee.setfName(fName);
            return employeeRepository.save(employee);
        }
        else
        {
            return employee;
        }
    }
    @RequestMapping(value = "/EmployeeUpdateLNameById/{id}/{lName}", method = RequestMethod.GET)
    public Employee updateLNameById(@PathVariable Long id, @PathVariable String lName){
        Employee employee = new Employee();
        if (employeeRepository.findById(id).isPresent()){
            employee = employeeRepository.findById(id).get();
            employee.setlName(lName);
            return employeeRepository.save(employee);
        }
        else
        {
            return employee;
        }
    }



}
