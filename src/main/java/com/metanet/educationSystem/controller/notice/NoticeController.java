package com.metanet.educationSystem.controller.notice;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.metanet.educationSystem.model.NoticeVO;
import com.metanet.educationSystem.service.comment.CommentsService;
import com.metanet.educationSystem.service.notice.NoticeService;


@Controller
public class NoticeController {
    
	@Autowired
	private NoticeService noticeService;
	@Autowired
	private CommentsService commentsService;
	
	@RequestMapping("/notice")
	public String notice(HttpServletRequest request) throws Exception {
		
		List<NoticeVO> noticeList = noticeService.getNoticeList();
		
		request.setAttribute("noticeVOList", noticeList);
		return "/notice/NoticeList";
	}
	
	
	@RequestMapping("/notice/detail")
	public String noticeDetail(HttpServletRequest request, 
			@RequestParam(value="no") String noticeNO) throws Exception {
		
		NoticeVO noticeVO = new NoticeVO();
		List<HashMap<String, Object>> commentsVO;
		noticeVO = noticeService.getNoticedetail(noticeNO);
		commentsVO = commentsService.getCommentsList(noticeNO);
		request.setAttribute("noticeVO", noticeVO);
		request.setAttribute("commentsVO", commentsVO);
		return "/notice/NoticeDetail";
	}
}