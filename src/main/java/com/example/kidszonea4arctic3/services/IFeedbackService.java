package com.example.kidszonea4arctic3.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.kidszonea4arctic3.models.Feedback;



public interface IFeedbackService {

	public List<Feedback> getAllFeedbcks();
	public Feedback addFeedback (Feedback feedback);
	public Feedback updateFeedback (long id,Feedback feedback);
	public void suppFeedback (long id);
	public List<Feedback> getFeedbackById(long id);
	public List<?> FeedbackByParent(long idparent);
	public long nbrFeedbackByParent(long idparent);
	
	public List<?> nbrFeedbackByNameParent();
	
	
	public Page<Feedback>findAll(Pageable pageable);



}
