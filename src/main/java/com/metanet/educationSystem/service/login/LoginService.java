package com.metanet.educationSystem.service.login;

import org.springframework.beans.factory.annotation.Autowired;

import com.metanet.educationSystem.mapper.login.LoginMapper;
import com.metanet.educationSystem.model.MemberVO;

public interface LoginService {


	MemberVO getPassword(MemberVO user);
	
}
