package com.metanet.educationSystem.controller.notice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.metanet.educationSystem.model.NoticeVO;
import com.metanet.educationSystem.service.notice.NoticeService;


@Controller
public class NoticeController {
    
	@Autowired
	private NoticeService noticeService;
	
	
	@RequestMapping("/notice")
	public String notice(HttpServletRequest request) throws Exception {
		
		List<NoticeVO> noticeList = noticeService.getNoticeList();
		
		request.setAttribute("noticeVOList", noticeList);
		for (NoticeVO noticeVO : noticeList) {
			System.out.println(noticeVO.toString());
		}
		return "/notice/NoticeList";
	}
	
	
	@RequestMapping("/notice/detail")
	public String noticeDetail(HttpServletRequest request, 
			@RequestParam(value="no") String noticeNO) throws Exception {
		
		System.out.println(noticeNO);
		NoticeVO noticeVO = new NoticeVO();
		noticeVO = noticeService.getNoticedetail(noticeNO);
		request.setAttribute("noticeVO", noticeVO);
		return "/notice/NoticeDetail";
	}
}