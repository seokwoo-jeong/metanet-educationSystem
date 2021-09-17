package com.metanet.educationSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.metanet.educationSystem.service.student.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/studentApplyClass")
	public String studentApplyClass(Model model) throws Exception {
		model.addAttribute("memberVO", studentService.getMemberVO());
		model.addAttribute("classVOList",studentService.getClassList());
		return "student/StudentApplyClassPage";
	}
}
