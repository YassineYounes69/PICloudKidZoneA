package com.example.kidszonea4arctic3.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.kidszonea4arctic3.models.Publication;

public interface PublicationRepository extends CrudRepository<Publication, Long>{
	

	@Query("SELECT p FROM Publication p WHERE p.parent.id =:id order by p.date_pub desc") 
	public List<Publication> getPostByUserId(@Param("id")Long id);
	
		

	@Query("SELECT p FROM Publication p WHERE p.id IN (SELECT c.publication.id FROM Commentaire c WHERE c.parent.id =:id) order by p.date_pub desc")
	public List<Publication> getPostsCommentedByUser(@Param("id")long id);
	
	
	
	@Query("SELECT p FROM Publication p WHERE p.id IN (SELECT l.publication.id FROM Likes l WHERE l.parent.id =:id) order by p.date_pub desc")
	public List<Publication> getPostsLikedByUser(@Param("id")long id);

	
	@Query("SELECT p FROM Publication p WHERE p.id IN (SELECT r.publication.id FROM Report r) order by p.date_pub desc")
	public List<Publication> getReportedPosts();
	
	
	@Query("SELECT p FROM Publication p WHERE p.pubContent LIKE %?1%  order by p.date_pub desc")
	List<Publication> findPostsByTextContaining(String pattern);
	
///////// Partie recherche avanceé//////////
   @Query("SELECT  u FROM Publication u WHERE u.titre_pub LIKE %?1%")
   public Publication advancedSearchByTitrePub(String motif);
   
   @Query("SELECT u FROM Publication u WHERE u.pubContent LIKE %?1%")
   public Publication advancedSearchBypubContent(String motif);
   
   @Query("SELECT u FROM Publication u WHERE u.type_pub LIKE %?1%")
   public Publication advancedSearchBytype_pub(String motif);
   //////////// end recherche //////////////////////////////////////////////////////
	
	
	
}


