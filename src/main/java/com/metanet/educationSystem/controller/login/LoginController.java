package com.metanet.educationSystem.controller.login;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class LoginController {
    
	@RequestMapping("/checkLoginModal")
	public String checkLoginModal(HttpServletRequest request) {
		return "/login/LoginModal";
	}
	
	@RequestMapping("/checkLogin")
	public String checkLogin(HttpServletRequest request) {
		System.out.println("/checkLogin -> LoginController -> return HTML");
		String referer = (String)request.getHeader("REFERER");

		System.out.println("errorcode = "+request.getAttribute("errormsg"));
		System.out.println("refer = "+referer);
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
	
	@RequestMapping("/doLoginImpl")
	public String doLoginImpl(HttpServletRequest request, RedirectAttributes redirect) {
		System.out.println("/doLoginImpl-> LoginController -> return URL");
		String memberNO = request.getParameter("memberNO");
		String memberPassword = request.getParameter("memberPassword");
		redirect.addFlashAttribute("memberNO", memberNO);
		redirect.addFlashAttribute("memberPassword", memberPassword);
		return "redirect:/doLogin";
	}
	
}
