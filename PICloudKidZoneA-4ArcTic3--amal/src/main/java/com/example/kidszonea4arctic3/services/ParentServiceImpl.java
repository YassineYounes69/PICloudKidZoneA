package com.example.kidszonea4arctic3.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kidszonea4arctic3.models.Parent;
import com.example.kidszonea4arctic3.repositories.ParentRepository;

@Service
public class ParentServiceImpl implements ParentService{
	@Autowired
	ParentRepository parentRepository;
	
	@Override
	public Optional<Parent> retrieveParent(Long id) {
		return this.parentRepository.findById(id);
	}

}
