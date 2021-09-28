package com.metanet.educationSystem.service.login;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public interface LoginService extends UserDetailsService{

	public UserDetails loadUserByUsername(String memberNO) throws UsernameNotFoundException;

	
}
