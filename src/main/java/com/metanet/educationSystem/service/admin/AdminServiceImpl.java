package com.metanet.educationSystem.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metanet.educationSystem.mapper.AdminMapper;
import com.metanet.educationSystem.model.ClassVO;
import com.metanet.educationSystem.model.MemberVO;
import com.metanet.educationSystem.model.NoticeVO;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminMapper adminMapper;

//memberInsert - student, professor	
	
	@Override
	public void memberInsert(MemberVO memberVO) throws Exception{
		System.out.println(memberVO.toString()+"서비스입니다.");
		adminMapper.memberInsert(memberVO);
	}

	@Override
	public int checkMemberNO(String memberNO) throws Exception {
		  String checkMemberNO = this.adminMapper.checkMemberNO(memberNO);
		  int isExist = 0;
	        if (checkMemberNO != null) {isExist = 1;}
		return isExist;
	}


//classInsert
	@Override
	public void classInsert(ClassVO classVO) throws Exception {
		System.out.println(classVO.toString()+"수업 입력입니다.");
		adminMapper.classInsert(classVO);
		
	}

	@Override
	public int checkClassNO(String classVO) throws Exception {
		return 0;
	}

	
//noticeInsert
	
	public void noticeInsert(NoticeVO noticeVO) throws Exception{
		System.out.println(noticeVO.toString()+"공지사항 입력입니다.");
		adminMapper.noticeInsert(noticeVO);
	}
	
	@Override 
	public int checkNoticeNO(String noticeVO) throws Exception { 
		return 0; 
	}

}
