package com.example.kidszonea4arctic3.services;

import java.util.Iterator;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kidszonea4arctic3.models.Event;
import com.example.kidszonea4arctic3.models.Rate;
import com.example.kidszonea4arctic3.repositories.RateRepository;


@Service
public class RateServiceImpl implements RateService{
	@Autowired
	RateRepository rateRepository;

	@Override
	public void addRateMeth(Rate r) {
		Set<Event> se =  r.getEvents();
		Iterator iter = se.iterator();

		Event first = (Event) iter.next();
		
		 System.out.println("new rate value : "+r.getValue());
		rateRepository.addRate(r.getValue());
		Long id = rateRepository.retrieveLastRate().getId();
		 System.out.println("new rate id : "+id);
		 System.out.println("new event id : "+first.getId());
		rateRepository.addRateEvent(id, first.getId());
	}

}
