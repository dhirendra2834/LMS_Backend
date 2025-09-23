package com.example.demo.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Course;
import com.example.demo.repository.CourseRepository;

@Service
public class CourseService {

	@Autowired
	CourseRepository courseRepository;
	
	// Get one course By Id
	public Optional<Course> getCourseByCourseId(int id) {
		Optional<Course>  courseData=courseRepository.findById(id);
		if(!courseData.isPresent()) {
			return null;
		}
		return courseData;
	}
	
	// get all course By CreateById
	public List<Course> getAllCoursesBy(int id){
		List<Course> courseData=CourseRepository.findByCreatedBy_Id(id);
		return courseData;
	}
	
    // Find All Course 
	public List<Course> getAllCourses(){
		
		return courseRepository.findAll();
	}
	
	
}
