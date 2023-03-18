package com.abc.trainingapp.controller;
import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.trainingapp.dto.CourseAdminResponseDTO;
import com.abc.trainingapp.util.CourseDTOConvertor;
import com.abc.trainingapp.entity.Course;
import com.abc.trainingapp.service.CourseService;


@RestController
@RequestMapping("/app/course")
public class CourseController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CourseService courseService;

	@Autowired
	CourseDTOConvertor courseDTOConvertor;


	public CourseController() {
		logger.info("---Course Controller Called --");
		logger.warn("---Course Controller Called --");

		System.out.println("Course Controller Called");
	}

	@GetMapping("/welcome")
	public String sayHello()
	{
		LocalDateTime todayDate = LocalDateTime.now();
		return "Welcome "+todayDate;
	}

	@PostMapping("/")
	public ResponseEntity<CourseAdminResponseDTO> addCourse(@RequestBody Course course)
	{
		Course savedCourse = courseService.addCourse(course);

		CourseAdminResponseDTO responseDTO = courseDTOConvertor.getCourseAdminResponseDTO(savedCourse);
		return new ResponseEntity<CourseAdminResponseDTO>(responseDTO,HttpStatus.OK);
	}



}