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
<<<<<<< HEAD:src/main/java/com/metanet/educationSystem/controller/LoginController.java
		
		return "login/LoginPage";
	}
	
=======
		System.out.println("로그인 화면");
		return "LoginPage";
	}
	
	@RequestMapping("/doLogin")
	public String doLogin(HttpServletRequest request) {
		System.out.println("로그인 Dologin");
		return "LoginSuccess";
	}

	@RequestMapping("/loginSuccess")
	public String loginSuccess(HttpServletRequest request) {
		System.out.println("로그인 성공");
		return "LoginSuccess";
	}

	@RequestMapping("/loginFail")
	public String loginFail(HttpServletRequest request) {
		System.out.println("로그인 실패");
		return "LoginFail";
	}
>>>>>>> fb472a3bec218c8780ec34ae326bfcaf0f15b740:src/main/java/com/metanet/educationSystem/controller/login/LoginController.java

}
