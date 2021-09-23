package com.metanet.educationSystem.controller.login;

import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Component
public class CommenceEntryPoint implements AuthenticationEntryPoint, Serializable {
    private static final long serialVersionUID = 565662170056829238L;
    
    RedirectAttributes redirectAttributes = new RedirectAttributes() {
		
		@Override
		public Object getAttribute(String attributeName) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public boolean containsAttribute(String attributeName) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public Map<String, Object> asMap() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Model addAllAttributes(Map<String, ?> attributes) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public RedirectAttributes mergeAttributes(Map<String, ?> attributes) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Map<String, ?> getFlashAttributes() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public RedirectAttributes addFlashAttribute(String attributeName, Object attributeValue) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public RedirectAttributes addFlashAttribute(Object attributeValue) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public RedirectAttributes addAttribute(String attributeName, Object attributeValue) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public RedirectAttributes addAttribute(Object attributeValue) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public RedirectAttributes addAllAttributes(Collection<?> attributeValues) {
			// TODO Auto-generated method stub
			return null;
		}
	};
    
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		System.out.println("401에러 핸들링"+authException);
		request.setAttribute("errors", authException);

        response.sendRedirect("/checkLogin?error=401");
	}

}
