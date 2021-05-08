package com.example.kidszonea4arctic3.repositories;


import com.example.kidszonea4arctic3.models.Parent;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ParentRepository extends CrudRepository<Parent, Long> {

    @Query("SELECT p FROM Parent p")
    public List<Parent> getAllParents();

    @Query("SELECT p FROM Parent p where p.email=:email and p.pw=:password")
    public Parent getParentByLoginPw(@Param("email") String login,@Param("password") String password);
}
