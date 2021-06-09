package com.example.kidszonea4arctic3.services;
import java.util.List;
import java.util.Optional;

import com.example.kidszonea4arctic3.models.Category;
import com.example.kidszonea4arctic3.models.CategoryEvent;
import com.example.kidszonea4arctic3.models.Event;


public interface EventService {
	List<Event> retrieveAllEvents(Long idJardin);
	List<Event> retrieveAllEventsSortedByRate(Long idJardin);
	void addEvent(Event e);
	void deleteEvent(Long id);
	void updateEvent(Event e);
	void participateEvent(Long id);
	Optional<Event> retrieveEvent(Long id);	
	List<Event> searchByCategory(CategoryEvent category);	
}
