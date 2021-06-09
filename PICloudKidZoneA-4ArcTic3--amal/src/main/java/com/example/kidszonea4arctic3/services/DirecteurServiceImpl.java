package com.example.kidszonea4arctic3.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kidszonea4arctic3.models.Employee;
import com.example.kidszonea4arctic3.repositories.EmployeeRepository;

@Service
public class DirecteurServiceImpl implements DirecteurService{
	@Autowired
	EmployeeRepository directeurRepository;
	@Override
	public Optional<Employee> retrieveDirecteur(Long id) {
		return directeurRepository.findById(id);
		
	}

}
