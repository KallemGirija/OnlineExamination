package com.abc.trainingapp.entity;

import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.abc.trainingapp.entity.Profile;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Student")
@Data
@NoArgsConstructor
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int studentId;
	@Column(name="studentName")
	private String studentName;
	private String feedback;
	private int marks;
	
	
	@Embedded
	@Column(nullable = true)
	private Profile profile;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Course course;
	
	
	public Student(String studentName, int studentId, String feedback, int marks) {
		super();
		this.studentName = studentName;
		this.studentId = studentId;
		this.feedback = feedback;
		this.marks = marks;
	}
	public Student(String studentName, int studentId, String feedback,int marks, Profile profile) {
		super();
		this.studentName = studentName;
		this.studentId = studentId;
		this.feedback = feedback;
		this.marks = marks;
		this.profile = profile;
	}
}

