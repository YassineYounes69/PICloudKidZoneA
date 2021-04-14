package com.example.kidszonea4arctic3.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kidszonea4arctic3.models.Employee;
import com.example.kidszonea4arctic3.models.Parent;
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

	@Override
	public int CountPublications() {
		// TODO Auto-generated method stub
		return 0;     

	}

	@Override
	public Publication getPublicationById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Publication> getPublicationsByUserId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int CountPublicationsByUser(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Publication> searchPublications(String text) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Publication> getPublicationsCommentedByUser(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Publication> getPublicationsLikedByUser(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String sharePublication(int idP) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String reportPublication(int idP) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isReportExists(int idu, int idp) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Publication> getReportedPublications() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void approveReportedPublication(int idP) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<String> detect(String photo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Publication> getMyPublications() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee currentEmployee() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Parent currentParent() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Publication> getFollowingPublications() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Publication mostLikedPublication() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Publication mostCommentedPublication() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Publication> searchFollowingPublications(String pattern) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String detectText(String photo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	}