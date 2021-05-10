package com.example.kidszonea4arctic3.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
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
import com.example.kidszonea4arctic3.models.Parent;
import com.example.kidszonea4arctic3.models.Publication;
import com.example.kidszonea4arctic3.services.ICommentaireService;
import com.example.kidszonea4arctic3.services.PublicationService;



@Scope(value = "session")
@Controller(value = "CommentaireController") // Name of the bean in Spring IoC
@ELBeanName(value = "CommentaireController") // Name of the bean used by JSF
public class CommentaireController {
	
	@Autowired
	ICommentaireService cs;
	@Autowired
	PublicationService ps ;
	
	
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
	
//	public Commentaire(long id, Parent parent, Publication publication, String commentContent,
//			LocalDateTime date_com) {
		
	
	private long idpubselected;//PubController.idpubselected
	
	private Parent parent ;
	private Publication pub ; 
	private String commentContent ;
	private LocalDateTime date_com ;
	Commentaire commentTo = new Commentaire() ; 

	
	public Commentaire getCommentTo() {
		return commentTo;
	}


	public void setCommentTo(Commentaire commentTo) {
		this.commentTo = commentTo;
	}


	public void addCommentt( Commentaire c, long idp) throws Exception   
	{ 
		
		System.err.println("3eussssssssssseummaaaaaaaaaaaaaaaaa !!!!!!!!!!!!!! comments");
		c.setPublication(ps.getPublicationById(idp));		
		cs.addC(c) ;
		

 
	}
	public String deleteCommentt ( long Commentid ) throws Exception
	{
		return cs.deleteCommentaire(Commentid);
		
	}


	public long getIdpubselected() {
		return idpubselected;
	}


	public void setIdpubselected(long idpubselected) {
		this.idpubselected = idpubselected;
	}





	public Parent getParent() {
		return parent;
	}


	public void setParent(Parent parent) {
		this.parent = parent;
	}


	public Publication getPub() {
		return pub;
	}


	public void setPub(Publication pub) {
		this.pub = pub;
	}


	public String getCommentContent() {
		return commentContent;
	}


	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}


	public LocalDateTime getDate_com() {
		return date_com;
	}


	public void setDate_com(LocalDateTime date_com) {
		this.date_com = date_com;
	} 
	
	
	public int getpostcommentcount() {
		return cs.CountCommentaires();
	}
	

	public int getpostcommcount(long idP) {
		return cs.CountCommentairesByPost(idP);
	}
	

}
