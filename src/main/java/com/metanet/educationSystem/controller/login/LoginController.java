package com.metanet.educationSystem.controller.login;

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

@Controller
public class LoginController {
    
	@Autowired
    private LoginServiceImpl loginService;
	
	@RequestMapping("/checkLogin")
	public String checkLogin(Model model) {
		
		return "LoginPage";
	}
	
	@PostMapping("/login")
	public String login(HttpServletRequest request,
			@ModelAttribute MemberVO user) {
		System.out.println(user.toString());
		user = loginService.getPassword(user);
		System.out.println(user);
		return "LoginPage";
	}


}
