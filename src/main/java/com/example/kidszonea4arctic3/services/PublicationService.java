package com.example.kidszonea4arctic3.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kidszonea4arctic3.models.Publication;
import com.example.kidszonea4arctic3.repositories.PublicationRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class PublicationService implements IPublicationService {
	@Autowired
	PublicationRepository PublicationRepository;
	
	private static final Logger L = LogManager.getLogger(IPublicationService.class);


	@Override
	public List<Publication> readAllPublication() {
		List<Publication> liste = (List<Publication>) PublicationRepository.findAll();
		return liste;
	}

	@Override
	public Publication addPublication(Publication p) {
		
		Publication cnt = PublicationRepository.save(p);
		return cnt;
	}

	@Override
	public Publication updatePublication(Publication p) {
		Publication up = PublicationRepository.save(p) ; 
		return up ;
	}

	@Override
	public void deletePublication (Long id) {
		PublicationRepository.deleteById(id);
	}

	@Override
	public Publication RetrievePublication(long id) {
		L.info("in RetreivePublication id=  " + id);
		Publication p = PublicationRepository.findById(id).get() ; 
		L.info("Publication returned = : " + p );
		return p;
	}
	
}