package com.metanet.educationSystem.model;


import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class NoticeVO {
	private int noticeNO;
	private String noticeSubject;
	private String noticeContent;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:MM:SS") 
	private String noticeDate;
	
	public NoticeVO(){
		this.noticeNO = 0;
		this.noticeSubject = null;
		this.noticeContent = null;
		this.noticeDate = null;
	}
}
