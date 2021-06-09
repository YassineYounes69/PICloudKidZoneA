package com.example.kidszonea4arctic3.repositories;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.example.kidszonea4arctic3.models.BookMark;
import com.example.kidszonea4arctic3.models.Feedback;
import com.example.kidszonea4arctic3.models.Meeting;
public interface BookMarkRepository extends CrudRepository<BookMark, Long>{
	
	
	
	
	
	
	@Query("SELECT count(*),f.parent.fName,f.parent.lName FROM Feedback f WHERE f.parent.id=:idparent ")  
    public List<?> FeedbackByParent(@Param("idparent") long idparent);
	
	

	@Query("SELECT count(*) from Feedback p where p.parent.id=:idparent")  
    public long nbrFeedbackByParent(@Param("idparent") long idparent);

	
	@Query("SELECT p.parent.fName,p.parent.lName, count(*) from Feedback p group by p.feedback")  
	public List<?> nbrFeedbackByNameParent();
	
	
	@Query("SELECT p.childCareCenter.cost from Feedback p, ChildCareCenter c where p.childCareCenter.id=c.id")  
	public List<?>CostKidZone();
	
	@Query("SELECT count(*)  ,f.parent.fName from Feedback f,Parent p where f.parent.id=p.id ")  
	public List<?>CountFeedbackByParent();
	
	
	@Query("SELECT f FROM Feedback f WHERE f.childCareCenter.id =:id")
	public List<Feedback>getFeedbackByChildCareCenterId(@Param("id")Long id);
	
	
	@Query("SELECT b FROM BookMark b WHERE b.parent.id =:id")
	public List<BookMark>getBookMarkByParentId(@Param("id")Long id);
	

	

	@Query("SELECT count(*) FROM BookMark b WHERE b.parent.id =:id")
	public long getCountBookMarkByParentId(@Param("id")Long id);
	
	@Query("SELECT f.parent.fName FROM Feedback f WHERE f.parent.id =:id")
	public String getNameParentId(@Param("id")Long id);
	/*@Query("SELECT count(*),c.parent.firstName,c.parent.lastName FROM Comment c,User u where (c.parent.id=u.id) group by c.parent.id ")  
    public List<?> NbrFeedbackByChildCareCenter ();*/
	
	
	
	@Query(value="SELECT f from Feedback f where f.parent.fName like %:mot% or f.parent.lName like %:mot%")
	public List<Feedback> searchFeedback(@Param("mot") String mot);

}




