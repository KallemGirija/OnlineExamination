package com.cg.onlineexamination.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineexamination.dto.Examdto;
import com.cg.onlineexamination.dto.TestQuestiondto;
import com.cg.onlineexamination.entity.Exam;
import com.cg.onlineexamination.entity.TestQuestion;
import com.cg.onlineexamination.service.ExamService;
import com.cg.onlineexamination.service.TestQuestionService;
import com.cg.onlineexamination.util.ExamDtoConvertor;
import com.cg.onlineexamination.util.TestQuestionDtoConvertor;

@RestController
@RequestMapping("/testQuestion")
public class TestQuestionController {
	
	private static final TestQuestiondto savedTestQuestion = null;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	TestQuestionService testQuestionService;
	
	@Autowired
	TestQuestionDtoConvertor testQuestionDtoConvertor;
	
	
	public TestQuestionController() {
		logger.info("testquestion controller");
		System.err.println("testquestion controller");
	}
	
	@PostMapping("/register")
	public ResponseEntity<TestQuestiondto> saveTestQuestion(@RequestBody TestQuestion testQuestion) throws Exception {
        TestQuestion savedTestQuestion = testQuestionService.addTestQuestion(testQuestion);
		logger.info(" --->> TestQuestion saved " + savedTestQuestion);

		if (savedTestQuestion != null) {
			TestQuestiondto dtoObj = testQuestionDtoConvertor.getTestQuestiondto(savedTestQuestion);
			return new ResponseEntity<TestQuestiondto>(dtoObj, HttpStatus.OK);

		}
		return null;
	}
			




	
	
}
