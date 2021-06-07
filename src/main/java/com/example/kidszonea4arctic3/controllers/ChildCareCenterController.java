package com.example.kidszonea4arctic3.controllers;

import com.example.kidszonea4arctic3.models.ChildCareCenter;
import com.example.kidszonea4arctic3.models.Employee;
import com.example.kidszonea4arctic3.repositories.ChildCareCenterRepository;
import com.example.kidszonea4arctic3.repositories.EmployeeRepository;
import com.example.kidszonea4arctic3.services.ChildCareCenterService;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.faces.bean.SessionScoped;

@SessionScoped
@Controller(value = "childCareCenterController")
@ELBeanName(value = "childCareCenterController")
public class ChildCareCenterController {
    private ChildCareCenter childCareCenter = new ChildCareCenter();

    @Autowired
    private final ChildCareCenterService childCareCenterService;

    @Autowired
    private final ChildCareCenterRepository cccRepository;

    @Autowired
    private final EmployeeRepository employeeRepository;

    @Autowired
    private final SessionController sessionController;

    public ChildCareCenterController(ChildCareCenterService childCareCenterService, ChildCareCenterRepository cccRepository, SessionController sessionController, EmployeeRepository employeeRepository) {
        this.childCareCenterService = childCareCenterService;
        this.cccRepository = cccRepository;
        this.sessionController = sessionController;
        this.employeeRepository = employeeRepository;
    }

    @RequestMapping("/CCCs")
    public String getCccs(Model model){

        model.addAttribute("CCCs",cccRepository.findAll());

        return "CCCs";
    }

    public String addChildCareCenter(){
        System.out.println("ccc add method fired");

        Employee employee = sessionController.getEmployee();
        System.out.println("Got employee : "+employee);

        childCareCenterService.addChildCareCenter(childCareCenter);
        System.out.println(childCareCenter.toString());
        employeeRepository.updateEmployeeCcc(employee.getId(),childCareCenter);
        sessionController.setChildCareCenter(childCareCenter);
        //childCareCenterDashboard
        return "/pages/childCareCenterDashboard.xhtml?faces-redirect=true";

    }

    public String edit(){
        System.out.println("ccc edit method fired");


        childCareCenterService.addChildCareCenter(sessionController.getChildCareCenter());
        //sessionController.setChildCareCenter(childCareCenter);
        //childCareCenterDashboard
        return "/pages/childCareCenterDashboard.xhtml?faces-redirect=true";

    }

    public ChildCareCenter getChildCareCenter() {
        return childCareCenter;
    }

    public void setChildCareCenter(ChildCareCenter childCareCenter) {
        this.childCareCenter = childCareCenter;
    }
}
