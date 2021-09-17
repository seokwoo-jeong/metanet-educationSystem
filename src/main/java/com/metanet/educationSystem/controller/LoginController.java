package com.metanet.educationSystem.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class LoginController {
    
	
	@RequestMapping("/checkLogin")
	public String checkLogin(Model model) {
		System.out.println("�α��� ȭ��");
		return "LoginPage";
	}

	@RequestMapping("/loginSuccess")
	public String loginSuccess(HttpServletRequest request) {
		System.out.println("/loginSuccess -> LoginController -> return HTML");
		return "LoginSuccess";
	}

	@RequestMapping("/loginFail")
	public String loginFail(HttpServletRequest request) {
		System.out.println("/loginFail -> LoginController -> return HTML");
		return "LoginFail";
	}
}
