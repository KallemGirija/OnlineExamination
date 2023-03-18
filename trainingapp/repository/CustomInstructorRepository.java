package com.abc.trainingapp.repository;

import com.abc.trainingapp.entity.Course;



import com.abc.trainingapp.entity.Instructor;

public interface CustomInstructorRepository {

	public Instructor updateCourseByInstructor(Instructor instructor,
			Course course);

}