package com.abc.trainingapp.service;

import java.util.List;


import org.springframework.stereotype.Service;
import com.abc.trainingapp.entity.Student;



@Service
public interface StudentService {


	public Student registerStudent(Student student);
	public List<Student> getAllStudent();
	public Student updateCourse(int StudentId,int courseId);
	public Student getCourseByStudentName(String StudentName, int CourseId);
	
	
}