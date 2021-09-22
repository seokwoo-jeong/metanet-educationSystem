package com.metanet.educationSystem.controller.login;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {
    
	
	@RequestMapping("/checkLogin")
	public String checkLogin(Model model) {
		System.out.println("{memberNO : 100000001}");
		System.out.println("/checkLogin -> LoginController -> return HTML");
		return "/login/LoginPage";
	}

	@RequestMapping("/loginSuccess")
	public String loginSuccess(HttpServletRequest request) {
		System.out.println("/loginSuccess -> LoginController -> return HTML");
		return "/login/LoginSuccess";
	}

	@RequestMapping("/loginFail")
	public String loginFail(HttpServletRequest request) {
		System.out.println("/loginFail -> LoginController -> return HTML");
		return "/login/LoginFail";
	}
}
