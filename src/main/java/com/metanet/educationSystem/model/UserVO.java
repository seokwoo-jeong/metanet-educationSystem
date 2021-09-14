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
	private int userDistinct; //parameter 정확히 정의...
	
	
	public UserVO() {
		this.userNO = 0;
		this.userName = null;
		this.userPassword = null;
		this.userEmail = null;
		this.userPhoneNO = null;
		this.userDistinct = 0; //정확히 정의
	}
}
