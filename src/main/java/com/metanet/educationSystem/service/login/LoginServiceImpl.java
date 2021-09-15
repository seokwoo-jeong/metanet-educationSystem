package com.metanet.educationSystem.service.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metanet.educationSystem.mapper.login.LoginMapper;



@Service
public class LoginServiceImpl implements LoginService{
	
	 @Autowired
	 private LoginMapper loginMapper;

}
