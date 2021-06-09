package com.example.kidszonea4arctic3.services;

import java.util.List;
import java.util.Optional;

import com.example.kidszonea4arctic3.models.Category;
import com.example.kidszonea4arctic3.models.Reclamation;



public interface ReclamationService {

	List<Reclamation> retrieveAllReclamations();
	List<Reclamation> searchRec(String msg);
	
	Reclamation addReclamation(Reclamation r);
	void deleteReclamation(Long id);
	void updateReclamation(Reclamation r);
	Optional<Reclamation> retrieveReclamation(Long id);	
	List<Reclamation> searchByCategory(Category category);	
	
}
