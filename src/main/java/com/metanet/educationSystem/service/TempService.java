package com.metanet.educationSystem.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.metanet.educationSystem.model.NoticeFileVO;
import com.metanet.educationSystem.model.NoticeVO;

public interface TempService {

	public void insertNotice(NoticeVO noticeVO,HttpServletRequest request, MultipartHttpServletRequest multipartHttpServeltRequest)
			throws Exception;

	public List<NoticeFileVO> getFile(String noticeNO) throws Exception;

	public NoticeFileVO downloadNoticeFile(NoticeFileVO noticeFileVO) throws Exception;
	
}
