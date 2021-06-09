package com.example.kidszonea4arctic3.services;

import java.util.List;

import com.example.kidszonea4arctic3.models.Likes;

public interface ILikesService {
	
	public String deleteLikes(long id) throws Exception;
	
	public List<Likes> getAllLikess();
	
	public Likes getLikesById(long id);
	
	public long CountLikess();
	
	public List<Likes> getLikessByUserId(long id);
	
	public long CountLikessByUser(long id);
	
	public List<Likes> getLikessByPostId(long id);
	
	public long CountLikessByPost(long id);
	
	public boolean IsLikeExists(long idu, long idp);
	
	

	public String addLikes(long idP) throws Exception;

	public List<Likes> getMyLikes() throws Exception;
}