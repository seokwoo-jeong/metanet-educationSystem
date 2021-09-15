package com.metanet.educationSystem.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StudentVO {
	private int studentNO;
	private String studentMajor;
	private int studentSemester;
	
	public StudentVO() {
		this.studentNO = 0;
		this.studentMajor = null;
		this.studentSemester = 0;
	}
}
