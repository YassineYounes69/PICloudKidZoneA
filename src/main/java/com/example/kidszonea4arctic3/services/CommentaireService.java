package com.example.kidszonea4arctic3.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kidszonea4arctic3.models.Commentaire;
import com.example.kidszonea4arctic3.models.Employee;
import com.example.kidszonea4arctic3.models.Parent;
import com.example.kidszonea4arctic3.models.Publication;
import com.example.kidszonea4arctic3.models.UnhealthyWord;
import com.example.kidszonea4arctic3.repositories.CommentaireRepo;
import com.example.kidszonea4arctic3.repositories.ILikingRepository;
import com.example.kidszonea4arctic3.repositories.IReportRepository;
import com.example.kidszonea4arctic3.repositories.IUnhealthyWordRepository;
import com.example.kidszonea4arctic3.repositories.ParentRepository;
import com.example.kidszonea4arctic3.repositories.PublicationRepository;


@Service
public class CommentaireService implements ICommentaireService{
	
	@Autowired 
	IReportRepository iReportRepository;
	
	@Autowired 
	IUnhealthyWordRepository iUnhealthyWordRepository;
	@Autowired
	PublicationRepository PublicationRepository;
	@Autowired 
	ILikingRepository iLikingRepository;
	@Autowired
	CommentaireRepo commentaireRepo ;
	@Autowired 
	ParentRepository pr ;

	

	@Override
	public String addCommentaire(Commentaire c, long idP) throws Exception {
	Publication post = PublicationRepository.findById(idP).get() ;
	long id = 5 ; 
	//p.setParent(currentParent());
	Parent parent = pr.findById(id).get() ;
	c.setParent(parent);
	c.setPublication(post);
	for(UnhealthyWord uwd : iUnhealthyWordRepository.findAll()) {
		if(c.getCommentContent().toLowerCase().contains(uwd.getWord())){
			return("Sorry, you can't add comments that contain hate speech or bad words on Keedo.");
		}	
		
	
	   }
	
	if (c.getParent().getId()  == c.getPublication().getParent().getId())
     {
		commentaireRepo.save(c);
		return ("number of comments on this post: " + CountCommentairesByPost(idP)) ;
	}
	else 
	{
		return ("there's no comments on this post ! ") ; 
	}
	}

	@Override
	public String deleteCommentaire(long id) throws Exception {
		long idd = 5 ; 
		//p.setParent(currentParent());
		Parent parent = pr.findById(idd).get() ;
		long idParent = parent.getId() ; 
		Commentaire c = commentaireRepo.findById(id).get() ;
		if(idParent == c.getParent().getId())
		{
		commentaireRepo.deleteById(id);
		return ("Comment deleted successfully");
		
		}
		else{
			return ("You are not allowed to delete this comment");	
	}}
	
	
	
	@Override
	public String updateCommentaire(Commentaire c, long id) throws Exception {
		long idd = 5 ; 
		//p.setParent(currentParent());
		Parent parent = pr.findById(idd).get() ;
		long idParent = parent.getId() ; 
		Commentaire comment = commentaireRepo.findById(id).get() ;
		if(!(idParent == comment.getParent().getId()))
		{
				return ("You are not allowed to delete this comment");		
		}
		else {
			comment.setDate_com(LocalDateTime.now());
					
		for(UnhealthyWord uwd : iUnhealthyWordRepository.findAll()) {
			if(c.getCommentContent().toLowerCase().contains(uwd.getWord())){
				return("Sorry, you can't add comments that contain hate speech or bad words on Keedo.");
			}}
		commentaireRepo.save(c);
		return ("Comment updated successfully");
		}
		}
	

	@Override
	public List<Commentaire> getAllCommentaires() {
		List<Commentaire>Comments = new ArrayList<Commentaire>();
		commentaireRepo.findAll().forEach(e ->Comments.add(e));
		return Comments;	}

	@Override
	public Commentaire getCommentaireById(long id) {
		
		return commentaireRepo.findById(id).get();
	}

	@Override
	public int CountCommentaires() {
		List<Commentaire> comments = (List<Commentaire>) commentaireRepo.findAll() ;
	    return comments.size();
	}
	



	@Override
	public List<Commentaire> getCommentairesByUserId(long id) {
		return commentaireRepo.getCommentsByUserId(id);
	}
	
	@Override
	public List<Commentaire> getCommentairesByPostId(long id) {
		return commentaireRepo.getCommentsByPostId(id);
	}
	@Override
	public int CountCommentairesByUser(long id) {
		List<Commentaire> comments = (List<Commentaire>) commentaireRepo.getCommentsByUserId(id) ;

		return comments.size();
	}



	@Override
	public int CountCommentairesByPost(long id) {
		List<Commentaire> comments = (List<Commentaire>) commentaireRepo.getCommentsByPostId(id) ;
		return comments.size();
	}

	@Override
	public List<Commentaire> searchCommentaires(String pattern) {
		return commentaireRepo.findCommentsByTextContaining(pattern);
	}

	@Override
	public List<Commentaire> getMyCommentaires() throws Exception {
		long idd = 5 ; 
		//p.setParent(currentParent());
		Parent parent = pr.findById(idd).get() ;
		return commentaireRepo.getCommentsByUserId(parent.getId());
	}
	
	
	@Override
	public Commentaire addC(Commentaire c) throws Exception {
	long id=5;
	Parent parent = pr.findById(id).get() ;
	c.setParent(parent);
    return commentaireRepo.save(c);

	}


	
}
