package com.metanet.educationSystem.model;




import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CommentsVO {
	// 글 정보
	private String noticeNO;

	// 댓글 정보
	private String memberNO;
	private String commentNO;
	private String commentContent;
	
	private String commentDate;

}