package com.metanet.educationSystem.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserVO {
	private int userNO;
	private String userName;
	private String userPassword;
	private String userEmail;
	private String userPhoneNO;
	private int userDistinct; //parameter ��Ȯ�� ����...
	
	
	public UserVO() {
		this.userNO = 0;
		this.userName = null;
		this.userPassword = null;
		this.userEmail = null;
		this.userPhoneNO = null;
		this.userDistinct = 0; //��Ȯ�� ����
	}
}
