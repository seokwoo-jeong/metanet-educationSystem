package com.metanet.educationSystem.service.admin;

import com.metanet.educationSystem.model.MemberVO;
import com.metanet.educationSystem.model.NoticeVO;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.metanet.educationSystem.model.ClassVO;

public interface AdminService {

//member Insert - student, professor
	void memberInsert(MemberVO memberVO) throws Exception;
	int checkMemberNO(String memberNO) throws Exception;

//Class Insert
	void classInsert(ClassVO classVO) throws Exception;
	int checkClassNO(String classVO) throws Exception;
	
//Notice Insert
	void noticeInsert(NoticeVO noticeVO, HttpServletRequest request, MultipartHttpServletRequest multipartHttpServeltRequest) throws Exception;
	int checkNoticeNO(String noticeVO) throws Exception;
	 
	
}
