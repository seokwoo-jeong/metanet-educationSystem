package com.metanet.educationSystem.controller.student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.metanet.educationSystem.constant.Constant;
import com.metanet.educationSystem.model.MemberVO;
import com.metanet.educationSystem.service.student.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	// 수강신청 페이지 보여주는 함수
	@RequestMapping("/studentApplyClass")
	public String studentApplyClass(Model model, HttpServletRequest request, HttpSession session,
			RedirectAttributes rttr) throws Exception {
		// session에서 get memberNO
		MemberVO memberVO = (MemberVO) session.getAttribute("member");
		// 수강신청하기위한 강의 리스트 보내는 것
		model.addAttribute("classVOList", studentService.getClassList());
		// 학생이 수강 신청한 강좌 리스트
		model.addAttribute("studentClassVOList", this.studentService.getStudentClassList(memberVO.getMemberNO()));
		// 현재 학생 수강한 학점
		model.addAttribute("studentCurrentCredit", this.studentService.getCurrentStudentCredit(memberVO.getMemberNO()));
		// 학생 신청가능한 총 학점
		model.addAttribute("studentAllowCredit", Constant.studentAllowCredit);

		return "student/StudentApplyClassPage";
	}

	@RequestMapping("/studentApplyClassCheck")
	public String studentApplyClassCheck(Model model, HttpServletRequest request, HttpSession session,
			RedirectAttributes rttr) throws Exception {
		String classNO = request.getParameter("classNO");

		// session에서 get memberNO
		MemberVO memberVO = (MemberVO) session.getAttribute("member");
		// 학생이 수강신청 버튼 누르면, 유효성(정원만족하는지, 학점만족하는지) 확인하는 function

		String message = null;
		// 확인한다. 이미 신청했는지 안했는지
		// 이미신청했으면 false, 신청안했으면 true
		if (studentService.checkClassApply(classNO, memberVO.getMemberNO()) == false) {
			message = Constant.studentAlreadyApplyThisClassMessage;

			// 확인한다. 수업 정원을
			// 정원꽉찼으면 false, 정원 꽉 안찼으면 true
		} else if (studentService.checkClassPersonnel(classNO) == false) {
			message = Constant.classPersonnelIsFullMessage;

			// 확인한다. 현재 학생 학점을
			// 현재 학점 > 총 학점 false, 현재 학점 <= 총 학점 true
		} else if (studentService.checkClassCredit(classNO, memberVO.getMemberNO()) == false) {
			message = Constant.studentCreditIsPullMessage;

			// is possible Apply Class
		} else {
			this.studentService.studentApplyClass(classNO, memberVO.getMemberNO());
			message = Constant.studentIsPossibleApplyThisClassMessage;
		}

		rttr.addFlashAttribute("message", message);
		return "redirect:studentApplyClass";

	}

	@RequestMapping("/studentDeleteClass")
	public String studentDeleteClass(Model model, HttpServletRequest request, HttpSession session,
			RedirectAttributes rttr) throws Exception {
		String classNO = request.getParameter("classNO");

		// session에서 get memberNO
		MemberVO memberVO = (MemberVO) session.getAttribute("member");
		this.studentService.studentDeleteClass(classNO, memberVO.getMemberNO());
		rttr.addFlashAttribute("message", Constant.studentDeleteClassMessage);

		return "redirect:studentApplyClass";
	}

}
