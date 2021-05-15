package com.example.kidszonea4arctic3.services;

import java.util.List;

import com.example.kidszonea4arctic3.models.Parent;
import com.example.kidszonea4arctic3.models.Publication;

public interface IPublicationService {
	
	List<Publication> readAllPublication();
	//public Parent currentParent() throws Exception ;
	Publication addPublication(Publication p);
	String addPublicationMsg(Publication p) throws Exception;
	String updatePublicationMsg(Publication p , long id) throws Exception  ;
	public int CountPublications();
    Publication updatePublication(Publication p)   ;
	void deletePublication(Long id);
	Publication RetrievePublication(long id) ;
    public Publication getPublicationById(long id);
	public List<Publication> getPublicationsByUserId(long id);
	public long CountPublicationsByUser(long id);
	public List<Publication> getMyPublications() throws Exception;
	public List<Publication> getALLPublications() throws Exception;
	public List<String> detect(String photo) throws Exception;
	public String detectText(String photo) throws Exception;
	public List<Publication> searchPublications(String text);
	public String sharePublication(long idP) throws Exception;
	public String reportPublication(long idP) throws Exception;
	public boolean isReportExists(long idu, long idp);
	public List<Publication> getReportedPublications();
	public void approveReportedPublication(int idP);
	public List<Publication> getPublicationsCommentedByUser(int id);
	public List<Publication> getPublicationsLikedByUser(int id ) ;

	public Publication mostLikedPublication() throws Exception;
	public Publication mostCommentedPublication() throws Exception;
	public Publication advancedSearsh(String motif) ;
	long addorupdatepost(Publication pp);
	List<Publication> searchP(String pattern);



}
