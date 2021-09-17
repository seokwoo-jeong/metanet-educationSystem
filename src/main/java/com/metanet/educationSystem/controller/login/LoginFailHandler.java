package com.metanet.educationSystem.controller.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginFailHandler implements AuthenticationFailureHandler {
    
	private String loginidname;
    private String loginpwdname;
    private String errormsgname;
    private String defaultFailureUrl;
		
    @Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
    	System.out.println("Login Fail Controller");
    	
    	String memberNO = request.getParameter("memberNO");
    	String memberPassword = request.getParameter("memberPassword");
    	String errormsg = exception.getMessage();
    	System.out.println(memberNO+memberPassword);
    	
    	request.setAttribute(loginidname, memberNO);
        request.setAttribute(loginpwdname, memberPassword);
        request.setAttribute(errormsgname, errormsg);
        
        request.getRequestDispatcher(defaultFailureUrl).forward(request, response);

    	
	}

}
