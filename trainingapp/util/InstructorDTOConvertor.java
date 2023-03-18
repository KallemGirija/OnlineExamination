package com.abc.trainingapp.util;


import org.springframework.stereotype.Component;


import com.abc.trainingapp.entity.Instructor;
import com.abc.trainingapp.dto.InstructorDTODefaultResponse;



@Component
public class InstructorDTOConvertor {

	
	public InstructorDTODefaultResponse convertTo(Instructor instructor)
	{

		return new InstructorDTODefaultResponse(instructor.getInsCode(), instructor.getInsName());
	}
}

