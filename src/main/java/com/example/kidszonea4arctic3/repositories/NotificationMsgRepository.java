package com.example.kidszonea4arctic3.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.kidszonea4arctic3.models.NotificationMsg;
import com.example.kidszonea4arctic3.models.Parent;



@Repository
public interface NotificationMsgRepository extends CrudRepository<NotificationMsg,Long> {

	@Query("select n from NotificationMsg n where n.userReceive= :user ORDER BY n.createdAt DESC")
	List<NotificationMsg> userNotification(@Param("parent") Parent parent);

}
