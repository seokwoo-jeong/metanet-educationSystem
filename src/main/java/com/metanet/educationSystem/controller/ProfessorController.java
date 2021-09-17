package com.metanet.educationSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.metanet.educationSystem.service.professor.ProfessorService;



@Controller
public class ProfessorController {
	@Autowired
	private ProfessorService professorService;

}
