package com.metanet.educationSystem.controller.student;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {

	@RequestMapping(value = {"/student"})
	public String temp(Model model) {
		return "/student/Test";
	}
}
