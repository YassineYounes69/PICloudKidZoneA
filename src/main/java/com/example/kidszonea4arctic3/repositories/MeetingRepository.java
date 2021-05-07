package com.example.kidszonea4arctic3.repositories;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.kidszonea4arctic3.models.Child;
import com.example.kidszonea4arctic3.models.Meeting;
import com.example.kidszonea4arctic3.models.Parent;

public interface MeetingRepository extends CrudRepository<Meeting, Long>{

	void save(Optional<Meeting> meet);
	
	
	@Query("SELECT date FROM Meeting m ORDER BY m.date")
	/*@Query(value = "SELECT date FROM meeting m ORDER BY m.date " , nativeQuery =
			true)*/
	public List<Date> ListMeetingByDateTrier();
	
	@Query("SELECT m.parent.fName,m.parent.lName,m.date FROM Meeting m  ORDER BY m.date ")
	public List<?> allMeetingsByNameParent();
	
	
	@Query("SELECT p.parent.email from Child p")
	public String[] allEmailParent();
	
	

	
	/*@Query("Select count(*) , m.parent.fName, m.parent.lName From Meeting m where count(*)=Max(count(*))")
	public List<?> ParentWithMostMeeting();*/
	
	
	
	
	
	
	



	
	
}
