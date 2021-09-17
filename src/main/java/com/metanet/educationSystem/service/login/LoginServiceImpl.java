package com.metanet.educationSystem.service.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.metanet.educationSystem.mapper.LoginMapper;
import com.metanet.educationSystem.model.MemberVO;


@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginMapper loginMapper;

	@Override
	// Security �ʼ� �޼���
	public UserDetails loadUserByUsername(String memberNO) throws UsernameNotFoundException {
		System.out.println("loadByname");
		System.out.println(memberNO);
		MemberVO member = loginMapper.readMember(memberNO);
		System.out.println(member.toString());
		member.setMemberPassword("{noop}"+member.getMemberPassword());
		System.out.println(member.toString());
		return member;
	}

}
