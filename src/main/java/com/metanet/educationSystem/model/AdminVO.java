package com.metanet.educationSystem.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AdminVO {
	private int adminNO;
	private String adminDepartment;
	
	public AdminVO() {
		this.adminNO = 0;
		this.adminDepartment = null; 
	}
}
