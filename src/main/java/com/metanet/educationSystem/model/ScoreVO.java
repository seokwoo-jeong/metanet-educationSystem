package com.metanet.educationSystem.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ScoreVO {
	private String classNO;
	private String memberNO;
	private int midtermScore;
	private int finalsScore;
	private int assignmentScore;
	private int attendanceScore;
	private String grade;
	
	
	public ScoreVO() {
		this.classNO = null;
		this.memberNO = null;
		this.midtermScore = 0;
		this.finalsScore = 0;
		this.assignmentScore = 0;
		this.attendanceScore = 0;
		this.grade = null;
	}
}
