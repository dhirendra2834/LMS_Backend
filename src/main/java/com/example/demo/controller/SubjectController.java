package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@PostMapping("/Subject")
	public String createSubject(Subject subject)
	{
		return null;
	}
	
	@GetMapping("/Subject/{id}")
	public ResponseEntity<?> getSubjectBySubjectId(@PathVariable int id) {
//		Subject subjectData= 
		return null;
	}
	
	@GetMapping("/Subjects/{courseId}")
	public ResponseEntity<?> getAllSubjectsByCourseId(@PathVariable int id){
		return null;
	}
	
	@DeleteMapping("/Subject/{id}")
	public String deleteSubjectById() {
		
		return null;
	}
	
}