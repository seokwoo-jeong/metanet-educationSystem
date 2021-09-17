package com.metanet.educationSystem.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeVO {
	private int noticeNO;
	private String noticeSubject;
	private String noticeContent;
	
	public NoticeVO(){
		this.noticeNO = 0;
		this.noticeSubject = null;
		this.noticeContent = null;
	}
}
