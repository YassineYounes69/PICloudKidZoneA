package com.example.kidszonea4arctic3.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.kidszonea4arctic3.models.Category;
import com.example.kidszonea4arctic3.models.Reclamation;


public interface ReclamationRepository extends JpaRepository<Reclamation, Long> {
	 @Query("SELECT r FROM Reclamation r WHERE r.category = ?1")
	 List<Reclamation> findByCategory(Category category);
	 
	 @Query("SELECT r FROM Reclamation r WHERE r.content LIKE CONCAT('%',:string,'%')")
		public List<Reclamation> searchReclamation(@Param("string") String msg);
	 
	 
	 
	 
	 
}
