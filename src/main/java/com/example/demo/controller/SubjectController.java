package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Subject;
import com.example.demo.service.SubjectService;

@RestController
public class SubjectController {
	
	@Autowired
	SubjectService subjectService;
	
	// Create Subject Controller
	@PostMapping("/Subject")
	public String createSubject(Subject subject)
	{
		return subjectService.createSubject(subject);
	}
	
	// get Subject Controller
	@GetMapping("/Subject/{id}")
	public ResponseEntity<?> getSubjectBySubjectId(@PathVariable int id) {

		Optional<Subject> subjectData= subjectService.getSubjectById(id);
		if(subjectData.isPresent()) {
			 return ResponseEntity.ok(subjectData.get());
		}
		 return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Subject not found with ID: " + id);
	}
	
	
	@GetMapping("/Subjects/{courseId}")
	public ResponseEntity<?> getAllSubjectsByCourseId(@PathVariable int id){
		List<Subject> subjectData=subjectService.getAllSubjectsByCourseId(id);
		  if(subjectData.isEmpty()) {
			  return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No subjects found for course ID" + id);
		    }
		    
		    return ResponseEntity.ok(subjectData);
	}
	
	@DeleteMapping("/Subject/{id}")
	public String deleteSubjectById(@PathVariable int subjectId) {
		
		return subjectService.deleteSubjectById(subjectId);
	}
	
}