package com.abc.trainingapp.service;
import java.util.List;







import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.trainingapp.entity.Course;
import com.abc.trainingapp.entity.Student;
import com.abc.trainingapp.repository.CourseRepository;
import com.abc.trainingapp.repository.StudentRepository;


@Service
public class StudentServiceImpl implements StudentService{


		@Autowired
		StudentRepository studentRepository;

		@Autowired
		CourseRepository courseRepository;

		

		@Override
		public Student registerStudent(Student student)
		{
			return studentRepository.save(student);
		}

	
		@Override
		public List<Student> getAllStudent() {
			return studentRepository.findAll(); 
		}
		
		
		@Override
		public Student updateCourse(int studentId, int courseId) {
			Student savedStudent = studentRepository.getReferenceById(studentId);
			Course savedCourse = courseRepository.getReferenceById(courseId);
			if(savedStudent != null & savedCourse != null) 
			{
				Student updatedStudent = studentRepository.updateCourseByStudent(savedStudent, savedCourse);
				studentRepository.save(updatedStudent); 
				return updatedStudent;
			}

			else return null;


		}


		@Override
		public Student getCourseByStudentName(String StudentName, int CourseId) {
			Student savedStudent = studentRepository.getCourseByStudentName(StudentName);
			Course savedCourse = courseRepository.getReferenceById(CourseId);
			if(savedStudent != null & savedCourse != null) 
			{
				Student updatedStudent = studentRepository.updateCourseByStudent(savedStudent, savedCourse);
				studentRepository.save(updatedStudent); 
				return updatedStudent;
			}
			else return null;
		}

	}
