package com.metanet.educationSystem.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AdminVO {
	private String adminNO;
	private String adminDepartment;
	
	public AdminVO() {
		this.adminNO = null;
		this.adminDepartment = null; 
	}
}
