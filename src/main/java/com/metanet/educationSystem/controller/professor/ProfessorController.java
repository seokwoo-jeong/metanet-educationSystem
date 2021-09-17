package com.metanet.educationSystem.controller.professor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.metanet.educationSystem.service.professor.ProfessorService;

@Controller
public class ProfessorController {

	@Autowired
	private ProfessorService professorService;

	
	@RequestMapping(value = {"/professor"})
	public String temp(Model model) {
		return "/professor/Test";
	}
}