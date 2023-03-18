package com.abc.trainingapp.controller;
	import java.util.ArrayList;






	import java.util.List;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.PutMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

	
import com.abc.trainingapp.service.StudentService;
import com.abc.trainingapp.dto.StudentDTODefaultResponse;
import com.abc.trainingapp.entity.Student;
import com.abc.trainingapp.util.StudentDTOConvertor;

	@RestController
	@RequestMapping("/student")
	public class StudentRestController {

		private final Logger logger = LoggerFactory.getLogger(this.getClass());

		@Autowired
		StudentService studentService;

		@Autowired
		StudentDTOConvertor dtoConvertor;


		public StudentRestController() {
			logger.info("Student Rest Controller called");
			System.err.println("Student Rest Controller called");
		}

		@PostMapping("/register")
		public ResponseEntity<StudentDTODefaultResponse> saveStudent(@RequestBody Student student)
		{
			Student savedStudent = studentService.registerStudent(student);
			logger.info(" --->> Student saved "+savedStudent);

			StudentDTODefaultResponse dtoObj = dtoConvertor.convertTo(savedStudent);


			return new ResponseEntity<StudentDTODefaultResponse>(dtoObj,HttpStatus.OK);
		}

		@GetMapping("/list")
		public ResponseEntity<List<StudentDTODefaultResponse>> getAllStudents()
		{
			List<Student> allstudentsInDB = studentService.getAllStudent();

			List<StudentDTODefaultResponse> dtoList = new ArrayList<>();
			for (Student student : allstudentsInDB) {

				StudentDTODefaultResponse dtoObj = dtoConvertor.convertTo(student);
				dtoList.add(dtoObj);
			}

			return new ResponseEntity<List<StudentDTODefaultResponse>>(dtoList,HttpStatus.OK);
		}


		@PutMapping("/{sid}/student/{cid}")
		public String updateStudentWithCourse(@PathVariable int sid,@PathVariable int cid)
		{
			Student updatedStudent = studentService.updateCourse(sid, cid);

			if(updatedStudent.getCourse() != null)
			{
				return updatedStudent.toString();
			}
			else return "error : - "+updatedStudent.toString()+" ";
		}
		
		@PutMapping("/{sName}/student/{cid}")
		public String getCourseByStudentName(@PathVariable String sName,@PathVariable int cid)
		{
			Student updatedStudent = studentService.getCourseByStudentName(sName, cid);

			if(updatedStudent.getCourse() != null)
			{
				return updatedStudent.toString();
			}
			else return "error : - "+updatedStudent.toString()+" ";
		}
		
		
	}
