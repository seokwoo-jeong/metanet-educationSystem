package com.metanet.educationSystem.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminVO {
	private int adminNO;
	private String adminDepartment;
	
	public AdminVO() {
		this.adminNO = 0;
		this.adminDepartment = null; 
	}
}
