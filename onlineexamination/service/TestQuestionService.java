package com.cg.onlineexamination.service;

import org.springframework.stereotype.Service;

import com.cg.onlineexamination.entity.Exam;
import com.cg.onlineexamination.entity.TestQuestion;

@Service
public interface TestQuestionService {
	
	public TestQuestion addTestQuestion(TestQuestion TestQuestion)throws Exception;
	public void checkAnswer(String option);

}
