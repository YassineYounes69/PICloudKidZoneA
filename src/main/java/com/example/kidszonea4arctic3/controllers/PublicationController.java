package com.example.kidszonea4arctic3.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.kidszonea4arctic3.services.IPublicationService;
import com.example.kidszonea4arctic3.models.Publication;
@Controller
public class PublicationController {
	@Autowired
	IPublicationService ps;

	//http://localhost:8000/SpringMVC/servlet/readAllPublication
	@GetMapping("/readAllPublication")
	@ResponseBody
	public List<Publication> getPublications() {
		List<Publication> l = ps.readAllPublication();
		return l;
	}
	
	 // Ajouter publication : http://localhost:8000/SpringMVC/servlet/addPublication
	@PostMapping("/addPublication")
	@ResponseBody	
	public Publication addPublication(@RequestBody Publication p) {
	
		return ps.addPublication(p);
	}
	
	//http://localhost:8081/SpringMVC/servlet/deletePublication/{id}
	@DeleteMapping("/deletePublication/{id}")
	@ResponseBody
	public void deletePublication(@PathVariable("id") long id) {
		ps.deletePublication(id);
	}
	
	

	
}
