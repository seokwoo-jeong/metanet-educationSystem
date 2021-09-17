package com.metanet.educationSystem.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberVO {
	private int memberNO;
	private String memberName;
	private String memberPassword;
	private String memberEmail;
	private String memberPhoneNO;
	private int memberDistinct; //parameter ��Ȯ�� ����...
	
	
	public MemberVO() {
		this.memberNO = 0;
		this.memberName = null;
		this.memberPassword = null;
		this.memberEmail = null;
		this.memberPhoneNO = null;
		this.memberDistinct = 0; 
	}
}
