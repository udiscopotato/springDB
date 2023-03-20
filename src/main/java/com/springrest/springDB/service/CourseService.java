package com.springrest.springDB.service;

import java.util.List;

import com.springrest.springDB.entities.Course;

public interface CourseService {
	public List<Course> getCourses();
	public Course getCourse(long courseId);
	public Course addCourse(Course course);
	public Course updateCourse(Course course);
	public void removeCourse(long courseId);
}
