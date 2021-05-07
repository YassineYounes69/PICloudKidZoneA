package com.example.kidszonea4arctic3.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.kidszonea4arctic3.models.Feedback;
import com.example.kidszonea4arctic3.repositories.FeedbackRepository;


@Service
public class FeedbackService implements IFeedbackService{

	
	@Autowired
    private FeedbackRepository feedbackRepository;

	@Override
	public Feedback addFeedback(Feedback feedback) {
		Feedback f = feedbackRepository.save(feedback);
  
		return f;	
		
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

}
