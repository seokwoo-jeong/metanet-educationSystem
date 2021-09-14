package com.metanet.educationSystem.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfessorVO {
	private int professorNO;
	private String professorMajor;
	private String professorRank;
	
	
	public ProfessorVO() {
		this.professorNO = 0;
		this.professorMajor = null;
		this.professorRank = null;
	}
}
