package com.example.kidszonea4arctic3.controllers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

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
import org.springframework.web.bind.annotation.RestController;

import com.example.kidszonea4arctic3.services.ICommentaireService;
import com.example.kidszonea4arctic3.services.IPublicationService;
import com.example.kidszonea4arctic3.models.Parent;
import com.example.kidszonea4arctic3.models.Publication;
import com.example.kidszonea4arctic3.models.TypePub;

@Scope(value = "session")
@Controller(value = "PublicationController") // Name of the bean in Spring IoC
@ELBeanName(value = "PublicationController") // Name of the bean used by JSF
//@RequestMapping("/APIpub")
@RestController
//@Join(path = "/", to = "/DetailPost.jsf")
public class PublicationController {
	
	@Autowired
	IPublicationService ps;

	@Autowired
	ICommentaireService cs;
	
	//@Transactional
	//http://localhost:8000/SpringMVC/servlet/readAllPublication
	@GetMapping("/readAllPublication")
	@ResponseBody
	public List<Publication> getPublications() {
		//traja3 liste des pub sorted by nbr comntaire
		List<Publication> l = ps.readAllPublication();
		l.stream().sorted( (Publication p1,Publication p2) -> cs.CountCommentairesByPost(p1.getIdpub())-cs.CountCommentairesByPost(p2.getIdpub()));
				
		return l;
	}
	private long idpubselected;//PubController.idpubselected
	
	private Publication selectedpub;
	
	 public String listcomentofpost(int idpub) {
		 this.setIdpubselected(idpub);
		 
		 this.setSelectedpub(this.getPost(idpub));
		 return "/DetailPost.xhtml?faces-redirect=true";
		 
		 
	 }
	 
	 public String listlikeofpost(int idpub) {
		 this.setIdpubselected(idpub);
		 
		 this.setSelectedpub(this.getPost(idpub));
		 return "/DetailPost.xhtml?faces-redirect=true";
		 
		 
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

	
    
    //http://localhost:8000/APIpub/Post/searsh/?m=
    @GetMapping("/Post/searsh/{m}")
	 @ResponseBody
	 public Publication advancedSearsh(@PathVariable() String m){ 
		 return ps.advancedSearsh(m) ;
	 }
    

	//http://localhost:8000/SpringMVC/servlet/Post/search-by-admin?pattern=...
	@GetMapping("/Post/search-by-admin")
	@ResponseBody
	public List<Publication> postSearchByAdmin(@RequestParam("pattern")String pattern){
		return ps.searchPublications(pattern) ;
	}
	




	public long getIdpubselected() {
		return idpubselected;
	}




	public void setIdpubselected(long idpubselected) {
		this.idpubselected = idpubselected;
	}




	public Publication getSelectedpub() {
		return selectedpub;
	}




	public void setSelectedpub(Publication selectedpub) {
		this.selectedpub = selectedpub;
	}
	
	
private TypePub type_pub ;
private String  pubContent;
private LocalDateTime date_pub ;
private String  titre_pub ;
private String  src_pub;
private Parent parent = new Parent() ;
private String idpub ;






public void addpostt()
{
	System.err.println("3eussssssssssseummaaaaaaaaaaaaaaaaa !!!!!!!!!!!!!!");
	parent.setId(Long.valueOf(5));
    ps.addorupdatepost(new Publication(parent ,type_pub, pubContent, date_pub, titre_pub, src_pub));
       

}

public void addpostmsg() throws Exception   
{  	parent.setId(Long.valueOf(5));
	  ps.addPublicationMsg(new Publication(parent ,type_pub, pubContent, date_pub, titre_pub, src_pub)) ;  
} 

public void updatePost () {
	parent.setId(Long.valueOf(5));
    ps.addorupdatepost(new Publication(idpubselected , parent ,type_pub, pubContent, date_pub, titre_pub, src_pub));
   
}

public void setinput (Publication p)
{
this.setDate_pub(p.getDate_pub());
this.setPubContent(p.getPubContent());
this.setSrc_pub(p.getSrc_pub());
this.setIdpubselected(p.getIdpub());
this.setParent(p.getParent());

}



public TypePub getType_pub() {
	return type_pub;
}




public void setType_pub(TypePub type_pub) {
	this.type_pub = type_pub;
}




public String getPubContent() {
	return pubContent;
}




public void setPubContent(String pubContent) {
	this.pubContent = pubContent;
}




public LocalDateTime getDate_pub() {
	return date_pub;
}




public void setDate_pub(LocalDateTime date_pub) {
	this.date_pub = date_pub;
}




public String getTitre_pub() {
	return titre_pub;
}




public void setTitre_pub(String titre_pub) {
	this.titre_pub = titre_pub;
}




public String getSrc_pub() {
	return src_pub;
}




public void setSrc_pub(String src_pub) {
	this.src_pub = src_pub;
}




public Parent getParent() {
	return parent;
}




public void setParent(Parent parent) {
	this.parent = parent;
}
	
	
public void deletePost(long id) {
	ps.deletePublication(id);
}

	
private String pattern ; 

public String getPattern() {
	return pattern;
}




public void setPattern(String pattern) {
	this.pattern = pattern;
}




public Publication advanced(String m ){ 
	
	System.err.println("seaaaaaaaaaaaaaaaarchhhhhhhhhhh !!!!!!!!!!!!");
	System.err.println(ps.advancedSearsh(m));	
	System.err.println(m);

	

	return ps.advancedSearsh(m) ;
	
	
	 
	 
}




  public String postSearch(String m)
  {
	System.err.println("seaaaaaaaaaaaaaaaarchhhhhhhhhhh !!!!!!!!!!!!");
    System.err.println(ps.searchPublications(m));
	System.err.println("seaaaaaaaaaaaaaaaarchhhhhhhhhhh");
	return m;

    
 }

public int getpostcount() {
	return ps.CountPublications() ;
}

public String  redirec () 
{
	FacesContext context = FacesContext.getCurrentInstance() ; 
	 Map reMap = context.getExternalContext().getRequestParameterMap();
	 idpub = (String) reMap.get("id");
	 System.err.println("puuuuuuuuuuuuuuuub");
	 return "/search.xhtml?faces-redirect=true";
}




public String getIdpub() {
	return idpub;
}




public void setIdpub(String idpub) {
	this.idpub = idpub;
}



public Publication getMostLikedPostt() throws Exception {
	return ps.mostLikedPublication() ;
}


public Publication getMostCommentedPostt() throws Exception {
	return ps.mostCommentedPublication() ;
}


public String show(Publication p ) throws Exception {
	this.setDate_pub(p.getDate_pub());
	this.setPubContent(p.getPubContent());
	this.setSrc_pub(p.getSrc_pub());
	this.setIdpubselected(p.getIdpub());
	this.setParent(p.getParent());

	FacesContext context = FacesContext.getCurrentInstance() ; 
	Map requMap = context.getExternalContext().getRequestParameterMap() ; 
	idpub = (String) requMap.get("idpub") ; 
	System.err.println(idpub);
	return "/Detail.xhtml?faces-redirect=true";

}
public String back ( )throws Exception {
	
	FacesContext context = FacesContext.getCurrentInstance() ; 
	Map requMap = context.getExternalContext().getRequestParameterMap() ; 
	idpub = (String) requMap.get("idpub") ; 
	System.err.println(idpub);
	return "/post.xhtml?faces-redirect=true";

}


public String showw(Publication p ) throws Exception {
	this.setDate_pub(p.getDate_pub());
	this.setPubContent(p.getPubContent());
	this.setSrc_pub(p.getSrc_pub());
	this.setIdpubselected(p.getIdpub());
	this.setParent(p.getParent());

	FacesContext context = FacesContext.getCurrentInstance() ; 
	Map requMap = context.getExternalContext().getRequestParameterMap() ; 
	idpub = (String) requMap.get("idpub") ; 
	System.err.println(idpub);
	return "/post.xhtml?faces-redirect=true";

}

	

	}
