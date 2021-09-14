package com.metanet.educationSystem.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeptVO {
	private int deptno;
	private String dname;
	private String loc;
	
	public DeptVO() {
		this.deptno = 0;
		this.dname = "";
		this.loc = "";
	}
}
