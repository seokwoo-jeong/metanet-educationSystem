package com.metanet.educationSystem.controller.admin;

import java.util.List;

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
import com.metanet.educationSystem.model.ProfessorVO;
import com.metanet.educationSystem.model.StudentVO;
import com.metanet.educationSystem.constant.Constant;
import com.metanet.educationSystem.constant.adminConstant;
import com.metanet.educationSystem.model.ClassVO;
import com.metanet.educationSystem.service.admin.AdminService;
import com.metanet.educationSystem.service.notice.NoticeService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;
	@Autowired
	private NoticeService noticeService;

//학생//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	// 학생 등록 페이지
	@RequestMapping("/studentInsert")
	public String studentInsert(Model model, HttpServletRequest request, HttpSession session, RedirectAttributes rttr)
			throws Exception {

		return "admin/StudentInsert";
	}

	// 학생 등록 페이지
	// 1. URL맵핑, 파라미터 맵핑
	@RequestMapping("/studentInsertCheck")
	public String studentInsertCheck(HttpServletRequest request, HttpSession session, MemberVO memberVO,
			RedirectAttributes rttr) throws Exception {
		// 2. 비즈니스 로직(Insert)
		String studentMajor = request.getParameter("studentMajor");
		String message = null;

		memberVO.setMemberDistinct(request.getParameter("memberDistinct"));
		StudentVO studentVO = new StudentVO();
		studentVO.setStudentNO(memberVO.getMemberNO());
		studentVO.setStudentMajor(studentMajor);

		adminService.memberInsert(memberVO);
		adminService.studentInsert(studentVO);

		message = adminConstant.studentInsertPossibleMessage;

		rttr.addFlashAttribute("message", message);
		return "redirect:studentInsert";
	}

	// 학생 회원가입 진행 Check
	@ResponseBody
	@PostMapping(value = "/checkMemberNO")
	public int checkMemberNO(HttpServletRequest request) throws Exception {
		String memberNO = request.getParameter("memberNO");
		int idExist = this.adminService.checkMemberNO(memberNO);

		return idExist;
	}

//교수//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	// 교수 등록 페이지
	@RequestMapping("/professorInsert")
	public String professorInsert(Model model) throws Exception {
		return "admin/ProfessorInsert";
	}

	// 교수 등록 페이지
	// 1. URL맵핑, 파라미터 맵핑
	@RequestMapping("/professorInsertCheck")
	public String professorInsert(HttpServletRequest request, MemberVO memberVO, RedirectAttributes rttr) throws Exception {
		String professorMajor = request.getParameter("professorMajor");
		String professorRank = request.getParameter("professorRank");
		memberVO.setMemberDistinct(request.getParameter("memberDistinct"));
		String message = null;
		
		ProfessorVO professorVO = new ProfessorVO();
		professorVO.setProfessorNO(memberVO.getMemberNO());
		professorVO.setProfessorMajor(professorMajor);
		professorVO.setProfessorRank(professorRank);

		this.adminService.memberInsert(memberVO);
		this.adminService.professorInsert(professorVO);
		
		message = adminConstant.professorInsertPossibleMessage;
		
		rttr.addFlashAttribute("message", message);
		return "redirect:professorInsert";
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
		model.addAttribute("professorNOList", this.adminService.getProfessorNOList());
		model.addAttribute("classNO", this.adminService.getClassNO());
		return "admin/ClassInsert";
	}

//수업//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	// 수업 등록 페이지
	// 1. URL맵핑, 파라미터 맵핑
	@RequestMapping("/classInsertCheck")
	public String ClassInsertCheck(HttpServletRequest request, HttpSession session, ClassVO classVO, RedirectAttributes rttr) throws Exception {
		// 2. 비즈니스 로직(Insert)
		adminService.classInsert(classVO);
		String message = null;
		
		message = adminConstant.classInsertPossibleMessage;
		
		rttr.addFlashAttribute("message", message);
		return "redirect:classInsert";
	}	

	// 수업 재확인 Check
	@ResponseBody
	@PostMapping(value = "/checkClassNO")
	public int checkClassNO(HttpServletRequest request, RedirectAttributes rttr) throws Exception {
		String memberNO = request.getParameter("memberNO");
		int idExist = this.adminService.checkClassNO(memberNO);
		
		return idExist;
	}
	
	//수업 목록 페이지
	@RequestMapping("/classPage")
	public String ClassPage(Model model, HttpServletRequest request, HttpSession session, RedirectAttributes rttr)
			throws Exception {
		// 수강신청하기위한 강의 리스트 보내는 것
		model.addAttribute("classVOList", adminService.getClassList());

		return "admin/ClassPage";
	}

	//수업 삭제
	@RequestMapping("/adminDeleteClass")
	public String adminDeleteClass(Model model, HttpServletRequest request, HttpSession session,
			RedirectAttributes rttr) throws Exception {
		String classNO = request.getParameter("classNO");
		this.adminService.adminDeleteClass(classNO);
		return "redirect:classPage";
	}
	

//수업//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@RequestMapping("/noticeInsert")
	public String NoticeInsert(Model model, HttpServletRequest request, HttpSession session, RedirectAttributes rttr)
			throws Exception {

		return "admin/NoticeInsert";
	}
	
	// 공지사항 등록 페이지
	// 1. URL맵핑, 파라미터 맵핑
	@RequestMapping("/noticeInsertCheck")
	public String NoticeInsertCheck(HttpServletRequest request, MultipartHttpServletRequest multipartHttpServletRequest,
			NoticeVO noticeVO, RedirectAttributes rttr) throws Exception {
		// 2. 비즈니스 로직(Insert)
		System.out.println(noticeVO);
		String message = null;
		adminService.noticeInsert(noticeVO, request, multipartHttpServletRequest);

		message = adminConstant.noticeInsertPossibleMessage;
		System.out.println(message);
		request.setAttribute("message", message);
		List<NoticeVO> noticeList = noticeService.getNoticeList();
		request.setAttribute("noticeVOList", noticeList);
		return "notice/NoticeList";
	}


}