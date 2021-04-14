package com.example.kidszonea4arctic3.services;

import java.util.List;

import com.example.kidszonea4arctic3.models.Commentaire;
import com.example.kidszonea4arctic3.models.Employee;
import com.example.kidszonea4arctic3.models.Parent;
import com.example.kidszonea4arctic3.models.Publication;

public interface ICommentaireService {
	
	public String addCommentaire(Commentaire c, int idP) throws Exception;
	public String deleteCommentaire(int id) throws Exception;
	public String updateCommentaire(Commentaire c, int id) throws Exception;
	public List<Commentaire> getAllCommentaires();
	public Commentaire getCommentaireById(int id);
	public int CountCommentaires();
	public List<Commentaire> getCommentairesByUserId(int id);
	public int CountCommentairesByUser(int id);
	public List<Commentaire> getCommentairesByPostId(int id);
	public int CountCommentairesByPost(int id);
    public List<Commentaire> searchCommentaires(String text);
	public Parent currentParent() throws Exception;
	public Employee currentEmployee() throws Exception;

	public List<Commentaire> getMyCommentaires() throws Exception;
	

}
