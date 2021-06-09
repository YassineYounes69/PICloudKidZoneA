package com.example.kidszonea4arctic3.controllers;

import java.util.Date;
import java.util.List;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.example.kidszonea4arctic3.models.Employee;
import com.example.kidszonea4arctic3.models.Mail;
import com.example.kidszonea4arctic3.models.Message;
import com.example.kidszonea4arctic3.models.Notification;
import com.example.kidszonea4arctic3.models.Parent;
import com.example.kidszonea4arctic3.models.Reclamation;
import com.example.kidszonea4arctic3.services.MessageService;
import com.example.kidszonea4arctic3.services.NotificationService;


@Controller(value = "notificationController")
@ELBeanName(value = "notificationController")
public class NotificationController {
	@Autowired
	NotificationService ns;
	
	@Autowired
	 private JavaMailSender javaMailSender;
	
	@Autowired
	MessageService ms;
	
	private List<Notification>list;
	private Notification n = new Notification();
	private Message mess = new Message();
	private Mail m = new Mail();
	private int frais;
	
	
	
	
	public String sendMessage(){
		mess.setParent(n.getParent());
		mess.setDirecteur(n.getDirecteur());
		mess.setDate_message(new Date());
		ms.addMessage(mess);
		return "listeNotification.xhtml?faces-redirect=true";
	}
	
	
	
	
	public String showSendMessage(Notification n1){
		n=n1;
		return "saveMessage.xhtml?faces-redirect=true";

	}




	public Message getMess() {
		return mess;
	}




	public void setMess(Message mess) {
		this.mess = mess;
	}




	public int getFrais() {
		return frais;
	}


	public void setFrais(int frais) {
		this.frais = frais;
	}


	public String sendMail(){
		SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(m.getTo());
        msg.setSubject(m.getSubject());
        msg.setText(m.getContent());
        javaMailSender.send(msg);
		return "listeNotification.xhtml?faces-redirect=true";
	}
	
	
	
	
	
	
	public Mail getM() {
		return m;
	}


	public void setM(Mail m) {
		this.m = m;
	}


	public Notification getN() {
		return n;
	}


	public void setN(Notification n) {
		this.n = n;
	}


	public void removeNotification(Long id){
		ns.DeleteNotification(id);
	}
	
	
	public void readNotification(Long id){
		ns.updateNotification(id);
	}
	
	public String showSendMail(Notification n1){
		n = n1;
		m.setTo(n.getParent().getEmail());
		return "send_mail.xhtml?faces-redirect=true";
	}
	
	
	
	
	

		public List<Notification> getList() {
			list = ns.retrieveAllNotification(Long.parseLong("1"));	
		return list;
	}

	public void setList(List<Notification> list) {
		this.list = list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// http://localhost:8082/jardinEnfant/servlet/retrieveAllNotification/{directeur-id}
		@GetMapping("/retrieveAllNotification/{directeur-id}")
		@ResponseBody
		public List<Notification> retrieveAllNotification(@PathVariable("directeur-id") String directeurId)
		{	
			return ns.retrieveAllNotification(Long.parseLong(directeurId));		
		}
	
		//http://localhost:8082/jardinEnfant/servlet/read-notification/1
		@PutMapping("/read-notification/{notification-id}")
	    @ResponseBody
	    public void modifyNotification(@PathVariable("notification-id") String notificationId) {
		   
			ns.updateNotification(Long.parseLong(notificationId));
	    }
	
		
		// http://localhost:8082/jardinEnfant/servlet/remove-reclamation/{reclamation-id}
		   @DeleteMapping("/remove-notification/{notification-id}")
		   @ResponseBody
		   public void removeNotification(@PathVariable("notification-id") String notificationId) {
		   ns.DeleteNotification(Long.parseLong(notificationId));
		   }

	
	
}
