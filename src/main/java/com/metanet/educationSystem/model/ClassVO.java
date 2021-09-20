package com.metanet.educationSystem.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ClassVO {
	private String classNO;
	private String className;
	private String classGoal;
	private String classSummary;
	private int classPersonnel;
	private int classCredit;
	private String memberNO;
	
	public ClassVO() {
		this.classNO = null;
		this.className = null;
		this.classGoal = null;
		this.classSummary = null;
		this.classPersonnel = 0;
		this.classCredit = 0;
		this.memberNO = null;
	}

}
