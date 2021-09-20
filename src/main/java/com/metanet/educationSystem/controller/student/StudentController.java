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
	
	@RequestMapping("/student/studentApplyClass")
	public String studentApplyClass(Model model) throws Exception {
		
		// 1. 파라미터가 (있으면) 받기
		// 2. 로직 실행 (로직 실행 결과를 Model 에 담기 위해서)
		// 3. Model에 로직 실행한 결과를 담아서
		// 4. 뷰로 모델을 보내주는거에요.
		System.out.println("가지나가지나");
		model.addAttribute("memberVO", studentService.getMemberVO());
		model.addAttribute("classVOList",studentService.getClassList());
		
		return "student/StudentApplyClassPage";
	}
	
	@RequestMapping(value = {"/student"})
	public String temp(Model model) {
		return "/student/Test";
	}
}
