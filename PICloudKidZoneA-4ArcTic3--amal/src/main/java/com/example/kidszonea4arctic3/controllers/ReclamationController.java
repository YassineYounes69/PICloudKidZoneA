package com.example.kidszonea4arctic3.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.example.kidszonea4arctic3.models.Category;
import com.example.kidszonea4arctic3.models.Employee;
import com.example.kidszonea4arctic3.models.Notification;
import com.example.kidszonea4arctic3.models.Parent;
import com.example.kidszonea4arctic3.models.Reclamation;
import com.example.kidszonea4arctic3.models.RestrictWord;
import com.example.kidszonea4arctic3.services.DirecteurService;
import com.example.kidszonea4arctic3.services.NotificationService;
import com.example.kidszonea4arctic3.services.ParentService;
import com.example.kidszonea4arctic3.services.ReclamationService;
import com.example.kidszonea4arctic3.services.RestrictWordService;


@Controller(value = "reclamationController")
@ELBeanName(value = "reclamationController")
public class ReclamationController {

	@Autowired
	ReclamationService rs;
	@Autowired
	ParentService ps;
	@Autowired
	NotificationService ns;
	@Autowired
	DirecteurService ds;
	@Autowired
	RestrictWordService restrictWordService;
	
	
	private String msg = "";

	private Reclamation r = new Reclamation();
	
	
	private List<Reclamation>list;
	
	
	

	public ReclamationController(ReclamationService rs) {
		list = rs.retrieveAllReclamations();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public String getMsg() {
		return msg;
	}

















	public void setMsg(String msg) {
		this.msg = msg;
	}

















	public Category[] getCategories() {
		return Category.values();
	}
	
	public void resetReclamation(){
		r = new Reclamation();
	}
	
	private Boolean badWordsValidation(String[] wordsFromText) {
		List<RestrictWord> restrictWords = restrictWordService.findAll();
		Boolean thatsOk = true;
		if (!restrictWords.isEmpty())
			for (int i = 0; i < wordsFromText.length; i++) {
				String wordFromText = wordsFromText[i];
				if (restrictWords.stream().filter(word -> word.getWord().equalsIgnoreCase(wordFromText)).count() > 0) {
					thatsOk = false;
					FacesContext context = FacesContext.getCurrentInstance();
					context.addMessage("somekey", new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Erreur le contexte est invalide ", "CONTEXT INVALIDE"));
					break;
				}
			}
		return thatsOk;
	}
	
	
	
	public String addReclamation() {
		String[] wordsFromText = r.getContent().split(" ");
		if (badWordsValidation(wordsFromText)) {
		
		
		
		
		
		
		
		Parent p = ps.retrieveParent(Long.parseLong("1")).get();
		Employee d = ds.retrieveDirecteur(Long.parseLong("1")).get();
		Notification n = new Notification("Notif de parent "+"1"+"vers directeur "+"1",r.getContent(),"link", new Date(), false,p,d);
		r.setParent(p);
		//////////////////////////
		rs.addReclamation(r);
		ns.createNotification(n);
		return "/pages/admin/gestionReclamation.xhtml?faces-redirect=true";
		}
		
		else{
			r.setContent("please change content");
			return "/pages/admin/saveReclamation.xhtml?faces-redirect=true";
		}
		
	}
	
	
	
	public String updateReclamation(Reclamation r1){
		r=r1;
		return "/pages/admin/saveReclamation.xhtml?faces-redirect=true";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void removeReclamation(Long id) {
		rs.deleteReclamation(id);
	}
	
	
	
	
	public Reclamation getR() {
		return r;
	}





	public void setR(Reclamation r) {
		this.r = r;
	}






	public List<Reclamation> getList() {
		if (this.msg.length() == 0)
		list = rs.retrieveAllReclamations();
		else
		list = rs.searchRec(msg);
		return list;
	}






	public void setList(List<Reclamation> list) {
		this.list = list;
	}


	



	//
	//tester la connectivté http://localhost:8082/jardinEnfant/servlet/sayHello?myName=mohaemd
	@RequestMapping("/sayHello")
	public String welcome(Map<String, Object> model, @RequestParam("myName") String
	name) {
	model.put("receivedName", name);
	return "helloPage "+name;
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// http://localhost:8082/jardinEnfant/servlet/ajouterReclamation/{parent-id}/{directeur-id}

	@PostMapping("/ajouterReclamation/{parent-id}/{directeur-id}")
	@ResponseBody
	public Reclamation ajouterEmploye(@RequestBody Reclamation r,@PathVariable("parent-id") String idPrent, @PathVariable("directeur-id") String idDirecteur)
	{
		Parent p = ps.retrieveParent(Long.parseLong(idPrent)).get();
		Employee d = ds.retrieveDirecteur(Long.parseLong(idDirecteur)).get();
		Notification n = new Notification("Notif de parent "+idPrent+"vers directeur "+idDirecteur,r.getContent(),"link", new Date(), false,p,d);
		r.setParent(p);
		//////////////////////////
		rs.addReclamation(r);
		ns.createNotification(n);
		return r;
	}
	
	
	// http://localhost:8082/jardinEnfant/servlet/retrieve-all-reclamations
	@GetMapping("/retrieve-all-reclamations")
	 @ResponseBody
	 public List<Reclamation> getUsers() {
	 List<Reclamation> list = rs.retrieveAllReclamations();
	 return list;
	 }

	
	
	
			// http://localhost:8082/jardinEnfant/servlet/retrieve-reclamation/{reclamation-id}
			 @GetMapping("/retrieve-reclamation/{reclamation-id}")
			 @ResponseBody
			 public Optional<Reclamation> retrieveUser(@PathVariable("reclamation-id") String reclamationId) {
			 return rs.retrieveReclamation(Long.parseLong(reclamationId))  ;
			 }

				// http://localhost:8082/jardinEnfant/servlet/remove-reclamation/{reclamation-id}
			   @DeleteMapping("/remove-reclamation/{reclamation-id}")
			   @ResponseBody
			   public void removeUser(@PathVariable("reclamation-id") String id) {
			   rs.deleteReclamation(Long.parseLong(id));
			   }

				// http://localhost:8082/jardinEnfant/servlet/modify-reclamation

			   @PutMapping("/modify-reclamation/{parent-id}")
			    @ResponseBody
			    public void modifyUser(@RequestBody Reclamation r,@PathVariable("parent-id") String idPrent) {
				   Parent p = ps.retrieveParent(Long.parseLong(idPrent)).get();
				   r.setParent(p);
			     rs.updateReclamation(r);
			    }
	
			   
			   
			   
			// http://localhost:8082/jardinEnfant/servlet/recherche-reclamation-par-category/{category}
				 @GetMapping("/recherche-reclamation-par-category/{category}")
				 @ResponseBody
				 public List<Reclamation> searchByCategory(@PathVariable("category") Category category) {
				 return rs.searchByCategory(category)  ;
				 }
				 
				// http://localhost:8082/jardinEnfant/servlet/recherche-reclamation-par-category/{category}
				//1srt method
				 /* @GetMapping("/CategoryStatistics")
				 @ResponseBody
				 public String CategoryStatistics() {
					 int n = rs.retrieveAllReclamations().size();
						float  edu = rs.searchByCategory(Category.EDUCATION).size() ;
						float  admi = rs.searchByCategory(Category.ADMINISTRATION).size() ;
						float  form = rs.searchByCategory(Category.FORMATION).size() ;
						float  autr = rs.searchByCategory(Category.AUTRE).size() ;
					    String json = new Gson().toJson("{ EDUCATION: "+edu/n*100+", ADMINISTRATION: "+admi/n*100+", FORMATION:"+form/n*100+", AUTRE:"+autr/n*100+" }");
						return json;
				 }
				  */
				 
				 //2nd method
				 @GetMapping("/CategoryStatistics")
				 @ResponseBody
				 public HashMap<String, Float> CategoryStatistics() {
					 int n = rs.retrieveAllReclamations().size();
						float  edu = rs.searchByCategory(Category.EDUCATION).size() ;
						float  admi = rs.searchByCategory(Category.ADMINISTRATION).size() ;
						float  form = rs.searchByCategory(Category.FORMATION).size() ;
						float  autr = rs.searchByCategory(Category.AUTRE).size() ;
					    HashMap<String, Float> statistics = new HashMap<String, Float>();
					    statistics.put("EDUCATION", edu/n*100);
					    statistics.put("ADMINISTRATION", admi/n*100);
					    statistics.put("FORMATION", form/n*100);
					    statistics.put("AUTRE", autr/n*100);
						return statistics;
				 }
	
				 
				 
				 
				 
				// http://localhost:8082/jardinEnfant/servlet/getEmpl/{emp-id}
					@GetMapping("/getEmpl/{emp-id}")
					 @ResponseBody
					 public Employee getEmpl(@PathVariable("emp-id") String idEmp) { 
						return ds.retrieveDirecteur(Long.parseLong(idEmp)).get();
					 }
				 
					// http://localhost:8082/jardinEnfant/servlet/getEmpl/{parent-id}
					@GetMapping("/getParent/{parent-id}")
					 @ResponseBody
					 public Parent getParent(@PathVariable("parent-id") String idParent) { 
						return ps.retrieveParent(Long.parseLong(idParent)).get();
					 }
				 
				 
				 
				 
				 
				 
				 
	
}
