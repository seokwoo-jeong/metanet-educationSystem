package com.metanet.educationSystem.service.login;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

// UserDetailService : Security��� �޼ҵ�
public interface LoginService extends UserDetailsService{

	UserDetails loadUserByUsername(String memberNO);

//	PasswordEncoder passwordEncoder();
	
}
