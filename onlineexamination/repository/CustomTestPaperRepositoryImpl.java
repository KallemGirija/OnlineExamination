package com.cg.onlineexamination.repository;

import com.cg.onlineexamination.entity.Exam;
import com.cg.onlineexamination.entity.TestPaper;


public class CustomTestPaperRepositoryImpl implements CustomTestPaperRepository {

	@Override
	public TestPaper updateExamByTestPaper(TestPaper testPaper, Exam exam) {

		testPaper.setExam(exam);
		return testPaper;
	}

}
