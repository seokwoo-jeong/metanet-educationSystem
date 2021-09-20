package com.metanet.educationSystem.controller.professor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.metanet.educationSystem.service.professor.ProfessorService;

//jsp->controller->sevice->serviceimpl->mapper->mapperxml->db
@Controller
public class ProfessorController {

	@Autowired
	private ProfessorService professorService;

	
	@RequestMapping("/professor/professorShowMyclass")
	public String professorShowMyclass(Model model) throws Exception {

		// 로그인한 학생 정보, 수강신청하기위한 강의 리스트 보내는 것
		//model.addAttribute("memberVO", studentService.getMemberVO());
		//model.addAttribute("classVOList", studentService.getClassList());
		return "professor/ProfessorShowMyclassPage";
	}
}