package com.abc.trainingapp.repository;

import com.abc.trainingapp.entity.Course;
import com.abc.trainingapp.entity.Instructor;




public class CustomInstructorRepositoryImpl implements CustomInstructorRepository{



	@Override
	public Instructor updateCourseByInstructor(Instructor instructor, Course course) {

		instructor.setCourse(course);
		return instructor;
	}



}