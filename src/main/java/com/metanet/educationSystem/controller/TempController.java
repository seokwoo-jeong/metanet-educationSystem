package com.metanet.educationSystem.controller;

import java.io.File;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.metanet.educationSystem.model.NoticeFileVO;
import com.metanet.educationSystem.model.NoticeVO;
import com.metanet.educationSystem.service.TempService;


@Controller
@RequestMapping("/student")
public class TempController {
	
	@Autowired
	private TempService tempService;

	// 수강신청 페이지 보여주는 함수
	@RequestMapping("/fileTemp")
	public String fileTemp(Model model) throws Exception {
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setNoticeNO("8");
		
		
		model.addAttribute("fileList",this.tempService.getFile(noticeVO.getNoticeNO()));

		return "FileTemp";
	}
	
	@RequestMapping("/insertNotice")
	public String insertNotice(HttpServletRequest request,MultipartHttpServletRequest multipartHttpServeltRequest) throws Exception {
		NoticeVO noticeVO = new NoticeVO();
		
		noticeVO.setNoticeNO("8");
		
		tempService.insertNotice(noticeVO,request,multipartHttpServeltRequest);

		return "redirect:fileTemp";
	}
	
	@RequestMapping("/downloadNoticeFile")
	public String downloadNoticeFile(HttpServletResponse response, HttpServletRequest request) throws Exception {
		NoticeFileVO noticeFileVO = new NoticeFileVO();
		noticeFileVO.setFileNO(request.getParameter("fileNO"));
		noticeFileVO.setNoticeNO(request.getParameter("noticeNO"));
		
		noticeFileVO =this.tempService.downloadNoticeFile(noticeFileVO);
		
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
		return "redirect:fileTemp";
	}

}
