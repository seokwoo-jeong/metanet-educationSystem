package com.metanet.educationSystem.controller.comment;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.metanet.educationSystem.model.CommentsVO;
import com.metanet.educationSystem.service.comment.CommentsService;

@RestController
public class CommentsController {
	
	@Autowired
	@Lazy
	private CommentsService commentService;

	@RequestMapping("/notice/getCommentsList")
	public List<CommentsVO> noticeCommentsList(HttpServletRequest request, 
			@RequestParam(value="no") String noticeNO) throws Exception {
		System.out.println("코멘트 컨트롤러 찍힘");
		List<CommentsVO> commentsList = commentService.getCommentsList(noticeNO);
		for (CommentsVO commentsVO : commentsList) {
			System.out.println(commentsVO.toString());
		}
		return commentsList;
	}
}
