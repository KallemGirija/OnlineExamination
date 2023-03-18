package com.abc.trainingapp.repository;

import com.abc.trainingapp.entity.Course;
import com.abc.trainingapp.entity.Student;

public interface CustomStudentRepository {

	public Student updateCourseByStudent(Student student,
			Course course);
	
	public Student getCourseByStudentName(Student student, Course course);
	
}