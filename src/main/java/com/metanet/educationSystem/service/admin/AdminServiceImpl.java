package com.metanet.educationSystem.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metanet.educationSystem.mapper.AdminMapper;
import com.metanet.educationSystem.model.MemberVO;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminMapper adminMapper;

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

}
