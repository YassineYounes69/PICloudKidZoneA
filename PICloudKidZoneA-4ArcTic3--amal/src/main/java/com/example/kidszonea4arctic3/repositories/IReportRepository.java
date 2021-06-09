package com.example.kidszonea4arctic3.repositories;

import org.springframework.data.jpa.repository.Modifying;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import com.example.kidszonea4arctic3.models.Report;
import com.example.kidszonea4arctic3.models.ReportPK;



public interface IReportRepository extends CrudRepository <Report,ReportPK> {
	
	
	@Query("select count(r) from Report r where r.parent.id =:idu  and r.publication.id =:idp")
	public long isReportExists(@Param("idu")long idu,@Param("idp")long idp);
	
	@Transactional
	@Modifying (clearAutomatically = true)
	@Query (value= "Delete from Report r where r.publication.id= :id")
	public void deleteReport(@Param("id") long id);
	
	
	//void deleteByPost(long id);
	
}