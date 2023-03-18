package com.cg.onlineexamination.service;

import java.io.InvalidClassException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineexamination.entity.Exam;
import com.cg.onlineexamination.entity.TestPaper;
import com.cg.onlineexamination.repository.ExamRepository;
import com.cg.onlineexamination.repository.TestPaperRepository;

@Service
public class TestPaperServiceImpl implements TestPaperService{

	@Autowired
	TestPaperRepository testPaperRepository;
	
	@Autowired
	ExamRepository examRepository;
	

	@Override
	public TestPaper addTestPaper(TestPaper t) throws Exception {
		if (t != null) {
			if (t.getDifficultyLevel().equals("")) {
				throw new InvalidClassException("testPaper", "testPaper is null");
			}
			TestPaper savedTestPaper = testPaperRepository.save(t);
			return savedTestPaper;
		} else
			throw new NullPointerException("testPaper is null");
	}

	@Override
	public List<TestPaper> getAllTestPaper() {
		
		return testPaperRepository.findAll();
	}

	@Override
	public TestPaper updateExam(int testPaperId, int examId) {
		TestPaper savedTestPaper = testPaperRepository.getReferenceById(testPaperId);
		Exam savedExam = examRepository.getReferenceById(examId);

		if(savedTestPaper != null & savedExam != null) 
		{
			TestPaper updatedTestPaper = testPaperRepository.updateExamByTestPaper(savedTestPaper, savedExam);
			testPaperRepository.save(updatedTestPaper);
			return updatedTestPaper;
		}
		else return null;
	}
	}


