package com.example.kidszonea4arctic3.controllers;

import java.util.Date;
import java.util.List;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.kidszonea4arctic3.models.Employee;
import com.example.kidszonea4arctic3.models.Message;
import com.example.kidszonea4arctic3.models.Notification;
import com.example.kidszonea4arctic3.models.Parent;
import com.example.kidszonea4arctic3.services.DirecteurService;
import com.example.kidszonea4arctic3.services.MessageService;
import com.example.kidszonea4arctic3.services.ParentService;

@Controller(value = "messageController")
@ELBeanName(value = "messageController")
public class MessageController {
	@Autowired
	MessageService ms;
	@Autowired
	DirecteurService ds;
	@Autowired
	ParentService ps;

	private List<Message> list;
	private Message m = new Message();


	public List<Message> getList() {
		list = ms.retrieveAllMessages(Long.parseLong("1"));
		return list;
	}

	public void setList(List<Message> list) {
		this.list = list;
	}

	public Message getM() {
		return m;
	}

	public void setM(Message m) {
		this.m = m;
	}
	
	
	
	public void removeMessage(Long id){
		ms.deleteMessage(id);
	}
	
	
	
	
	
	
	
	// http://localhost:8082/jardinEnfant/servlet/retrieveAllMessages/{directeur-id}

	@GetMapping("/retrieveAllMessages/{parent-id}") // pour que le parent puisse
													// consulter les messages de
													// directeur
	@ResponseBody
	public List<Message> retrieveAllMessages(@PathVariable("parent-id") String idParent) {
		return ms.retrieveAllMessages(Long.parseLong(idParent));
	}

	// http://localhost:8082/jardinEnfant/servlet/ajouterMessage/{parent-id}/{directeur-id}

	@PostMapping("/ajouterMessage/{parent-id}/{directeur-id}") // pour que le
																// directeur
																// puisse
																// ajouter un
																// message en
																// repandant à
																// la
																// reclamation
																// de parent
	@ResponseBody
	public void ajouterMessage(@RequestBody Message m, @PathVariable("parent-id") String idPrent,
			@PathVariable("directeur-id") String idDirecteur) {
		Parent p = ps.retrieveParent(Long.parseLong(idPrent)).get();
		Employee d = ds.retrieveDirecteur(Long.parseLong(idDirecteur)).get();
		m.setParent(p);
		m.setDirecteur(d);
		m.setDate_message(new Date());
		ms.addMessage(m);
	}

	// http://localhost:8082/jardinEnfant/servlet/remove-message/{message-id}
	@DeleteMapping("/remove-message/{message-id}") // pour que le parent puisse
													// supprimer les messages de
													// directeur apres les
													// consulter
	@ResponseBody
	public void removeMessage(@PathVariable("message-id") String id) {
		ms.deleteMessage(Long.parseLong(id));
	}

}
