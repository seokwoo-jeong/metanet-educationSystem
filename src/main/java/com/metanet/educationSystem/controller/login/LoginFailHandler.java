package com.metanet.educationSystem.controller.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginFailHandler implements AuthenticationFailureHandler {

//	private String memberNO;
//	private String memberPassword;
//	private String errormsgname;
//	private String defaultFailureUrl;

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		System.out.println("Login Fail Handler");

		String memberNO = request.getParameter("memberNO");
		String memberPassword = request.getParameter("memberPassword");
		String errormsg = null;
		String defaultFailureUrl = "/checkLogin";

		if (exception instanceof InternalAuthenticationServiceException) {
			errormsg = "0"; // 아이디 잘못 입력
		} else if (exception instanceof BadCredentialsException) {
			errormsg = "1"; // 비밀번호를 잘못 입력했습니다.
		} else if (exception instanceof UsernameNotFoundException) {
			errormsg = "2"; // 계정이 존재하지 않습니다.
		} else if (exception instanceof DisabledException) {
			errormsg = "3"; // 이메일 인증을 해주세요.
		} else if (exception instanceof SessionAuthenticationException) {
			errormsg = "4"; // 중복 로그인
		}
		
		System.out.println("입력 ID : "+memberNO+"\n입력 패스워드 : " + memberPassword + "\nerrormsg = " + exception);
		request.setAttribute("errormsg", errormsg);
        
		request.getRequestDispatcher(defaultFailureUrl).forward(request, response);
	}

}
