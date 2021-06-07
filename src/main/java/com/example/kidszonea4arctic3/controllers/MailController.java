package com.example.kidszonea4arctic3.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.kidszonea4arctic3.models.Meeting;
import com.example.kidszonea4arctic3.repositories.MeetingRepository;
 
@Controller
public class MailController{
 
    @Autowired
    public JavaMailSender emailSender;
 
    
    @Autowired
    public MeetingController meetingController;
    
    @Autowired
    public MeetingRepository meetingRepository;
    
    @ResponseBody
    @RequestMapping("/sendSimpleEmail/{id}")
    public String sendSimpleEmail(@PathVariable ("id") long id) throws Exception {
 
        // Create a Simple MailMessage.
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(meetingController.getEmailParentByChild(id));
        message.setSubject("Meeting Alone");
        message.setText("you have meeting to confirme you must enter to the application to confirme the meeting");
 
        // Send Message!
        this.emailSender.send(message);
 
        return "Email Sent!";
    }
    
    @ResponseBody
    @RequestMapping("/sendSimpleEmailParent/{id}")
    public String sendSimpleEmailParent(@PathVariable ("id") long id) throws Exception {
 
        // Create a Simple MailMessage.
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(meetingController.getEmailParentById(id));
        message.setSubject("Meeting Alone");
        message.setText("you have meeting to confirme you must enter to the application to confirme the meeting");
 
        // Send Message!
        this.emailSender.send(message);
 
        return "Email Sent!";
    }
    
    
    @ResponseBody
    @RequestMapping("/sendMultipleEmail")
    public String sendMultipleEmail() throws Exception {
 
        // Create a Simple MailMessage.
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(meetingController.getAllEmailParent());
        message.setSubject("Meeting All Parents");
        message.setText("Heeeeeeeeeeeeeeeeeeeelp");
 
        // Send Message!
        this.emailSender.send(message);
 
        return "Email Sent!";
    }
 
 
}