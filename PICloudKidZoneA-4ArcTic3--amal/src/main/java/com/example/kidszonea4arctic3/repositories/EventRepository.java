package com.example.kidszonea4arctic3.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.kidszonea4arctic3.models.Category;
import com.example.kidszonea4arctic3.models.CategoryEvent;
import com.example.kidszonea4arctic3.models.Event;


public interface EventRepository extends JpaRepository<Event, Long> {
	
	@Query(value = "SELECT * FROM event e WHERE e.child_care_center_id= :idJardin " , nativeQuery =true)
	 List<Event> findByIdJardin(@Param("idJardin")Long idJardin);
	
	@Modifying
    @Transactional
    @Query(value ="UPDATE event e SET e.nb_participants=nb_participants + 1 WHERE e.id= :idEvent ", nativeQuery =true)
    public void participer(@Param("idEvent")Long idEvent);
	
	@Query("SELECT e FROM Event e WHERE e.category = ?1")
	 List<Event> findByCategory(CategoryEvent category);
	
	@Query(value = "SELECT *, AVG(r.value) as moy FROM event e , rate r, rate_events re WHERE e.id = re.events_id AND r.id = re.rates_id AND e.child_care_center_id= :idJardin GROUP BY e.id ORDER BY moy DESC", nativeQuery = true)
	 List<Event> findByIdJardinSortedByRate(@Param("idJardin")Long idJardin);

	 
	
}
