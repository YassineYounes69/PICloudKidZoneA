package com.example.kidszonea4arctic3.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.kidszonea4arctic3.models.BookMark;
import com.example.kidszonea4arctic3.models.ChildCareCenter;
import com.example.kidszonea4arctic3.models.Employee;
import com.example.kidszonea4arctic3.models.Feedback;
import com.example.kidszonea4arctic3.models.Meeting;
import com.example.kidszonea4arctic3.models.Parent;
import com.example.kidszonea4arctic3.repositories.BookMarkRepository;
import com.example.kidszonea4arctic3.repositories.ChildCareCenterRepository;
import com.example.kidszonea4arctic3.repositories.FeedbackRepository;
import com.example.kidszonea4arctic3.repositories.ParentRepository;


@Service
public class BookMarkService implements IFeedbackService{

	
	@Autowired
    private FeedbackRepository feedbackRepository;

	@Autowired
    private BookMarkRepository br;
	
	@Autowired
    private ParentRepository pr;
	
	@Autowired
    private ChildCareCenterRepository cr;
	
	public BookMark addBookMark(BookMark bookmark) {
		BookMark b = br.save(bookmark);
  
		return b;	
		
	}
	
	public void doDeleteBookMark(BookMark bookmark) {

		br.delete(bookmark);
	}
	
	
	
	
	

    public List<BookMark> getAllBookMarks() {
			return (List<BookMark>) br.findAll();
			}
    
    public List<Feedback> getAllFeedbacks() {
		return (List<Feedback>) feedbackRepository.findAll();
		}


	@Override
	public Feedback updateFeedback(long id, Feedback feedback) {
	      
	    feedback=feedbackRepository.findById(id).get();
			return feedbackRepository.save(feedback);		
		
	}

	@Override
	public void suppFeedback(long id) {
	       feedbackRepository.deleteById(id);		
		
	}


	@Override
	public List<Feedback> getAllFeedbcks() {
		 List<Feedback> feedbacks = new ArrayList<>();
		 feedbackRepository.findAll().forEach(feedbacks::add);
		     return feedbacks;
		     
	}

	@Override
	public List<Feedback> getFeedbackById(long id) {
		 List<Feedback> feedbacks = new ArrayList<>();
		 feedbackRepository.findById(id).orElse(null); 
		     return feedbacks;
	}

	@Override
	public long nbrFeedbackByParent(long idparent) {
		// TODO Auto-generated method stub
		return feedbackRepository.nbrFeedbackByParent(idparent);
	}

	@Override
	public List<?> FeedbackByParent(long idparent) {
		// TODO Auto-generated method stub
		return feedbackRepository.FeedbackByParent(idparent);
	}

	@Override
	public List<?> nbrFeedbackByNameParent() {
		// TODO Auto-generated method stub
		return feedbackRepository.nbrFeedbackByNameParent();
	}

	@Override
	public Page<Feedback> findAll(Pageable pageable) {
	return feedbackRepository.findAll(pageable)	;
	}

	/*@Override
	public List<?> nbrFeedbackByParent() {
		// TODO Auto-generated method stub
		return feedbackRepository.nbrFeedbackByParent();
	}*/
	
	public Parent getParentById(Long id){
		System.err.println("hava id fi contrat service :"+id);
		return pr.findById(id).get();
	}
	
	public long getCountBookMarkByParentId(Long id){
		
		
		System.err.println("hava id fi contrat service :"+id);
	
		return br.getCountBookMarkByParentId(id);
	}
	
	
	public Feedback getBookMarkFeedbackById(Long id){
		System.err.println("hava id fi contrat service :"+id);
		return feedbackRepository.findById(id).get();
	}
	
	public List<Feedback> getChildCareCenterFeedbacks() throws Exception {
		long id = 69; 
		ChildCareCenter ccc = cr.findById(id).get();
		return feedbackRepository.getFeedbackByChildCareCenterId(ccc.getId()) ;
	}
	
	public List<BookMark> getParentBookMarks() throws Exception {
		long id = 193; 
		Parent p = pr.findById(id).get() ;
		return br.getBookMarkByParentId(p.getId()) ;
	}
	
 public String getNameParentId(Long id){
		 
		 return feedbackRepository.getNameParentId(id);
	 }
 
	public List<Feedback> SearchFeedback(String mot) {
		return (List<Feedback>) feedbackRepository.searchFeedback(mot);
	}

	@Override
	public Feedback addFeedback(Feedback feedback) {
		// TODO Auto-generated method stub
		return null;
	}
	




}
