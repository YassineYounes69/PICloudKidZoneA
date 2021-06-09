package com.example.kidszonea4arctic3.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.kidszonea4arctic3.models.ChildCareCenter;
import com.example.kidszonea4arctic3.models.Employee;
import com.example.kidszonea4arctic3.models.Feedback;
import com.example.kidszonea4arctic3.models.Meeting;
import com.example.kidszonea4arctic3.models.Parent;
import com.example.kidszonea4arctic3.repositories.ChildCareCenterRepository;
import com.example.kidszonea4arctic3.repositories.FeedbackRepository;
import com.example.kidszonea4arctic3.repositories.ParentRepository;


@Service
public class FeedbackService implements IFeedbackService{

	
	@Autowired
    private FeedbackRepository feedbackRepository;

	
	
	@Autowired
    private ParentRepository pr;
	
	@Autowired
    private ChildCareCenterRepository cr;
	
	@Override
	public Feedback addFeedback(Feedback feedback) {
		Feedback f = feedbackRepository.save(feedback);
  
		return f;	
		
	}
	
	@Transactional
	public void doDeleteFeedback(Feedback feed) {

		feedbackRepository.delete(feed);
	}
	
	
	
	
	
    public List<Feedback> getAllFeedbacks() {
			return (List<Feedback>) feedbackRepository.findAll();
			}
    
    public List<ChildCareCenter> getAllChildCareCenter() {
		return (List<ChildCareCenter>) cr.findAll();
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
	
	public long getCountFeedbackByParentId(Long id){
		
		
		System.err.println("hava id fi contrat service :"+id);
	
		return feedbackRepository.getCountFeedbackByParentId(id);
	}
	
	
	public ChildCareCenter getChildCareCenterById(Long id){
		System.err.println("hava id fi contrat service :"+id);
		return cr.findById(id).get();
	}
	
	public List<Feedback> getChildCareCenterFeedbacks() throws Exception {
		long id = 69; 
		ChildCareCenter ccc = cr.findById(id).get();
		return feedbackRepository.getFeedbackByChildCareCenterId(ccc.getId()) ;
	}
	
	public List<Feedback> getParentFeedbacks() throws Exception {
		long id = 193; 
		Parent p = pr.findById(id).get() ;
		return feedbackRepository.getFeedbackByParentId(p.getId()) ;
	}
	
 public String getNameParentId(Long id){
		 
		 return feedbackRepository.getNameParentId(id);
	 }
 
	public List<Feedback> SearchFeedback(String mot) {
		return (List<Feedback>) feedbackRepository.searchFeedback(mot);
	}
	




}
