package com.metanet.educationSystem.controller.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

@Component
public class ForbiddenErrorHandler implements AccessDeniedHandler {

	@Override
	public void handle(HttpServletRequest req, HttpServletResponse res, AccessDeniedException ade)
			throws IOException, ServletException {
		System.out.println("AccessDeniedHandler");
		res.setStatus(HttpStatus.FORBIDDEN.value());

		req.setAttribute("error", "403");
		req.getRequestDispatcher("/Main").forward(req, res);
	}

}
