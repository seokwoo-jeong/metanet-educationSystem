package com.metanet.educationSystem.controller.login;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class CommenceEntryPoint implements AuthenticationEntryPoint, Serializable {
    private static final long serialVersionUID = 565662170056829238L;
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		System.out.println("401에러 핸들링"+authException);
		request.setAttribute("error", "401");
		request.getRequestDispatcher("/Main").forward(request, response);
	}

}
