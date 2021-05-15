package com.example.kidszonea4arctic3.controllers;

import java.util.List;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kidszonea4arctic3.models.Likes;
import com.example.kidszonea4arctic3.services.LikesServiceImpl;

@Scope(value = "session")
@Controller(value = "LikesController") // Name of the bean in Spring IoC
@ELBeanName(value = "LikesController") // Name of the bean used by JSF
@RestController
public class LikesController {
	
		@Autowired  
		LikesServiceImpl LikesServiceImpl;

		Likes likesTo= new Likes() ;
		
		public Likes getLikesTo() {
			return likesTo;
		}


		public void setLikesTo(Likes likesTo) {
			this.likesTo = likesTo;
		}


				//URL: http://localhost:8000/SpringMVC/servlet/Likes/add-like/{idP}
				@PostMapping("/Likes/add-like/{idP}")  
				public String addLike(@PathVariable("idP")long idP ) throws Exception   
				{    
					return(LikesServiceImpl.addLikes(idP));  

				} 
				
				
				
				public void addL(long idP )    
				{    
					System.err.println("hellooo likesss");
					try {
						LikesServiceImpl.addLikes(idP);
					} catch (Exception e) {
						e.printStackTrace();
					}


				} 
				
				

		//URL: http://localhost:8000/SpringMVC/servlet/Likes/delete-like/{Likeid}
				@DeleteMapping("/Likes/delete-like/{Likeid}")  
				public String deleteLikes(@PathVariable("Likeid") long Likeid) throws Exception   
				{  
					return(LikesServiceImpl.deleteLikes(Likeid));  
				} 
				
				
		//URL: http://localhost:8000/SpringMVC/servlet/Likes/get-all-likes
				@GetMapping("/Likes/get-all-likes")  
				public List<Likes> getAllLikes()   
				{  
					return LikesServiceImpl.getAllLikess();  
				}  
		
				
		//URL: http://localhost:8000/SpringMVC/servlet/Likes/detail-like/{Likesid}
				@GetMapping("/Likes/detail-like/{Likesid}")  
				public Likes getLike(@PathVariable("Likesid") long Likesid)   
				{  
					return LikesServiceImpl.getLikesById(Likesid);  
				}  
				
				
		//URL: http://localhost:8000/SpringMVC/servlet/Likes/count-all-likes
				@GetMapping("/Likes/count-all-likes")
				public long getlikescount() {
					return LikesServiceImpl.CountLikess() ;
				}
				
				public long getlikecount() {
					return LikesServiceImpl.CountLikess() ;
				}
				
		//URL: http://localhost:8000/SpringMVC/servlet/Likes/likes-by-user/{idU}
				@GetMapping("/Likes/likes-by-user/{idU}")
				public List<Likes> getLikesByUser(@PathVariable("idU") long idU) {
					return LikesServiceImpl.getLikessByUserId(idU);
				}
				
				
		//URL: http://localhost:8000/SpringMVC/servlet/Likes/count-user-likes/{idU}
				@GetMapping("/Likes/count-user-likes/{idU}")
				public long getuserlikescount(@PathVariable("idU") long idU) {
					return LikesServiceImpl.CountLikessByUser(idU);
				}
				
				
		//URL: http://localhost:8000/SpringMVC/servlet/Likes/likes-by-post/{idP}
				@GetMapping("/Likes/likes-by-post/{idP}")
				public List<Likes> getLikessByPost(@PathVariable("idP") long idP) {
					return LikesServiceImpl.getLikessByPostId(idP);
				}
				
				public List<Likes> getLikesByPost( long idP) {
					return LikesServiceImpl.getLikessByPostId(idP);
				}
				
				
		//URL: http://localhost:8000/SpringMVC/servlet/Likes/count-post-likes/{idP}
				@GetMapping("/Likes/count-post-likes/{idP}")
				public long getpostlikescount(@PathVariable("idP") long idP) {
					return LikesServiceImpl.CountLikessByPost(idP);
				}
				
				public long getpostlikecount( long idP) {
					return LikesServiceImpl.CountLikessByPost(idP);
				}
				
				
		//URL: http://localhost:8000/SpringMVC/servlet/Likes/get-my-likes
			@GetMapping("/Likes/get-my-likes")  
			public List<Likes> getMyComments() throws Exception   
			{  
				return LikesServiceImpl.getMyLikes();  
			}
				
}
