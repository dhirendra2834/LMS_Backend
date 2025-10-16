package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Subject;

@Repository
public interface  SubjectRepository extends  JpaRepository<Subject, Integer> {

	 // Fetch all subjects by course ID
    List<Subject> findByCourseId_Id(int courseId);
    
}
