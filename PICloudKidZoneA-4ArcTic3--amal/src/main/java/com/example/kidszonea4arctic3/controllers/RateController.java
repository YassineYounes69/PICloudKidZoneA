package com.example.kidszonea4arctic3.controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.kidszonea4arctic3.models.Event;
import com.example.kidszonea4arctic3.models.Rate;
import com.example.kidszonea4arctic3.services.EventService;
import com.example.kidszonea4arctic3.services.RateService;


@RestController
public class RateController {
	@Autowired
	RateService rs;
	@Autowired
	EventService es;
	
	// http://localhost:8082/jardinEnfantEvents/servlet/ajouterRate/{event-id}
		@PostMapping("/ajouterRate/{event-id}") 
		@ResponseBody
		public void ajouterEvent(@RequestBody Rate r,@PathVariable("event-id") String idEvent)
		{
			Event e = es.retrieveEvent(Long.parseLong(idEvent)).get();
			Set<Event> setE = new HashSet<Event>();
			setE.add(e);
			r.setEvents(setE);
			//rs.addRate(r);
		}
	
		// http://localhost:8082/jardinEnfantEvents/servlet/calculerRate/{event-id}
		@GetMapping("/calculerRate/{event-id}")
		@ResponseBody
		public float calculerRate(@PathVariable("event-id") String eventId)
		{	
			Event e = es.retrieveEvent(Long.parseLong(eventId)).get();	
			Set<Rate> setR = new HashSet<Rate>();
			setR.addAll(e.getRates());
			float s = 0;
			

			for (Rate r : setR) {
			    s+=r.getValue();
			}
			return s/setR.size();	
		}
	
}
