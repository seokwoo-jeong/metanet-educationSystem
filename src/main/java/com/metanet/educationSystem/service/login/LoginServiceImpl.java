package com.metanet.educationSystem.service.login;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.metanet.educationSystem.mapper.LoginMapper;
import com.metanet.educationSystem.model.MemberVO;


@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginMapper loginMapper;
//	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@Override
	// Security ï¿½Ê¼ï¿½ ï¿½Þ¼ï¿½ï¿½ï¿½
	public UserDetails loadUserByUsername(String memberNO) throws UsernameNotFoundException {
		MemberVO member = loginMapper.readMember(memberNO);
		if (member == null){
			System.out.println("À¯Àú ¾øÀ½, memberNO = "+memberNO);
			throw new UsernameNotFoundException(memberNO);
		}
		else {
			member.setMemberPassword("{noop}" + member.getMemberPassword());
			member.setAuthorities(Arrays.asList(new SimpleGrantedAuthority(member.getMemberDistinct())));
		}
		return member;
	}

//	@Override
//	public PasswordEncoder passwordEncoder() {
//		return this.passwordEncoder;
//	}

}
