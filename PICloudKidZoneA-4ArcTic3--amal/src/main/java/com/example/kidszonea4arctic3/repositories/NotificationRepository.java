package com.example.kidszonea4arctic3.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.kidszonea4arctic3.models.Notification;


public interface NotificationRepository extends JpaRepository<Notification, Long> {
	
	@Query(value = "SELECT * FROM notification n WHERE n.directeur_id= :idDirecteur " , nativeQuery =true)
	 List<Notification> findByIdDirecteur(@Param("idDirecteur")Long idDirecteur);
	
	@Modifying
    @Transactional
    @Query("UPDATE Notification n SET n.isRead=true where n.id=:notifId")
    public void readNotif( @Param("notifId")Long notifId);
}
