package com.metanet.educationSystem.service.login;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

// UserDetailService : Security상속 메소드
public interface LoginService extends UserDetailsService{

	UserDetails loadUserByUsername(String memberNO);
	
}
