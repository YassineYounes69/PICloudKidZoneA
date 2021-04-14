package com.example.kidszonea4arctic3.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.kidszonea4arctic3.models.Publication;

public interface PublicationRepository extends CrudRepository<Publication, Long>{
	


}
