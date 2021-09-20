package com.metanet.educationSystem.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StudentVO {
	private String studentNO;
	private String studentMajor;
	private int studentSemester;
	
	public StudentVO() {
		this.studentNO = null;
		this.studentMajor = null;
		this.studentSemester = 0;
	}
}
