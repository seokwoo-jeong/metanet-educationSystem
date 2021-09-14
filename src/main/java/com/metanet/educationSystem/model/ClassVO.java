package com.metanet.educationSystem.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClassVO {
	private int classNO;
	private String className;
	private String classGoal;
	private String classSummary;
	
	public ClassVO() {
		this.classNO = 0;
		this.className = null;
		this.classGoal = null;
		this.classSummary = null;
	}

}
