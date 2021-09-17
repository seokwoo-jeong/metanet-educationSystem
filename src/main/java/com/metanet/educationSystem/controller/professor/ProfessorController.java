package com.metanet.educationSystem.controller.professor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProfessorController {

	@RequestMapping(value = {"/professor"})
	public String temp(Model model) {
		return "/professor/Test";
	}
}