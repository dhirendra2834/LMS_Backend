package com.example.demo.service;

import java.util.List;
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
		User user = subject.getCreatedBy();
		Optional<User> userData = userService.getById(user.getId());

		Course course = subject.getCourseId();
		Optional<Course> courseData = courseService.getCourseByCourseId(course.getId());

		// Check if both user and course exist
		if (userData.isPresent() && courseData.isPresent()) {
			User dbUser = userData.get();
			Course dbCourse = courseData.get();

			// Allow only ADMIN or TEACHER to create subject
			if (dbUser.getRole() == User.Role.ADMIN || dbUser.getRole() == User.Role.TEACHER) {
				subject.setCreatedBy(dbUser);
				subject.setCourseId(dbCourse);

				subjectRepository.save(subject);
				return "Subject created successfully";
			} else {
				return "Permission denied: Only ADMIN or TEACHER can create subjects.";
			}
		} else {
			return "Invalid User or Course ID.";
		}
	}
	
	
	// get All Subject 
	public List<Subject> getAllSUbjects(){
		List<Subject> subjectsData= subjectRepository.findAll();
		return subjectsData;
	}
	
	// get All Subject by CourseID
	public List<Subject> getAllSubjectsByCourseId(int courseID){
		Optional<Course> courseData = courseService.getCourseByCourseId(courseID);
		if(courseData.isPresent()) {
			
		}
	}
	
	

}
