package com.metanet.educationSystem.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.metanet.educationSystem.service.student.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	// 수강신청 페이지 보여주는 함수
	@RequestMapping("/studentApplyClass")
	public String studentApplyClass(Model model) throws Exception {
		
		//로그인한 학생 정보, 수강신청하기위한 강의 리스트 보내는 것
		model.addAttribute("memberVO", studentService.getMemberVO());
		model.addAttribute("classVOList",studentService.getClassList());
		return "student/StudentApplyClassPage";
	}
	//학생이 수강신청 버튼 누르면, 유효성(정원만족하는지, 학점만족하는지) 확인하는 function
	@RequestMapping("/studentApplyClassCheck")
	public String studentApplyClassCheck(Model model,  HttpServletRequest request) throws Exception {
		String classNO  =request.getParameter("classNO");
		System.out.println(classNO);
		//model.addAttribute("memberVO", studentService.getMemberVO());
		//model.addAttribute("classVOList",studentService.getClassList());
		return "student/StudentApplyClassPage";
	}
}
