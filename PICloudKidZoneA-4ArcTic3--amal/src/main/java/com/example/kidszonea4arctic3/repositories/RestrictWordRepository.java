package com.example.kidszonea4arctic3.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.kidszonea4arctic3.models.RestrictWord;


@Repository
public interface RestrictWordRepository extends CrudRepository<RestrictWord, Integer> {

	public RestrictWord findById(Long id);
	public RestrictWord findByWord(String word);
	public List<RestrictWord> findAll();	
	
}


