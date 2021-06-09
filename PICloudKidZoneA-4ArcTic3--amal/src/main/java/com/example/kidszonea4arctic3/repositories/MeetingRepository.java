package com.example.kidszonea4arctic3.repositories;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.kidszonea4arctic3.models.Meeting;

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
	
	
	@Query("SELECT p.parent.fName from Child p")
	public List<?> allNameParent();
	
	
	@Query("SELECT m FROM Meeting m WHERE m.parent.id =:id order by m.date desc")
	public List<Meeting>getMeetingByParentId(@Param("id")Long id);
	
	/*@Query("Select count(*) , m.parent.fName, m.parent.lName From Meeting m where count(*)=Max(count(*))")
	public List<?> ParentWithMostMeeting();*/
	
	
	    @Transactional
	    @Modifying
	    @Query("update Meeting m set m.state=true where m.id=:id ")
	    public void updateMeetingState(@Param("id")Long id);
	

	
	
	
	
	



	
	
}
