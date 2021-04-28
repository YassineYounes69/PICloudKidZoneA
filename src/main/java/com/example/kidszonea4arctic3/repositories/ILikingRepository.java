package com.example.kidszonea4arctic3.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.kidszonea4arctic3.models.Likes;



import org.springframework.stereotype.Repository;

@Repository
public interface ILikingRepository  extends CrudRepository<Likes,Long >{
	
	@Modifying (clearAutomatically = true)
	@Query (value= "Delete from Likes l where l.id= :id")
	public void deleteById(@Param("id") long id);
	
	@Query("SELECT l FROM Likes l WHERE l.parent.id =:id order by l.likeDate desc")
	public List<Likes> getLikesByUserId(@Param("id")long id);

	@Query("SELECT l FROM Likes l WHERE l.publication.id =:id order by l.likeDate desc")
	public List<Likes> getLikesByPostId(@Param("id")long l);
		
	@Query("select count(l) from Likes l where l.parent.id =:idu and l.publication.id =:idp")
	public long isLikeExists(@Param("idu")long idu, @Param("idp")long idp);
	
}
