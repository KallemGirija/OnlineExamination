package com.abc.trainingapp.repository;
import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;


import com.abc.trainingapp.entity.Student;



@Repository
public interface StudentRepository  extends
	        JpaRepository<Student,Integer>,CustomStudentRepository
	{

	Student getCourseByStudentName(String studentName);
	

	}
