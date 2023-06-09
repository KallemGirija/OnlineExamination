package com.cg.onlineexamination.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestPaper {
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int testPaperId;
	private String difficultyLevel;
	private String description;
	private String course;
	
       
	@OneToMany(cascade = CascadeType.ALL)
     private Exam exam;
	
	public TestPaper(String difficultyLevel, String description,String course) {
		super();
		
		this.difficultyLevel = difficultyLevel;
		this.description = description;
		this.course = course;
	}

}
