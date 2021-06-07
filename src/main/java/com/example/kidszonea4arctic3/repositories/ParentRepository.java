package com.example.kidszonea4arctic3.repositories;


import com.example.kidszonea4arctic3.models.Parent;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ParentRepository extends CrudRepository<Parent, Long> {

    @Query("SELECT p FROM Parent p")
    public List<Parent> getAllParents();

    @Query("SELECT p FROM Parent p where p.email=:email and p.pw=:password")
    public Parent getParentByLoginPw(@Param("email") String login,@Param("password") String password);

    @Transactional
    @Modifying
    @Query("update Parent p set p.fName=:fName where p.id=:id ")
    public void updateParentFullName(@Param("id")Long id,@Param("fName") String fName);


}
