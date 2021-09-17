package com.metanet.educationSystem.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.metanet.educationSystem.model.MemberVO;
import com.metanet.educationSystem.service.login.LoginService;
import com.metanet.educationSystem.service.login.LoginServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginController {
    
	@Autowired
    private LoginServiceImpl loginService;
	
	@RequestMapping("/checkLogin")
	public String checkLogin(Model model) {
		System.out.println("�α��� ȭ��");
		return "LoginPage";
	}
	
	@RequestMapping("/doLogin")
	public String doLogin(HttpServletRequest request) {
		System.out.println("�α��� Dologin");
		return "LoginSuccess";
	}

	@RequestMapping("/loginSuccess")
	public String loginSuccess(HttpServletRequest request) {
		System.out.println("�α��� ����");
		return "LoginSuccess";
	}

	@RequestMapping("/loginFail")
	public String loginFail(HttpServletRequest request) {
		System.out.println("�α��� ����");
		return "LoginFail";
	}


}
