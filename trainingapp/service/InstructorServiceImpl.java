package com.abc.trainingapp.service;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.trainingapp.entity.Course;
import com.abc.trainingapp.entity.Instructor;
import com.abc.trainingapp.repository.CourseRepository;
import com.abc.trainingapp.repository.InstructorRepository;

@Service
public class InstructorServiceImpl implements InstructorService{

	@Autowired
	InstructorRepository instructorRepository;

	@Autowired
	CourseRepository courseRepository;


	@Override
	public Instructor registerTrainer(Instructor instructor) {
		return instructorRepository.save(instructor);
	}

	@Override
	public List<Instructor> getAllTrainer() {
		return instructorRepository.findAll(); 
	}

	@Override
	public Instructor updateCourse(int instructorCode,int courseId) {

		// First Step : extract already saved instructor & course from DB

		Instructor savedInstructor = instructorRepository.getReferenceById(instructorCode);
		Course savedCourse = courseRepository.getReferenceById(courseId);

		// if both instructor & course is available in database
		if(savedInstructor != null & savedCourse != null) 
		{
			Instructor updatedInstructor = instructorRepository.updateCourseByInstructor(savedInstructor, savedCourse);
			instructorRepository.save(updatedInstructor);
			return updatedInstructor;
		}

		else return null;


	}

}

