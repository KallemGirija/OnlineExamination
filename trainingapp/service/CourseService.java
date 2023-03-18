package com.abc.trainingapp.service;


import java.util.List;



import org.springframework.stereotype.Service;

import com.abc.trainingapp.entity.Course;


@Service
public interface CourseService {

	  public Course addCourse(Course Course);
	  public Course getCoursebyName(String name);
	  public Course getCoursebyId(int Id);
	  public List<Course> getAllCourses();
	  public List<Course> getCoursebyCategory(String category);
	
	
}
