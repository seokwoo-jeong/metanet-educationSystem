package com.metanet.educationSystem.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberVO {
	private int memberNO;
	private String memberName;
	private String memberPassword;
	private String memberEmail;
	private String memberPhoneNO;
	private int memberDistinct; //parameter 정확히 정의...
	
	
	public MemberVO() {
		this.memberNO = 0;
		this.memberName = null;
		this.memberPassword = null;
		this.memberEmail = null;
		this.memberPhoneNO = null;
		this.memberDistinct = 0; //정확히 정의
	}
}
