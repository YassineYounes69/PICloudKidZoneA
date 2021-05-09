package com.example.kidszonea4arctic3.controllers;

import com.example.kidszonea4arctic3.models.Parent;
import com.example.kidszonea4arctic3.repositories.ParentRepository;
import com.example.kidszonea4arctic3.services.ParentService;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@SessionScope
@Controller(value = "sessionController")
@ELBeanName(value = "sessionController")
public class SessionController {
    private Parent parent = new Parent();
    private boolean status=false;
    private String login;
    private String pw;


    @Autowired
    private ParentService parentService;

    @Autowired
    private ParentRepository parentRepository;

    public SessionController() {
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String logIn() throws NullPointerException {
        System.out.println("fired login with "+login+" "+pw);
        String navigateTo = "null";


        try {
        if (parentService.authenticate(login,pw)==null) {
            navigateTo="/index?faces-redirect=true";
            FacesMessage facesMessage =

                    new FacesMessage("Login Failed: please check your username/password and try again.");

            FacesContext.getCurrentInstance().addMessage("form:btn",facesMessage);
        } else {
            navigateTo = "/index?faces-redirect=true";
            this.setStatus(true);
            parent=parentService.authenticate(login, pw);
        } } catch (NullPointerException e) {
            System.out.println(e);
        }

        return navigateTo;
    }

    public String logOut() {
        System.out.println("fired logout method");
        String navigateTo = "/index?faces-redirect=true";
        this.setStatus(false);
        this.setParent(null);
        this.setLogin(null);
        this.setPw(null);
        return navigateTo;
    }

    public void refresh(){
        Long idUser=this.parent.getId();
        Parent refreshedParent = parentRepository.findById(idUser).get();
        this.setParent(refreshedParent);
    }
}
