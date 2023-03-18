package com.cg.onlineexamination.service;

import java.io.InvalidClassException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineexamination.entity.Exam;
import com.cg.onlineexamination.entity.TestQuestion;
import com.cg.onlineexamination.repository.ExamRepository;
import com.cg.onlineexamination.repository.TestPaperRepository;
import com.cg.onlineexamination.repository.TestQuestionRepository;

@Service
public class TestQuestionServiceImpl implements TestQuestionService{
	
	@Autowired
	TestQuestionRepository testQuestionRepository;

	@Override
	public void checkAnswer(String option) {
		
		String correctAnswer = "B";
		if(option.equalsIgnoreCase(correctAnswer)) {
			System.out.println("Correct");
			
		}
		else {
			System.out.println("Incorrect. The correct answer is" +correctAnswer);
		}
		
	}


	@Override
	public TestQuestion addTestQuestion(TestQuestion testQuestion) throws Exception {
		if (testQuestion != null) {
			if (testQuestion.getCorrectAnswer().equals("")) {
				throw new InvalidClassException("testQuestion", "testQuestion is null");
			}
			TestQuestion savedTestQuestion = testQuestionRepository.save(testQuestion);
			return savedTestQuestion;
		} else
			throw new NullPointerException("testQuestion is null");
	}
	}
	
	
	


