package com.example.demo.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Course;

@Repository
public interface CourseRepository extends  JpaRepository<Course, Integer> {
	
	public List<Course> findByCreatedBy_Id(int createdById); 
	
//	 Optional<Course> findByTitleAndCreatedBy_Id(String title, int createdById);
	
	boolean existsByTitleAndCreatedBy_Id(String title, int createdById);
}
