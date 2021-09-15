package com.metanet.educationSystem.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
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
