package com.example.kidszonea4arctic3.services;

import java.util.List;

import com.example.kidszonea4arctic3.models.Commentaire;
import com.example.kidszonea4arctic3.models.Employee;
import com.example.kidszonea4arctic3.models.Parent;
import com.example.kidszonea4arctic3.models.Publication;

public interface ICommentaireService {
	
	public String addCommentaire(Commentaire c, long idP) throws Exception;
	public String deleteCommentaire(long id) throws Exception;
	public String updateCommentaire(Commentaire c, long id) throws Exception;
	public List<Commentaire> getAllCommentaires();
	public Commentaire getCommentaireById(long id);
	public int CountCommentaires();
	public List<Commentaire> getCommentairesByUserId(long id);
	public int CountCommentairesByUser(long id);
	public List<Commentaire> getCommentairesByPostId(long idP);
	public int CountCommentairesByPost(long id);
    public List<Commentaire> searchCommentaires(String text);
	//public Parent currentParent() throws Exception;
	//public Employee currentEmployee() throws Exception;

	public List<Commentaire> getMyCommentaires() throws Exception;
	public Commentaire addC(Commentaire c) throws Exception;
	

}
