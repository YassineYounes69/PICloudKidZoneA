package com.example.kidszonea4arctic3.services;

import java.util.List;

import com.example.kidszonea4arctic3.models.Employee;
import com.example.kidszonea4arctic3.models.Parent;
import com.example.kidszonea4arctic3.models.Publication;

public interface IPublicationService {
	
	List<Publication> readAllPublication();
	Publication addPublication(Publication p);
	Publication updatePublication(Publication p)   ;
	void deletePublication(Long id);
	Publication RetrievePublication(long id) ;
	
    public Publication getPublicationById(int id);
	
	public int CountPublications();
	
	public List<Publication> getPublicationsByUserId(int id);
	
	public int CountPublicationsByUser(int id);
    
	public List<Publication> searchPublications(String text);
	
	public List<Publication> getPublicationsCommentedByUser(int id);
	
	public List<Publication> getPublicationsLikedByUser(int id);
	
	public String sharePublication(int idP) throws Exception;
	
	public String reportPublication(int idP) throws Exception;
	
	public boolean isReportExists(int idu, int idp);
	
	public List<Publication> getReportedPublications();
	
	public void approveReportedPublication(int idP);
	
	public List<String> detect(String photo) throws Exception;
	
	public List<Publication> getMyPublications() throws Exception;
	
	public Employee currentEmployee() throws Exception;
	public Parent currentParent() throws Exception;

	public List<Publication> getFollowingPublications() throws Exception;

	public Publication mostLikedPublication() throws Exception;

	public Publication mostCommentedPublication() throws Exception;

	public List<Publication> searchFollowingPublications(String pattern) throws Exception;

	public String detectText(String photo) throws Exception;
}
