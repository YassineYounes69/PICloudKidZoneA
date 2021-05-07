package com.example.kidszonea4arctic3.repositories;


import com.example.kidszonea4arctic3.models.Parent;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ParentRepository extends CrudRepository<Parent, Long> {

    @Query("SELECT p FROM Parent p")
    public List<Parent> getAllParents();
}
