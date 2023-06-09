package com.cg.onlineexamination.entity;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Exam {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int examId;
	private int dateOfExam;
	private int maximumScore;
	private int actualScore;
	private String difficultyLevel;
	private String status;
	
	
	public Exam(int dateOfExam,int maximumScore, int actualScore,
			String difficultyLevel,String status) {
		super();
		
		this.dateOfExam = dateOfExam;
		this.maximumScore = maximumScore;
		this.actualScore = actualScore;
		this.difficultyLevel = difficultyLevel;
		this.status = status;
	}
	
	

	
}
