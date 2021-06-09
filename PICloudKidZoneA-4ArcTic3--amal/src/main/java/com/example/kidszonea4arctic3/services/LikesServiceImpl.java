package com.example.kidszonea4arctic3.services;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kidszonea4arctic3.models.Likes;
import com.example.kidszonea4arctic3.models.Parent;
import com.example.kidszonea4arctic3.models.Publication;
import com.example.kidszonea4arctic3.repositories.ILikingRepository;
import com.example.kidszonea4arctic3.repositories.ParentRepository;
import com.example.kidszonea4arctic3.repositories.PublicationRepository;


@Service
public class LikesServiceImpl implements ILikesService {
	@Autowired 
   PublicationRepository iPostRepository;
	
	@Autowired 
	ILikingRepository iLikesRepository;
	@Autowired 
	ParentRepository pr ;
	
	
	
	
	@Override
	public String addLikes(long idP) throws Exception{
		long id = 193 ; 
		Parent parent = pr.findById(id).get() ;
		
		Likes l = new Likes();
		l.setParent(parent);
		if (IsLikeExists(l.getParent().getId() , idP)){
			return ("You already liked this post");
		}
		else{
		Publication post=iPostRepository.findById(id).get() ;
		l.setPublication(post);
		l.setLikeDate(LocalDateTime.now());
		if (l.getParent().getId()==l.getPublication().getParent().getId()){
			iLikesRepository.save(l);
			return ("number of likes on this post: " + CountLikessByPost(idP));
		
	}}
		
		return "ceuu likes";
		}
	
	
	
	

	@Override
	public String deleteLikes(long id) throws Exception {
		long idd = 193 ; 
		Parent parent = pr.findById(idd).get() ;
		Likes ll = iLikesRepository.findById(id).get();
		if (parent.getId()==ll.getParent().getId()){
			ll.setParent(parent);		

		iLikesRepository.deleteById(id);
		return ("Like deleted successfully");
		}
		else{
		return ("You are not allowed to delete this like");	
		}
		
	}

	@Override
	public List<Likes> getAllLikess() {
		List<Likes>Likes = new ArrayList<Likes>();
		iLikesRepository.findAll().forEach(e ->Likes.add(e));
		return Likes;
	}
	

	@Override
	public Likes getLikesById(long id) {
		return iLikesRepository.findById(id).get();  

	}

	@Override
	public long CountLikess() {
		List <Likes> likes=(List<Likes>) iLikesRepository.findAll();
		return likes.size();
	}

	@Override
	public List<Likes> getLikessByUserId(long id) {
		return iLikesRepository.getLikesByUserId(id);
	}

	@Override
	public long CountLikessByUser(long id) {
		List <Likes> likes=(List<Likes>) iLikesRepository.getLikesByUserId(id);
		return likes.size();
	}

	@Override
	public List<Likes> getLikessByPostId(long id) {
		return iLikesRepository.getLikesByPostId(id);

	}
	

	@Override
	public long CountLikessByPost(long id) {
		List <Likes> likes=(List<Likes>) iLikesRepository.getLikesByPostId(id);
		return likes.size();
	}

	@Override
	public List<Likes> getMyLikes() throws Exception {
		long id = 193 ; 
		Parent parent = pr.findById(id).get() ;
		return iLikesRepository.getLikesByUserId(parent.getId());
	}
	
	//useful for the add method (a user can't like the same post twice)
	@Override
	public boolean IsLikeExists(long long1, long idp) {
	 long count =iLikesRepository.isLikeExists(long1, idp);
	 if (count==0){
		return false;
	}
	 else {
		 return true;
	 }
	 }



}