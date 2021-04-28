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

import com.example.kidszonea4arctic3.services.IPublicationService;
import com.example.kidszonea4arctic3.models.Publication;
@Controller
public class PublicationController {
	@Autowired
	IPublicationService ps;

	

	//http://localhost:8000/SpringMVC/servlet/readAllPublication
	@GetMapping("/readAllPublication")
	@ResponseBody
	public List<Publication> getPublications() {
		List<Publication> l = ps.readAllPublication();
		return l;
	}
	
	 //Ajouter publication : http://localhost:8000/SpringMVC/servlet/addPublication
	@PostMapping("/addPublication")
	@ResponseBody	
	public Publication addPublication(@RequestBody Publication p) {
	
		return ps.addPublication(p);
		
		
	}
	
	//http://localhost:8080/SpringMVC/servlet/deletePublication/{id}
		@DeleteMapping("/deletePublication/{id}")
		@ResponseBody
		public void deletePublication(@PathVariable("id") long id) {
			ps.deletePublication(id);
		}
		
		// http://localhost:8000/SpringMVC/servlet/modify-pub
		@PutMapping("/modify-pub")
		@ResponseBody
		public Publication updatePublication (@RequestBody Publication p) {
		
			return ps.updatePublication(p) ;
		}
		
	
	@PostMapping("/addpostMsg")  
	@ResponseBody	
	public String addPost(@RequestBody Publication Posts) throws Exception   
	{  
		return  (ps.addPublicationMsg(Posts)) ;  
	}  
	
	
	
	@PutMapping("/updatepost/{id}") 
	@ResponseBody	
	public String updatePost(@RequestBody Publication p, @PathVariable("id")long id) throws Exception   
	{  
		return ps.updatePublicationMsg(p,id);
	
	
}
	//http://localhost:8000/SpringMVC/servlet/get-my-posts
	@GetMapping("/get-my-posts")  
	@ResponseBody
	public List<Publication> getMyPublications() throws Exception   
	{  
		return ps.getMyPublications() ; 
	}
	
	//http://localhost:8000/SpringMVC/servlet/get-all-posts
	@GetMapping("/get-all-posts")  
	@ResponseBody
	public List<Publication> getAllPosts() throws Exception   
	{  
		 List<Publication> l =ps.getALLPublications() ;
		return l ;
	}
	
	//http://localhost:8000/SpringMVC/servlet/Post/posts-by-user/{idU}
	@GetMapping("/Post/posts-by-user/{idU}")
	@ResponseBody
	public List<Publication> getPostsByUser(@PathVariable("idU") long idU) {
		return ps.getPublicationsByUserId(idU);
	}
	
	//http://localhost:8000/SpringMVC/servlet/Post/detail-post/{Postid}
	@GetMapping("/Post/detail-post/{Postid}")  
	@ResponseBody
	public Publication getPost(@PathVariable("Postid") int Postid)   
	{  
		return ps.getPublicationById(Postid);  
	}  		

	//http://localhost:8000/SpringMVC/servlet/Post/search-by-admin?pattern=...
	@GetMapping("/Post/search-by-admin")
	@ResponseBody
	public List<Publication> postSearchByAdmin(@RequestParam("pattern")String pattern){
		return ps.searchPublications(pattern) ;
	}
	
	
	//http://localhost:8000/SpringMVC/servlet/Post/share-post/{idP}
	@PostMapping("/Post/share-post/{idP}")  
	@ResponseBody	
	public String sharePost(@PathVariable("idP")long idP) throws Exception   
	{  
		return  ps.sharePublication(idP);  			
	}  
	
	//http://localhost:8000/SpringMVC/servlet/Post/report-post/{idP}
	@PostMapping("/Post/report-post/{idP}")  
	@ResponseBody	
	public String reportPost(@PathVariable("idP")int idP) throws Exception   
	{  
		return (ps.reportPublication(idP));
	}
	
	
	//http://localhost:8000/SpringMVC/servlet/Post/reported
	@GetMapping("/Post/reported")
	@ResponseBody	
	public List<Publication> getReportedPosts() {
		return ps.getReportedPublications() ;
	}
	
	//http://localhost:8000/SpringMVC/servlet//Post/count-all-posts
	@GetMapping("/Post/count-all-posts")
	@ResponseBody	
	public int getpostscount() {
		return ps.CountPublications() ;
	}
	
	//http://localhost:8000/SpringMVC/servlet/Post/approve-reported/{Postid}
	@DeleteMapping("/Post/approve-reported/{Postid}") 
	@ResponseBody	
	public void approveReportedPost(@PathVariable("Postid") int Postid)   
	{  
		ps.approveReportedPublication(Postid);;  
	}
	
	//http://localhost:8000/SpringMVC/servlet/Post/detectimg/?img=
	@GetMapping("/Post/detectimg/") 
	@ResponseBody	
	public List<String> moderation(@RequestParam("img")String img) throws Exception 
	{  
		return ps.detect(img);  
	}
	
	
	//http://localhost:8000/SpringMVC/servlet/Post/posts-liked-by-user/{idU}
	@GetMapping("/Post/posts-liked-by-user/{idU}")
	@ResponseBody
	public List<Publication> getPostsLikedByUser(@PathVariable("idU") int idU) 
		{
		return ps.getPublicationsLikedByUser(idU);
	   }
		
	
	//http://localhost:8000/SpringMVC/servlet/Post/posts-commented-by-user/{idU}
	@GetMapping("/Post/posts-commented-by-user/{idU}")
	@ResponseBody
	public List<Publication> getPostsCommentedByUser(@PathVariable("idU") int idU) {
			return ps.getPublicationsCommentedByUser(idU) ;
		}
		
	
		
	
	//http://localhost:8000/SpringMVC/servlet/Post/most-liked-post
    @GetMapping("/Post/most-liked-post")
	@ResponseBody
	public Publication getMostLikedPost() throws Exception {
		return ps.mostLikedPublication() ;
	}
    
  //http://localhost:8000/SpringMVC/servlet/Post/most-commented-post
    @GetMapping("/Post/most-commented-post")
	@ResponseBody
	public Publication getMostCommentedPost() throws Exception {
		return ps.mostCommentedPublication() ;
	}

	
    //http://localhost:8000/SpringMVC/servlet/Post/searsh/?m=
    @GetMapping("/Post/searsh/{m}")
	 @ResponseBody
	 public Publication advancedSearsh(@PathVariable() String m){ 
		 return ps.advancedSearsh(m) ;
	 }
	
	
	

	
	
	



	


	
		
	

	}
