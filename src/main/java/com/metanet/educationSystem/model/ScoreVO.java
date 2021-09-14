package com.metanet.educationSystem.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScoreVO {
	private int classNO;
	private int userNO;
	private int midtermScore;
	private int finalsScore;
	private int assignmentScore;
	private int attendanceScore;
	private String grade;
	
	
	public ScoreVO() {
		this.classNO = 0;
		this.userNO = 0;
		this.midtermScore = 0;
		this.finalsScore = 0;
		this.assignmentScore = 0;
		this.attendanceScore = 0;
		this.grade = null;
	}
}
