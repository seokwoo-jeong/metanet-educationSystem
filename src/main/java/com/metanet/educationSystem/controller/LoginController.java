package com.metanet.educationSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.metanet.educationSystem.service.login.LoginService;

@Controller
public class LoginController {
    
	@Autowired
    private LoginService loginService;
	
	@RequestMapping("/checkLogin")
	public String checkLogin(Model model) {
		
		return "login/LoginPage";
	}
	

}
