package com.example.kidszonea4arctic3.repositories;

import com.example.kidszonea4arctic3.models.Child;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ChildRepository extends JpaRepository<Child, Long> {
}
