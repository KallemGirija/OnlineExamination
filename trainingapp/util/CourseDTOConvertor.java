package com.abc.trainingapp.util;

import org.springframework.stereotype.Component;

import com.abc.trainingapp.dto.CourseAdminResponseDTO;
import com.abc.trainingapp.entity.Course;

@Component
public class CourseDTOConvertor {

	public CourseAdminResponseDTO getCourseAdminResponseDTO(Course course)
	{
		CourseAdminResponseDTO dto = new CourseAdminResponseDTO();
		dto.setCourseId(course.getCourseId());
		dto.setCourseName(course.getCourseName());
		dto.setMsg("Course Saved");
		return dto;
	}
}