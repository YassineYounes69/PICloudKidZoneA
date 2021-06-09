package com.example.kidszonea4arctic3.services;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kidszonea4arctic3.models.Category;
import com.example.kidszonea4arctic3.models.Reclamation;
import com.example.kidszonea4arctic3.repositories.ReclamationRepository;


@Service
public class ReclamationServiceImpl implements ReclamationService{

	@Autowired
	ReclamationRepository reclamationRepository;
	
	public static final Logger l= LogManager.getLogger(ReclamationServiceImpl.class);

	
	
	@Override
	public List<Reclamation> retrieveAllReclamations() {
		List<Reclamation> reclamations = (List<Reclamation>)reclamationRepository.findAll(); 
		for  (Reclamation reclamation : reclamations) {
			l.info("reclamation +++ : "+reclamation);		
		}
		return reclamations;
	}

	@Override
	public Reclamation addReclamation(Reclamation r) {
		return this.reclamationRepository.save(r);
	}

	@Override
	public void deleteReclamation(Long id) {
		this.reclamationRepository.deleteById(id);
	}

	@Override
	public void updateReclamation(Reclamation r) {
		 this.reclamationRepository.save(r);
	}

	@Override
	public Optional<Reclamation> retrieveReclamation(Long id) {
		return this.reclamationRepository.findById(id);
	}

	@Override
	public List<Reclamation> searchByCategory(Category category) {
		return this.reclamationRepository.findByCategory(category);
	}

	@Override
	public List<Reclamation> searchRec(String msg) {

		return this.reclamationRepository.searchReclamation(msg);

	
	}

}
