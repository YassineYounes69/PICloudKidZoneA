package com.example.kidszonea4arctic3.controllers;

import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.kidszonea4arctic3.models.BookMark;
import com.example.kidszonea4arctic3.models.ChildCareCenter;
import com.example.kidszonea4arctic3.models.Employee;
import com.example.kidszonea4arctic3.models.Feedback;
import com.example.kidszonea4arctic3.models.Meeting;
import com.example.kidszonea4arctic3.models.Parent;
import com.example.kidszonea4arctic3.repositories.ChildCareCenterRepository;
import com.example.kidszonea4arctic3.repositories.EmployeeRepository;
import com.example.kidszonea4arctic3.repositories.FeedbackRepository;
import com.example.kidszonea4arctic3.repositories.MeetingRepository;
import com.example.kidszonea4arctic3.repositories.ParentRepository;
import com.example.kidszonea4arctic3.services.BookMarkService;
import com.example.kidszonea4arctic3.services.FeedbackService;

@ViewScoped
@Controller(value = "bookmarkcontroller") // Name of the bean in Spring IoC
@ELBeanName(value = "bookmarkcontroller") // Name of the bean used by JSF
@Join(path = "/", to = "/CreateBookMark.jsf")
public class BookMarkController {

	
	    @Autowired
	    private FeedbackService fs;
	    @Autowired
	    private FeedbackRepository fr;
	    @Autowired
	    private BookMarkService bs;
	 
	    private final FeedbackRepository feedbackRepository;
		private final ParentRepository parentRepository;
		private final ChildCareCenterRepository childCareCenterRepository;
		public BookMarkController(FeedbackRepository feedbackRepository, ParentRepository parentRepository,ChildCareCenterRepository childCareCenterRepository) {
			super();
			this.feedbackRepository = feedbackRepository;
			this.parentRepository = parentRepository;
			this.childCareCenterRepository = childCareCenterRepository;
		}
		
		private long id;
		private long idfeedback;
		private long idparent;

		private Parent parent;
		private Feedback feedback;
		private String desc;
		
		private List<BookMark> bookmarks;

		
		
		
		 public Parent getParent() {
			return parent;
		}


		public void setParent(Parent parent) {
			this.parent = parent;
		}


		public long getIdparent() {
			return idparent;
		}


		public void setIdparent(long idparent) {
			this.idparent = idparent;
		}


		public long getId() {
			return id;
		}


		public void setId(long id) {
			this.id = id;
		}

			
		public long getIdfeedback() {
			return idfeedback;
		}


		public void setIdfeedback(long idfeedback) {
			this.idfeedback = idfeedback;
		}


		public Feedback getFeedback() {
			return feedback;
		}


		public void setFeedback(Feedback feedback) {
			this.feedback = feedback;
		}


		public String getDesc() {
			return desc;
		}


		public void setDesc(String desc) {
			this.desc = desc;
		}


		public List<BookMark> getBookmarks() {
			return bookmarks;
		}


		public void setBookmarks(List<BookMark> bookmarks) {
			this.bookmarks = bookmarks;
		}
		

		public List<BookMark> getBookMarkstolist() {
			if (null == bookmarks) {
				bookmarks = new ArrayList<>();
			}
			return bookmarks;
		}
		
		private List<Feedback> feedbacks;
		
		public List<Feedback> getFeedbacks() {
			return feedbacks;
		}

		
		public void setFeedbacks(List<Feedback> feedbacks) {
			this.feedbacks = feedbacks;
		}
		
		public List<Feedback> getFeed() {
			if (null == feedbacks) {
				feedbacks = new ArrayList<>();
			}
			return feedbacks;
		}
		
		

		@PostConstruct
		public void getAllBookMark() { 
			if (!this.getBookMarkstolist().isEmpty()) {
				this.getBookMarkstolist().clear();
				this.getFeed().clear();
			}
			System.out.println(" >>>>>>>>>>>>> " + bs);
			this.getBookMarkstolist().addAll(bs.getAllBookMarks());
			this.getFeed().addAll(bs.getAllFeedbacks());

		}
		
		 @GetMapping("/getBookMarksParent")  
			@ResponseBody
			public List<BookMark> getBookMarkParent() throws Exception   
			{  
			 System.err.println("*********"+bs.getParentBookMarks());

				return bs.getParentBookMarks() ; 
			}
			
		
		 public long getCountBookMarkByParentId(Long id){
				 this.idparent = 193 ; 

			return bs.getCountBookMarkByParentId(this.idparent);
			}
		 
		 public String getNameParentId(Long id){
			 this.idparent = 193 ; 

			 return bs.getNameParentId(this.idparent);
		 }
		 
		public void addbookmark() throws Exception{		 
			
			 System.err.println("*********"+this.idparent);
			 
			   this.idparent = 193 ; 
				
				
				
				this.parent = bs.getParentById(this.idparent);
			    this.feedback=bs.getBookMarkFeedbackById(this.idfeedback);
			    
	           System.err.println("*********"+this.feedback.getFeedback());
				bs.addBookMark(new BookMark(feedback,parent,desc));
				getBookMarkParent();
				
		    }
		
	      public void deleteBookMark(BookMark bookmark) { 
			
			bs.doDeleteBookMark(bookmark);
			

			getAllBookMark();

		}
		 
		
	
		 public List<Feedback> getFeedbacks(Pageable pageable) {
		 List<Feedback> list = (List<Feedback>) fs.getAllFeedbcks();
		 return list;
	}
		
		
		  public ResponseEntity<Map<String, Object>> all(
		        @RequestParam(required = false) String title,
		        @RequestParam(defaultValue = "0") int page,
		        @RequestParam(defaultValue = "3") int size
		      ) {

		    try {
		      List<Feedback> feedbacks = new ArrayList<Feedback>();
		      Pageable paging = PageRequest.of(page, size);
		      
		      Page<Feedback> pageFeedback;
		      pageFeedback = feedbackRepository.findAll(paging);
	
		      feedbacks = pageFeedback.getContent();

		      Map<String, Object> response = new HashMap<>();
		      response.put("Feedbacks", feedbacks);
		      response.put("size", pageFeedback.getSize());
		      response.put("currentPage", pageFeedback.getNumber());
		      response.put("totalItems", pageFeedback.getTotalElements());
		      response.put("totalPages", pageFeedback.getTotalPages());

		      return new ResponseEntity<>(response, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
		  }
		
		
		
		
		
		//Add Meeting 
		public ResponseEntity<Feedback> createFeedback(@PathVariable("idparent") long p,@PathVariable ("idchildcare") long c, @RequestBody Feedback feedback) throws Exception      
		{  
		Optional<Parent> parents= parentRepository.findById(p);  
		Optional<ChildCareCenter> childcare= childCareCenterRepository.findById(c);
		
		if(!parents.isPresent()&&!childcare.isPresent())  
		{  
		throw new Exception("erreur id: "+ p + c);  
		}  
		Parent parent=parents.get();
		ChildCareCenter childcarecenter=childcare.get();

		feedback.setParent(parent);
		 feedback.setChildCareCenter(childcarecenter);

		 fs.addFeedback(feedback);
		//getting the path of the feedback and append id of the feedback to the URI 
		String sort = "{\"idparent\":\"idchildcare\"}";
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("{sort}").buildAndExpand(feedback.getId()).toUri();  
		//returns the location of the created post  
		return ResponseEntity.created(location).build();  
		} 
		
		public Set<Feedback> getFeedbackByParent(@PathVariable ("idparent") long id) throws Exception  
		{  
		Optional<Parent> parents= parentRepository.findById(id);   
		if(!parents.isPresent())  
		{  
		throw new Exception("parent not found: "+ id);  
		}  
		return parents.get().getFeedbacks();  
		} 
		
		
		public Set<Feedback> getFeedbackByChildcare(@PathVariable ("idchildcare") long id) throws Exception  
		{  
		Optional<ChildCareCenter> childcare= childCareCenterRepository.findById(id);   
		if(!childcare.isPresent())  
		{  
		throw new Exception("childcare not found: "+ id);  
		}  
		return childcare.get().getFeedbacks();  
		} 
		
		//Delete Meeting
		public void deleteFeedback(@PathVariable ("id") long id) throws Exception  
		{  
	       Optional<Feedback> feedback= feedbackRepository.findById(id);  	
		if(feedback!=null){  
			//meetingRepository.deleteById(id);
			fs.suppFeedback(id);
		}
		else
		{
		throw new Exception("feedback not found: "+ id);  
		}
		}
		
		    public Feedback updateFeedbackById(@PathVariable Long id,@PathVariable String feedback){
		        Feedback fb = new Feedback();
		        if (feedbackRepository.findById(id).isPresent()){
		            fb = feedbackRepository.findById(id).get();
		            fb.setFeedback(feedback);
		            return feedbackRepository.save(fb);
		        }
		        else
		        {
		            return fb;
		        }
		    }
		 
			public List<?> FeedbackByParent(@PathVariable ("idparent") long id) throws Exception 
			{
				Optional<Parent> parents= parentRepository.findById(id);   
				if(!parents.isPresent())  
				{  
				throw new Exception("parent not found: "+ id);  
				}  
				return fs.FeedbackByParent(id);
			}
			
		 
			public long nbrFeedbackByParent(@PathVariable ("idparent") long id) throws Exception  
			{  
			Optional<Parent> parents= parentRepository.findById(id);   
			if(!parents.isPresent())  
			{  
			throw new Exception("parent not found: "+ id);  
			}  
			//Parent parent=parents.get();

			return fs.nbrFeedbackByParent(id);  
			}
			
			public List<?> nbrFeedbackByNameParent(){
				
				return fs.nbrFeedbackByNameParent();  

			}
			
			
			public List<?> CountFeedbackbyParent(){
				
				return fr.CountFeedbackByParent();  

			}
			public List<?> CostKidZone(){
				
				return fr.CostKidZone();  

			}
			
			
			/*@GetMapping("/PagingFeedback")  
			public List<Feedback> PagingFeedback(@PathVariable ("idparent") long id) throws Exception  
			{  
				
				Pageable firstPageWithTwoElements = PageRequest.of(0, 2);

				Pageable secondPageWithFiveElements = PageRequest.of(1, 5);
				
			Optional<Parent> parents= parentRepository.findById(id);   
			if(!parents.isPresent())  
			{  
			throw new Exception("parent not found: "+ id);  
			}  
			//Parent parent=parents.get();

			return fs.nbrFeedbackByParent(id);  
			}*/
			
			private String mot ;
			public String getMot() {
				return mot;
			}


			public void setMot(String mot) {
				this.mot = mot;
			}


			public List<Feedback> SearchFeedback(@PathVariable String mot) {
			System.out.print("feeeeeeeeedback");

					return fs.SearchFeedback(mot);
				}

		
			public List<Feedback> getFeeds() {
				
				 
					if (mot == null){
					feedbacks = fs.getAllFeedbacks();
					}
					
			
					
					else {
						feedbacks=fs.SearchFeedback(mot);
					}
					
					return feedbacks;
			}

			
			
	 
}
