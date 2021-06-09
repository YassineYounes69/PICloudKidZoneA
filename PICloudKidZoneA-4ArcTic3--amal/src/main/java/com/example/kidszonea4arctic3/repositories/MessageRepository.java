package com.example.kidszonea4arctic3.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.kidszonea4arctic3.models.Message;


public interface MessageRepository extends JpaRepository<Message, Long> {
	@Query(value = "SELECT * FROM message m WHERE  m.parent_id= :idParent " , nativeQuery =true)
	 List<Message> findByIdDirecteurAndIdParent( @Param("idParent")Long idParent);
}
