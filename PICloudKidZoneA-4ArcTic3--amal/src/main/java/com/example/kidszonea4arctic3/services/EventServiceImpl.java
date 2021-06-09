package com.example.kidszonea4arctic3.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kidszonea4arctic3.models.Category;
import com.example.kidszonea4arctic3.models.CategoryEvent;
import com.example.kidszonea4arctic3.models.Event;
import com.example.kidszonea4arctic3.repositories.EventRepository;

@Service
public class EventServiceImpl implements EventService{
	@Autowired
	EventRepository eventsRepository;
	@Override
	public List<Event> retrieveAllEvents(Long idJardin) {
		return eventsRepository.findByIdJardin(idJardin);
	}

	@Override
	public void addEvent(Event e) {
		eventsRepository.save(e);
		
	}

	@Override
	public void deleteEvent(Long id) {
		eventsRepository.deleteById(id);
		
	}

	@Override
	public void updateEvent(Event e) {
		eventsRepository.save(e);
		
	}

	@Override
	public void participateEvent(Long id) {
		eventsRepository.participer(id);
		
	}

	@Override
	public Optional<Event> retrieveEvent(Long id) {
		return eventsRepository.findById(id);
	}

	@Override
	public List<Event> searchByCategory(CategoryEvent category) {
		return eventsRepository.findByCategory(category);	 
	}

	@Override
	public List<Event> retrieveAllEventsSortedByRate(Long idJardin) {
		return eventsRepository.findByIdJardinSortedByRate(idJardin);
	}

}
