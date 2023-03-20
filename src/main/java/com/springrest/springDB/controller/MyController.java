package com.springrest.springDB.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springDB.entities.Course;
import com.springrest.springDB.service.CourseService;

@RestController
public class MyController {
	@Autowired
	CourseService courseservice;
	
	@GetMapping("/home")
	public String home() {
		return "Welcome to Home";
	}
	
	@GetMapping("/courses")
	public List<Course> getCourses(){
		return courseservice.getCourses();
	}
	
	@GetMapping("courses/{courseId}")
	public Course getCourse(@PathVariable String courseId) {
		return this.courseservice.getCourse(Long.parseLong(courseId));
	}
	
	@PostMapping("courses")
	public Course addCourse(@RequestBody Course course) {
		return this.courseservice.addCourse(course);
	}
	
	@PutMapping("courses")
	public Course updateCourse(@RequestBody Course course) {
		return this.courseservice.updateCourse(course);
	}
	
	@DeleteMapping("courses/{courseId}")
	public ResponseEntity<HttpStatus> removeCourse(@PathVariable String courseId){
		try {
			this.courseservice.removeCourse(Long.parseLong(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
