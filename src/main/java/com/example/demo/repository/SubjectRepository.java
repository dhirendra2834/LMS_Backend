package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yaml.snakeyaml.events.Event.ID;

import com.example.demo.model.Course;

public interface  SubjectRepository extends  JpaRepository<Course, ID> {

}
