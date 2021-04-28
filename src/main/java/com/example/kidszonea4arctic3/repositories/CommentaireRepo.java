package com.example.kidszonea4arctic3.repositories;
import com.example.kidszonea4arctic3.models.Commentaire;
import com.example.kidszonea4arctic3.models.Parent;
import com.example.kidszonea4arctic3.models.Publication;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface CommentaireRepo extends CrudRepository<Commentaire, Long>{
	
	
	@Modifying (clearAutomatically = true)
	@Query (value= "Delete from Commentaire c where c.id= :id")
	public void deleteById(@Param("id") long id);
	
	@Query("SELECT c FROM Commentaire c WHERE c.commentContent LIKE %?1%") 
	public List<Commentaire> findCommentsByTextContaining(String pattern);
	
	@Query("SELECT c FROM Commentaire c WHERE c.parent.id =:id")
	public List<Commentaire> getCommentsByUserId(@Param("id")long id);
	
	@Query("SELECT c FROM Commentaire c WHERE c.publication.id =:id")
	public List<Commentaire> getCommentsByPostId(@Param("id")long id);
	
	

}
