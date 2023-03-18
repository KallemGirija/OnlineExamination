package com.cg.onlineexamination.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Studentdto {
	
	private int studentId;
	private String userName;
	private int password;
	private String firstName;
	private String lastName;
	private String gender;
	private String emailId;
	private long mobileNo;
	
	
	

}
