package com.abc.trainingapp.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.trainingapp.entity.Course;
import com.abc.trainingapp.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	CourseRepository courseRepository;
	
	
	@Override
	public Course addCourse(Course course) {

		return courseRepository.save(course);
	}

	@Override
	public List<Course> getAllCourses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Course getCoursebyName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Course getCoursebyId(int Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> getCoursebyCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
