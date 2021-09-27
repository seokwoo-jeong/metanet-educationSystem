package com.metanet.educationSystem.model;


import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class NoticeVO {
	private String noticeNO;
	private String noticeSubject;
	private String noticeContent;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd") 
	private Date noticeDate;
	
	public NoticeVO(){
		this.noticeNO = null;
		this.noticeSubject = null;
		this.noticeContent = null;
		this.noticeDate = null;
	}
}
