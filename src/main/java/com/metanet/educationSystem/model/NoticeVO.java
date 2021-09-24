package com.metanet.educationSystem.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeVO {
	private String noticeNO;
	private String noticeSubject;
	private String noticeContent;
	
	public NoticeVO(){
		this.noticeNO = null;
		this.noticeSubject = null;
		this.noticeContent = null;
	}
}
