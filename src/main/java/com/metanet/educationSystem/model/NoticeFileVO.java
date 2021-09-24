package com.metanet.educationSystem.model;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class NoticeFileVO {
	
    
	private String fileNO;
	private String noticeNO;
	private String originFileName;
	private String storedFilePath;
	private long fileSize;
	@DateTimeFormat(pattern = "yyyyMMdd") 
	private String registerFileDate;
	private int deleteFile;
	
	public NoticeFileVO() {
		this.fileNO = null;
		this.noticeNO = null;
		this.originFileName = null;
		this.storedFilePath = null;
		this.fileSize = 0;
		this.registerFileDate = null;
		this.deleteFile = -1;
	}
}
