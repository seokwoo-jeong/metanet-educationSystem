package com.metanet.educationSystem.service.login;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.metanet.educationSystem.mapper.login.LoginMapper;
import com.metanet.educationSystem.model.MemberVO;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginMapper loginMapper;
//	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@Override
	// Security 필수 메서드
	public UserDetails loadUserByUsername(String memberNO) throws UsernameNotFoundException {
		MemberVO member = loginMapper.readMember(memberNO);
		if (member == null){
			System.out.println("해당 멤버 없음, memberNO = "+memberNO);
			throw new UsernameNotFoundException(memberNO);
		}
		else {
			member.setMemberPassword("{noop}" + member.getMemberPassword());
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			authorities.add(new SimpleGrantedAuthority(member.getMemberDistinct()));
			member.setAuthorities(authorities);
		}
		return member;
	}

//	@Override
//	public PasswordEncoder passwordEncoder() {
//		return this.passwordEncoder;
//	}

}
