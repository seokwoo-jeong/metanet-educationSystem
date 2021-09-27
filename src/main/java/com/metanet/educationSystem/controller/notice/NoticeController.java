package com.metanet.educationSystem.controller.notice;

import java.io.File;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.metanet.educationSystem.model.NoticeFileVO;
import com.metanet.educationSystem.model.NoticeVO;
import com.metanet.educationSystem.service.notice.NoticeService;


@Controller
@RequestMapping("/notice")
public class NoticeController {
    
	@Autowired
	private NoticeService noticeService;
	
	
	@RequestMapping("")
	public String notice(HttpServletRequest request) throws Exception {
		
		List<NoticeVO> noticeList = noticeService.getNoticeList();
		
		request.setAttribute("noticeVOList", noticeList);
		for (NoticeVO noticeVO : noticeList) {
			System.out.println(noticeVO.toString());
		}
		return "/notice/NoticeList";
	}
	
	
	@RequestMapping("/detail")
	public String noticeDetail(HttpServletRequest request, 
			@RequestParam(value="no") String noticeNO) throws Exception {
		
		NoticeVO noticeVO = new NoticeVO();
		noticeVO = noticeService.getNoticedetail(noticeNO);
		request.setAttribute("noticeFileList",this.noticeService.getNoticeFile(noticeNO));
		request.setAttribute("noticeVO", noticeVO);
		return "/notice/NoticeDetail";
	}
	
	@RequestMapping("/downloadNoticeFile")
	public String downloadNoticeFile(HttpServletResponse response, HttpServletRequest request) throws Exception {
		NoticeFileVO noticeFileVO = new NoticeFileVO();
		noticeFileVO.setFileNO(request.getParameter("fileNO"));
		noticeFileVO.setNoticeNO(request.getParameter("noticeNO"));
		
		noticeFileVO =this.noticeService.downloadNoticeFile(noticeFileVO);
		
		if(ObjectUtils.isEmpty(noticeFileVO) == false) {
			String fileName = noticeFileVO.getOriginFileName();
			
			byte[] files = FileUtils.readFileToByteArray(new File(noticeFileVO.getStoredFilePath()));
			
			response.setContentType("application/octet-stream");
			response.setContentLength(files.length);
			response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(fileName, "UTF-8")+ "\";");
			
			response.getOutputStream().write(files);
			response.getOutputStream().flush();
			response.getOutputStream().close();
		}
		return "redirect:detail";
	}
}