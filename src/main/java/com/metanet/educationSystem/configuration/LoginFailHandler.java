package com.metanet.educationSystem.configuration;

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
	}

}
