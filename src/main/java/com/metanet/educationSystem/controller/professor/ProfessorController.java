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
public class ProfessorController {

	@Autowired
	private ProfessorService professorService;

	@RequestMapping("/professor/professorShowMyclass")
	public String professorShowMyclass(Model model, HttpServletRequest request) throws Exception {
		String professorNO = request.getParameter("professorID");
		// 로그인한 학생 정보, 수강신청하기위한 강의 리스트 보내는 것
		// model.addAttribute("memberVO", studentService.getMemberVO());
		// System.out.println(professorNO);
		// System.out.println(professorService.professorGetClassList(professorNO));
		model.addAttribute("classVOList", professorService.professorGetClassList(professorNO));
		return "professor/ProfessorShowMyclassPage";
	}

	@RequestMapping("/professor/professorShowStudent")
	public String professorShowStudent(Model model, HttpServletRequest request) throws Exception {
		// 수업번호 받아옴
		String classNO = request.getParameter("classID");
		System.out.println(classNO);
		System.out.println(professorService.professorGetStudentList(classNO).size());
		model.addAttribute("studentVOList", professorService.professorGetStudentList(classNO));
		return "professor/ProfessorShowStudentPage";
	}
//	//모달로 학생 성적 input
//	@ResponseBody
//    @RequestMapping(value = "/professor/professorInputScore", method = RequestMethod.POST)
//    public List<ScoreVO> professorInputScore(HttpServletRequest request) throws Exception {
//		String studentNO = request.getParameter("studentinfo");
//        return professorService.inputStudentScore(studentNO);
//    }

	@RequestMapping("/professor/professorInputScore")
	public String professorInputScore(Model model, HttpServletRequest request) throws Exception {
		// 수업번호 받아옴
		String classNO = request.getParameter("classNO");
		String studentNO = request.getParameter("memberNO");
		System.out.println(classNO+"인풋클래스번호");
		System.out.println(studentNO+"인풋학생번호");
		//model.addAttribute("studentScoreList", professorService.inputStudentScore(classNO, studentNO));

		return "professor/ProfessorInputScorePage";
	}
	@RequestMapping("/professor/professorInputScoreCheck")
	public String professorInputScore(Model model, HttpServletRequest request, ScoreVO scoreVO) throws Exception {
		// 수업번호 받아옴
//		String classNO = request.getParameter("classNO");
//		String studentNO = request.getParameter("memberNO");
//		System.out.println(classNO+"인풋클래스번호");
//		System.out.println(studentNO+"인풋학생번호");
		System.out.println(scoreVO+"스쿠어브이오내용!!!!!!!");
		//model.addAttribute("studentScoreList", professorService.inputStudentScore(scoreVO));
		professorService.inputStudentScore(scoreVO);

		return "professor/ProfessorShowStudentPage";
	}

}