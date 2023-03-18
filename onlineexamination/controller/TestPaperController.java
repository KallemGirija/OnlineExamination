package com.cg.onlineexamination.controller;

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

import com.cg.onlineexamination.dto.TestPaperdto;
import com.cg.onlineexamination.dto.TestQuestiondto;
import com.cg.onlineexamination.entity.TestPaper;
import com.cg.onlineexamination.entity.TestQuestion;
import com.cg.onlineexamination.service.TestPaperService;
import com.cg.onlineexamination.service.TestQuestionService;
import com.cg.onlineexamination.util.TestPaperDtoConvertor;
import com.cg.onlineexamination.util.TestQuestionDtoConvertor;

@RestController
@RequestMapping("/testPaper")
public class TestPaperController {
	private static final TestPaperdto savedTestPaper = null;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	TestPaperService testPaperService;
	
	@Autowired
	TestPaperDtoConvertor testPaperDtoConvertor;
	
	public TestPaperController() {
		logger.info("testpaper controller");
		System.err.println("testpaper controller");
	}
	
	@PostMapping("/register")
	public ResponseEntity<TestPaperdto> saveTestPaper(@RequestBody TestPaper testPaper) throws Exception {
        TestPaper savedTestPaper = testPaperService.addTestPaper(testPaper);
		logger.info(" --->> TestPaper saved " + savedTestPaper);

		if (savedTestPaper != null) {
			TestPaperdto dtoObj = testPaperDtoConvertor.getTestPaperdto(savedTestPaper);
			return new ResponseEntity<TestPaperdto>(dtoObj, HttpStatus.OK);

		}
		return null;
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<TestPaperdto>> getAllTestPapers()
	{
		List<TestPaper> allTestPapersInDB = testPaperService.getAllTestPaper();

		List<TestPaperdto> dtoList = new ArrayList<>();
		for (TestPaper testPaper : allTestPapersInDB) {

			TestPaperdto dtoObj = testPaperDtoConvertor.getTestPaperdto(testPaper);
			dtoList.add(dtoObj);
		}

		return new ResponseEntity<List<TestPaperdto>>(dtoList,HttpStatus.OK);
	}


	@PutMapping("/{tpid}/exam/{eid}")
	public String updateTestPaperWithExam(@PathVariable int tpid,@PathVariable int eid)
	{
		TestPaper updatedTestPaper = testPaperService.updateExam(tpid, eid);

		if(updatedTestPaper.getExam() != null)
		{
			return updatedTestPaper.toString();
		}
		else return "error : - "+updatedTestPaper.toString()+" ";
	}
}
	


