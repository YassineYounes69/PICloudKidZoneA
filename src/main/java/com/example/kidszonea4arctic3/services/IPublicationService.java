package com.example.kidszonea4arctic3.services;

import java.util.List;

import com.example.kidszonea4arctic3.models.Publication;

public interface IPublicationService {
	List<Publication> readAllPublication();
	Publication addPublication(Publication p);
	Publication updatePublication(Publication p);
	void deletePublication(Long id);
	Publication RetrievePublication(long id) ;
}
