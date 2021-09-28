package com.metanet.educationSystem.controller.professor;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.metanet.educationSystem.model.ScoreVO;
import com.metanet.educationSystem.service.professor.ProfessorService;

//jsp->controller->sevice->serviceimpl->mapper->mapperxml->db
@Controller
@RequestMapping("/professor")
public class ProfessorController {

	@Autowired
	private ProfessorService professorService;

	@RequestMapping("/professorShowMyclass")
	public String professorShowMyclass(Model model, HttpServletRequest request) throws Exception {
		String professorNO = request.getParameter("professorID");
		model.addAttribute("classVOList", professorService.professorGetClassList(professorNO));
		return "professor/ProfessorShowMyclassPage";
	}

	@RequestMapping("/professorShowStudent")
	public String professorShowStudent(Model model, HttpServletRequest request) throws Exception {
		// 수업번호 받아옴
		String classNO = request.getParameter("classID");
		System.out.println(classNO);
		System.out.println(professorService.professorGetStudentList(classNO).size());
		model.addAttribute("studentVOList", professorService.professorGetStudentList(classNO));
		return "professor/ProfessorShowStudentPage";
	}


	@RequestMapping("/professorInputScore")
	public String professorInputScore(Model model, HttpServletRequest request) throws Exception {
		// 수업번호 받아옴
		String classNO = request.getParameter("classNO");
		String studentNO = request.getParameter("memberNO");
		
		model.addAttribute("getstudentScore", professorService.getstudentScore(classNO,studentNO));

		return "professor/ProfessorInputScorePage";
	}
	
	@RequestMapping("/professorshowStudent")
	public String professorInputScore(Model model, HttpServletRequest request, ScoreVO scoreVO) throws Exception {

		professorService.inputStudentScore(scoreVO);
		model.addAttribute("studentVOList", professorService.professorGetStudentList(scoreVO.getClassNO()));

		return "professor/ProfessorShowStudentPage";
	}

}