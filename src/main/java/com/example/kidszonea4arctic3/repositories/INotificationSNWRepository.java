package com.example.kidszonea4arctic3.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.kidszonea4arctic3.models.NotificationSNW;

@Repository
public interface INotificationSNWRepository  extends CrudRepository<NotificationSNW,Long >{	
	
	
	@Modifying (clearAutomatically = true)
	@Query (value= "Delete from NotificationSNW n where n.id= :id")
	public void deleteById(@Param("id") long id);
	
	@Query("SELECT n FROM NotificationSNW n WHERE n.receiver =:id order by n.date desc")
	public List<NotificationSNW> getNotifByUser(@Param("id")long id);
	
	
}