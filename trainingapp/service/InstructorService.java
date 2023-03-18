package com.abc.trainingapp.service;

import java.util.List;




import org.springframework.stereotype.Service;

import com.abc.trainingapp.entity.Instructor;



@Service
public interface InstructorService {


	public Instructor registerTrainer(Instructor instructor);
	public List<Instructor> getAllTrainer();
	public Instructor updateCourse(int instructorCode,int courseId);
}