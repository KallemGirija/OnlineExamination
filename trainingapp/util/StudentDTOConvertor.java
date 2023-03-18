package com.abc.trainingapp.util;

	import org.springframework.stereotype.Component;
    import com.abc.trainingapp.entity.Student;
    import com.abc.trainingapp.dto.StudentDTODefaultResponse;



	@Component
	public class StudentDTOConvertor {

		
		public StudentDTODefaultResponse convertTo(Student student)
		{

			return new StudentDTODefaultResponse(student.getStudentId(), student.getStudentName());
		}
	}


