package com.metanet.educationSystem.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.metanet.educationSystem.model.MemberVO;
import com.metanet.educationSystem.model.NoticeVO;
import com.metanet.educationSystem.constant.Constant;
import com.metanet.educationSystem.model.ClassVO;
import com.metanet.educationSystem.service.admin.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;

	// 학생 등록 페이지
	@RequestMapping("/studentInsert")
	public String studentInsert(Model model, HttpServletRequest request, HttpSession session, RedirectAttributes rttr)
			throws Exception {

		return "admin/StudentInsert";
	}

	// 학생 등록 페이지
	// 1. URL맵핑, 파라미터 맵핑
	@RequestMapping("/studentInsertCheck")
	public String studentInsertCheck(HttpServletRequest request, HttpSession session, MemberVO memberVO)
			throws Exception {
		// 2. 비즈니스 로직(Insert)
		System.out.println(memberVO);
		adminService.memberInsert(memberVO);

		return "admin/StudentInsert";
	}

	// 학생번호 중복 체크
	@RequestMapping("/memberNOCheck")
	public String memberNOCheck(HttpServletRequest request, HttpSession session, MemberVO memberVO) throws Exception {
		System.out.println(memberVO);

		adminService.memberInsert(memberVO);

		return "admin/StudentInsert";
	}

	// 학생 회원가입 진행 Check
	@ResponseBody
	@PostMapping(value = "/checkMemberNO")
	public int checkMemberNO(HttpServletRequest request) throws Exception {
		String memberNO = request.getParameter("memberNO");
		int idExist = this.adminService.checkMemberNO(memberNO);

		return idExist;
	}

	// 교수 등록 페이지
	@RequestMapping("/professorInsert")
	public String professorInsert(Model model, HttpServletRequest request, HttpSession session, RedirectAttributes rttr)
			throws Exception {

		return "admin/ProfessorInsert";
	}

	// 교수 등록 페이지
	// 1. URL맵핑, 파라미터 맵핑
	@RequestMapping("/professorInsertCheck")
	public String professorInsert(HttpServletRequest request, HttpSession session, MemberVO memberVO) throws Exception {
		// 2. 비즈니스 로직(Insert)
		System.out.println(memberVO);
		adminService.memberInsert(memberVO);

		return "admin/ProfessorInsert";
	}

	// 교수번호 중복 체크
	@RequestMapping("/memberNOCheck2")
	public String memberNOCheck2(HttpServletRequest request, HttpSession session, MemberVO memberVO) throws Exception {
		System.out.println(memberVO);

		adminService.memberInsert(memberVO);

		return "admin/ProfessorInsert";
	}

	// 교수 회원가입 진행 Check
	@ResponseBody
	@PostMapping(value = "/checkMemberNO2")
	public int checkMemberNO2(HttpServletRequest request) throws Exception {
		String memberNO = request.getParameter("memberNO");
		int idExist = this.adminService.checkMemberNO(memberNO);
		return idExist;
	}

	@RequestMapping("/classInsert")
	public String ClassInsert(Model model, HttpServletRequest request, HttpSession session, RedirectAttributes rttr)
			throws Exception {

		return "admin/ClassInsert";
	}

	// 공지사항 등록 페이지
	// 1. URL맵핑, 파라미터 맵핑
	@RequestMapping("/classInsertCheck")
	public String ClassInsertCheck(HttpServletRequest request, HttpSession session, ClassVO classVO) throws Exception {
		// 2. 비즈니스 로직(Insert)
		System.out.println(classVO);
		adminService.classInsert(classVO);

		return "admin/ClassInsert";
	}

	// 학생 회원가입 진행 Check
	@ResponseBody
	@PostMapping(value = "/checkClassNO")
	public int checkClassNO(HttpServletRequest request) throws Exception {
		String memberNO = request.getParameter("memberNO");
		int idExist = this.adminService.checkClassNO(memberNO);

		return idExist;
	}

	@RequestMapping("/noticeInsert")
	public String NoticeInsert(Model model, HttpServletRequest request, HttpSession session, RedirectAttributes rttr)
			throws Exception {

		return "admin/NoticeInsert";
	}

	// 공지사항 등록 페이지
	// 1. URL맵핑, 파라미터 맵핑
	@RequestMapping("/noticeInsertCheck")
	public String NoticeInsertCheck(HttpServletRequest request, MultipartHttpServletRequest multipartHttpServletRequest,
			NoticeVO noticeVO) throws Exception {
		// 2. 비즈니스 로직(Insert)
		System.out.println(noticeVO);

		adminService.noticeInsert(noticeVO, request, multipartHttpServletRequest);

		return "admin/NoticeInsert";
	}

	@RequestMapping("/classPage")
	public String ClassPage(Model model, HttpServletRequest request, HttpSession session, RedirectAttributes rttr)
			throws Exception {
		// 수강신청하기위한 강의 리스트 보내는 것
		model.addAttribute("classVOList", adminService.getClassList());

		return "admin/ClassPage";
	}

	@RequestMapping("/adminDeleteClass")
	public String adminDeleteClass(Model model, HttpServletRequest request, HttpSession session,
			RedirectAttributes rttr) throws Exception {
		String classNO = request.getParameter("classNO");
		this.adminService.adminDeleteClass(classNO);
		return "redirect:classPage";
	}
}