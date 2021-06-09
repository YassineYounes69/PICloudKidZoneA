package com.example.kidszonea4arctic3.services;

import java.util.Optional;

import com.example.kidszonea4arctic3.models.Employee;


public interface DirecteurService {
	Optional<Employee> retrieveDirecteur(Long id);	
}
