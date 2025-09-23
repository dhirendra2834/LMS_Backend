package com.example.demo.controller;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Course;

@RestController

public class CourseController {
	
	@PostMapping("/course")
	public String createCourse(@RequestBody Course course) {
		
		return null;
	}
	
	@GetMapping("/courses{id}")
	public Course getCourseByID(int id) {	
		return null;	
	}
	
	@GetMapping("/courses")
	public List<Course> getAllCourse(){
		return null;
	}

	@GetMapping("getAllCourseByUserID")
	public List<Course> getAllCourseByUserId(int id){
		
		return null;
	}
	
	@GetMapping
	public List<Course> getAllCourseMethod(){
		return null;
	}
}
