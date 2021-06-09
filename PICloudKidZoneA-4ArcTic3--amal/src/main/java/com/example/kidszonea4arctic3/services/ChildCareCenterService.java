package com.example.kidszonea4arctic3.services;

import java.util.Optional;

import com.example.kidszonea4arctic3.models.ChildCareCenter;


public interface ChildCareCenterService {
	Optional<ChildCareCenter> retrieveJardin(Long id);	
}
