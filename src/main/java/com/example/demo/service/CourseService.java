package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Course;
import com.example.demo.model.User;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.UserRepository;

@Service
public class CourseService {

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	  UserService userService;

	// Create Course
	public String createCourse(Course course) {
	    User createdBy = course.getCreatedBy();

	    Optional<User> createdByPresent = userService.getById(createdBy.getId());
	    if (createdByPresent.isEmpty()) {
	        return "Created By user is not present";
	    }

	    if (courseRepository.existsByTitleAndCreatedBy_Id(course.getTitle(), createdBy.getId())) {
	        return "Course already exists for this user";
	    }

	    course.setCreatedBy(createdByPresent.get());
	    courseRepository.save(course);

	    return "Course created successfully";
	}

	// Get course By Course Id
	public Optional<Course> getCourseByCourseId(int id) {
		Optional<Course> courseData = courseRepository.findById(id);
		if (!courseData.isPresent()) {
			return null;
		}
		return courseData;
	}

	// get all course By CreateById
	public List<Course> getAllCoursesByUser(int id) {
		List<Course> courseData = courseRepository.findByCreatedBy_Id(id);
		return courseData;
	}

	// Find All Course
	public List<Course> getAllCourses() {

		return courseRepository.findAll();
	}

}
