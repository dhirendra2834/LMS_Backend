package com.example.demo.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Course;
import com.example.demo.service.CourseService;

@RestController

public class CourseController {
	
	@Autowired
	CourseService courseService;
	
	@PostMapping("/course")
	public String createCourse(@RequestBody Course course) {
	
		return courseService.createCourse(course);
	}
	
//	 Get Course by Course Id
	@GetMapping("/courses/{id}")
	public ResponseEntity<?> getCourse(@PathVariable int id) {
	    Optional<Course> course = courseService.getCourseByCourseId(id);

	    if (course.isPresent()) {
	        return ResponseEntity.ok(course.get()); // returns Course
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                             .body("Course not found"); // returns String
	    }
	}

//	 Get all courses 
	@GetMapping("/courses")
	public List<Course> getAllCourse(){
		List<Course> coursesData= courseService.getAllCourses();
		return coursesData;
	}

//	 get all courses by User 
	@GetMapping("/getAllCourseByUserID")
	public List<Course> getAllCourseByUserId(int id){
		
		return null;
	}
	
	@GetMapping
	public List<Course> getAllCourseMethod(){
		return null;
	}
}
