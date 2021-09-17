package com.metanet.educationSystem.controller.student;

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
	
	@RequestMapping(value = {"/student"})
	public String temp(Model model) {
		return "/student/Test";
	}
}
