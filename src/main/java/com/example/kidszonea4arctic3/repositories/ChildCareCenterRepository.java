package com.example.kidszonea4arctic3.repositories;

import com.example.kidszonea4arctic3.models.ChildCareCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface ChildCareCenterRepository extends CrudRepository<ChildCareCenter, Long>, JpaRepository<ChildCareCenter, Long>, JpaSpecificationExecutor<ChildCareCenter> {

}
