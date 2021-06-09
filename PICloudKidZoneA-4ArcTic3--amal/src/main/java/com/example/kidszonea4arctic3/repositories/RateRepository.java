package com.example.kidszonea4arctic3.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.kidszonea4arctic3.models.Rate;


public interface RateRepository extends JpaRepository<Rate, Long> {
	@Transactional
	@Modifying
	@Query(value = "INSERT INTO rate (value) VALUES (:val)", nativeQuery = true)
	void addRate(@Param("val") int val);
	
	@Query(value = "SELECT * FROM rate ORDER BY id DESC LIMIT 1" , nativeQuery =true)
			Rate retrieveLastRate();
	
	@Transactional
	@Modifying
	@Query(value = "INSERT INTO rate_events (rates_id, events_id) VALUES (:idRate,:idEvent)", nativeQuery = true)
	void addRateEvent(@Param("idRate") Long idRate, @Param("idEvent") Long idEvent);
	
	
}
