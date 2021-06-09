package com.example.kidszonea4arctic3.repositories;

import com.example.kidszonea4arctic3.models.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	
}
