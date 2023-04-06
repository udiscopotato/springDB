package com.springrest.springDB.service;

//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springDB.dao.CourseDao;
import com.springrest.springDB.entities.Course;

@Service
public class CourseServiceImplementation implements CourseService {
	@Autowired
	private CourseDao coursedao;
//	List<Course> list;
	
	public CourseServiceImplementation() {
//		list = new ArrayList<>();
//		list.add(new Course(111, "Core Java", "Basic Programming with Java"));
//		list.add(new Course(222, "Python", "Python with DataScience"));
//		list.add(new Course(333, "GoLang", "Introduction to Go") );
//		list.add(new Course(444, "PHP", "Server side Scripting using PHP"));
	}
	@Override
	public List<Course> getCourses() {
		return coursedao.findAll();
	}
	
	@Override
	public Course getCourse(long courseId) {
		// TODO Auto-generated method stub
//		Course cour=null;
//		for(Course course: list) {
//			if(course.getId() == courseId) {
//				cour=course;
//				break;
//			}
//		}
		return coursedao.getReferenceById(courseId);
	}
	
	@Override
	public Course addCourse(Course course) {
//		list.add(course);
		coursedao.save(course);
		return course;
	}
	
	@Override
	public Course updateCourse(Course course) {
//		Course c = null;
//		for(Course courses: list) {
//			if(courses.getId() == course.getId()) {
//				c=course;
//				courses.setName(course.getName());
//				courses.setDescription(course.getDescription());
//				break;
//			}
//		}
//		if(c == null) {
//			c=addCourse(course);
//		}
		coursedao.save(course);
		return course;
	}
	
	@Override
	public void removeCourse(long courseId) {
//		for(Course course: list) {
//			if(course.getId() == courseId) {
//				list.remove(course);
//			}
//		}
		Course entity = coursedao.getReferenceById(courseId);
		coursedao.delete(entity);
	}
	
	

}
