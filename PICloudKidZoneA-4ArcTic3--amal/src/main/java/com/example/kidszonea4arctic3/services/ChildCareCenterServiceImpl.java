package com.example.kidszonea4arctic3.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kidszonea4arctic3.models.ChildCareCenter;
import com.example.kidszonea4arctic3.repositories.ChildCareCenterRepository;

@Service
public class ChildCareCenterServiceImpl implements ChildCareCenterService{
	
	@Autowired
	ChildCareCenterRepository jardinRepository;
	
	
	@Override
	public Optional<ChildCareCenter> retrieveJardin(Long id) {
		return jardinRepository.findById(id);
	}

}
