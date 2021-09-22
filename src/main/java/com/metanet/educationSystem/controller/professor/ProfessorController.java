package com.metanet.educationSystem.controller.professor;

import javax.servlet.http.HttpServletRequest;

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
	public String professorShowMyclass(Model model,HttpServletRequest request)  throws Exception {
		String professorNO =request.getParameter("professorID");
		// 로그인한 학생 정보, 수강신청하기위한 강의 리스트 보내는 것
		//model.addAttribute("memberVO", studentService.getMemberVO());
		System.out.println(professorNO);
		System.out.println(professorService.professorGetClassList(professorNO));
		model.addAttribute("classVOList", professorService.professorGetClassList(professorNO));
		return "professor/ProfessorShowMyclassPage";
	}
	
	@RequestMapping("/professor/professorShowStudent")
	public String professorShowStudent(Model model,HttpServletRequest request)  throws Exception {
//		String professorNO =request.getParameter("professorID");
//		// 로그인한 학생 정보, 수강신청하기위한 강의 리스트 보내는 것
//		//model.addAttribute("memberVO", studentService.getMemberVO());
//		System.out.println(professorNO);
//		System.out.println(professorService.professorGetClassList(professorNO));
//		model.addAttribute("classVOList", professorService.professorGetClassList(professorNO));
		return "professor/ProfessorShowStudentPage";
	}
}