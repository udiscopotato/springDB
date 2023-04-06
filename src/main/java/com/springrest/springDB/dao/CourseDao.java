package com.springrest.springDB.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrest.springDB.entities.Course;

public interface CourseDao extends JpaRepository<Course, Long> {
	
}
