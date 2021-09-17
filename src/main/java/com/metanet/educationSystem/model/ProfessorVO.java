package com.metanet.educationSystem.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProfessorVO {
	private String professorNO;
	private String professorMajor;
	private String professorRank;
	
	
	public ProfessorVO() {
		this.professorNO = null;
		this.professorMajor = null;
		this.professorRank = null;
	}
}
