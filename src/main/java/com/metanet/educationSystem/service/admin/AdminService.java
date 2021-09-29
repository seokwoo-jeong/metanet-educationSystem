package com.metanet.educationSystem.service.admin;

import com.metanet.educationSystem.model.MemberVO;
import com.metanet.educationSystem.model.NoticeVO;
import com.metanet.educationSystem.model.ProfessorVO;
import com.metanet.educationSystem.model.StudentVO;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.metanet.educationSystem.model.ClassVO;

public interface AdminService {

//member Insert - student, professor
	public void memberInsert(MemberVO memberVO) throws Exception;
	public void studentInsert(StudentVO studentVO) throws Exception;
	public int checkMemberNO(String memberNO) throws Exception;

//Class Insert
	public void classInsert(ClassVO classVO) throws Exception;
	public int checkClassNO(String classVO) throws Exception;
	
//Notice Insert
	public void noticeInsert(NoticeVO noticeVO, HttpServletRequest request, MultipartHttpServletRequest multipartHttpServeltRequest) throws Exception;
	public int checkNoticeNO(String noticeVO) throws Exception;
	 
	
//ClassPage
	public List<HashMap<String, Object>> getClassList() throws Exception;
	public void adminDeleteClass(String classNO) throws Exception;
	public void professorInsert(ProfessorVO professorVO) throws Exception;
	public List<String> getProfessorNOList() throws Exception;
	public String getClassNO() throws Exception;
	
//Main Page
	public HashMap<String, Object> getAdminInfo(String memberNO);
	
}
