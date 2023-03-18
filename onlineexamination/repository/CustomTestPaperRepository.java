package com.cg.onlineexamination.repository;

import com.cg.onlineexamination.entity.Exam;
import com.cg.onlineexamination.entity.TestPaper;

public interface CustomTestPaperRepository {

	public  TestPaper updateExamByTestPaper(TestPaper testPaper,
			Exam exam);
	
}
