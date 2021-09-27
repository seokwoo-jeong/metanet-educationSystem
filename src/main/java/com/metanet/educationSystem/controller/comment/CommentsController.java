package com.metanet.educationSystem.controller.comment;

import java.util.Date;
import java.util.HashMap;
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
	public List<HashMap<String, Object>> noticeCommentsList(HttpServletRequest request, 
			@RequestParam(value="noticeNO") String noticeNO) throws Exception {
		System.out.println("/notice/getCommentsList, no="+noticeNO);
		List<HashMap<String, Object>> commentsList = commentService.getCommentsList(noticeNO);
		return commentsList;
	}
	
	@RequestMapping("/notice/insertComment")
	public List<HashMap<String, Object>> insertComment(HttpServletRequest request, 
			String commentContent, String noticeNO, String memberNO) throws Exception {
		System.out.println("/notice/insertComment, content="+commentContent+memberNO+noticeNO);
		commentService.insertComments(noticeNO, memberNO, commentContent);
		List<HashMap<String, Object>> commentsList = commentService.getCommentsList(noticeNO);
		System.out.println(commentsList);
		return commentsList;
	}
	
	@RequestMapping("/notice/deleteComment")
	public String deleteComment(HttpServletRequest request, 
			String commentNO) throws Exception {
		System.out.println("/notice/deleteComment, content=");
		String message=null;
		int result = commentService.deleteComments(commentNO);
		if(result==1) {
	        message = "success";
	    }else {
	        message ="fail";
	    }	
		return message;
	}
}
