package com.metanet.educationSystem.service.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metanet.educationSystem.mapper.TempMapper;
import com.metanet.educationSystem.mapper.login.LoginMapper;
import com.metanet.educationSystem.model.DeptVO;
import com.metanet.educationSystem.model.MemberVO;



@Service
public class LoginServiceImpl implements LoginService{
	
	 @Autowired
	 private LoginMapper loginMapper;

	@Override
	public MemberVO getPassword(MemberVO user) {
		System.out.println("LoginServiceImpl"+user.toString());
		return loginMapper.getPassword(user);
	}
}
