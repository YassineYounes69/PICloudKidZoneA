package com.example.kidszonea4arctic3.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.kidszonea4arctic3.models.Commentaire;
import com.example.kidszonea4arctic3.services.ICommentaireService;
import com.example.kidszonea4arctic3.services.IPublicationService;

@Controller
public class CommentaireController {
	
	@Autowired
	ICommentaireService cs;
	
	
	//http://localhost:8000/SpringMVC/servlet/Comment/get-all-comments
	@GetMapping("/Comment/get-all-comments") 
	@ResponseBody
	public List<Commentaire> getAllComments()   
	{  
		return cs.getAllCommentaires() ;
	} 
	
	
	//http://localhost:8000/SpringMVC/servlet/Comment/add-comment/{idP}
	@PostMapping("/Comment/add-comment/{idP}")  
	@ResponseBody
	public String addComment(@RequestBody Commentaire comments, @PathVariable("idP")long idP ) throws Exception   
	{  
		return (cs.addCommentaire(comments, idP));  						
	} 
	
	
	//http://localhost:8000/SpringMVC/servlet/Comment/delete-comment/{idcomment}
	@DeleteMapping("/Comment/delete-comment/{Commentid}")
	@ResponseBody
	public String deleteComment (@PathVariable("Commentid") long Commentid ) throws Exception
	{
		return cs.deleteCommentaire(Commentid);
		
	}
	
	//http://localhost:8000/SpringMVC/servlet/Comment/update-comment/{Commentid}
	@PutMapping("/Comment/update-comment/{Commentid}") 
	@ResponseBody
	public String updateComment(@RequestBody Commentaire comments, @PathVariable("Commentid")int Commentid) throws Exception   
	{  
		return cs.updateCommentaire(comments,Commentid);  			  
	}
	
	//http://localhost:8000/SpringMVC/servlet/Comment/detail-comment/{Commentid}
	@GetMapping("/Comment/detail-comment/{Commentid}")  
	@ResponseBody
	public Commentaire getComment(@PathVariable("Commentid") int Commentid)   
	{  
		return cs.getCommentaireById(Commentid);  
	}  
	
	//http://localhost:8000/SpringMVC/servlet/Comment/comments-by-user/{idU}
	@GetMapping("/Comment/comments-by-user/{idU}")
	@ResponseBody
	public List<Commentaire> getCommentsByUser(@PathVariable("idU") int idU) {
		return cs.getCommentairesByUserId(idU);

	}
	
	
	
	//http://localhost:8000/SpringMVC/servlet/Comment/get-my-comments
	@GetMapping("/Comment/get-my-comments")  
	@ResponseBody
	public List<Commentaire> getMyComments() throws Exception   

	{  
		return cs.getMyCommentaires();  
	}
	
	
	//http://localhost:8000/SpringMVC/servlet/Comment/count-user-comments/{idU}
	@GetMapping("/Comment/count-user-comments/{idU}")
	@ResponseBody
	public int getusercommentscount(@PathVariable("idU") long idU) {
		return cs.CountCommentairesByUser(idU);
	}
	
	
	//http://localhost:8000/SpringMVC/servlet/Comment/comments-by-post/{idP}
	@GetMapping("/Comment/comments-by-post/{idP}")
	@ResponseBody
	public List<Commentaire> getCommentsByPost(@PathVariable("idP") long idP) {
		return cs.getCommentairesByPostId(idP);

	}
	
	
	//http://localhost:8000/SpringMVC/servlet/Comment/count-post-comments/{idP}
	@GetMapping("/Comment/count-post-comments/{idP}")
	@ResponseBody
	public int getpostcommentscount(@PathVariable("idP") long idP) {
		return cs.CountCommentairesByPost(idP);
	}
	
	//http://localhost:8000/SpringMVC/servlet/Comment/search/?pattern=
	@GetMapping("/Comment/search/")
	@ResponseBody
	public List<Commentaire> commentSearch(@RequestParam("pattern")String pattern){
		//System.out.println(pattern);
		return cs.searchCommentaires(pattern);
	
	}
	
	
	

}
