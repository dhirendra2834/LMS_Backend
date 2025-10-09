package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Course;
import com.example.demo.model.Subject;
import com.example.demo.model.User;
import com.example.demo.repository.SubjectRepository;

@Service
public class SubjectService {
	
	@Autowired
	SubjectRepository subjectRepository;
	
	@Autowired
	CourseService courseService;
	
	@Autowired 
	UserService userService;
	
	
	// Create the Subject 
	public String createSubject(Subject subject) {
		User user=subject.getCreatedBy();
		Optional<User> userData=userService.getById(user.getId());
		
		Course course=subject.getCourseId();
		Optional<Course> courseData=courseService.getCourseByCourseId(course.getId());
	
		if(user.isPresent() && course.isPresent()) {
			
		}
		return null;
		
	}
	
}
