package com.metanet.educationSystem.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.metanet.educationSystem.constant.Constant;
import com.metanet.educationSystem.model.MemberVO;
import com.metanet.educationSystem.service.admin.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;

	@RequestMapping(value = { "/admin" })
	public String temp(Model model) {
		return "/admin/Test";
	}

//student/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// 학생 등록 페이지
	@RequestMapping("/studentInsert")
	public String studentApplyClass(Model model, HttpServletRequest request, HttpSession session,
			RedirectAttributes rttr) throws Exception {

		return "admin/StudentInsert";
	}

	// 학생 등록 페이지
	// 1. URL맵핑, 파라미터 맵핑
	@RequestMapping("/studentInsertCheck")
	public String studentApplyClass(HttpServletRequest request, HttpSession session, MemberVO memberVO) throws Exception {
		//2. 비즈니스 로직(Insert)
		System.out.println(memberVO);
		adminService.memberInsert(memberVO);
		
		return "admin/StudentInsert";
	}

	// 학번 중복 체크 
	@RequestMapping("/memberNOCheck")
	public String memberNOCheck(HttpServletRequest request, HttpSession session, MemberVO memberVO) throws Exception {
		System.out.println(memberVO);

		adminService.memberInsert(memberVO);
		
			
			return "admin/StudentInsert";
		}
	
    // 회원가입 진행 Check
    @ResponseBody
    @PostMapping(value = "/checkMemberNO")
    public int checkMemberNO(HttpServletRequest request) throws Exception {
        String memberNO = request.getParameter("memberNO");
        int idExist = this.adminService.checkMemberNO(memberNO);

        return idExist;
    }
	
//professor//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		
	// 교수 등록 페이지
	@RequestMapping("/professorInsert")
	public String ProfssorInsert(Model model, HttpServletRequest request, HttpSession session,
			RedirectAttributes rttr) throws Exception {

		return "admin/ProfessorInsert";
	}
	
	// 교수 등록 페이지
	// 1. URL맵핑, 파라미터 맵핑
	@RequestMapping("/professorIns")
	public String ProfessorInsert(HttpServletRequest request, HttpSession session, MemberVO memberVO) throws Exception {
		System.out.println(memberVO);
		//2. 비즈니스 로직(Insert)
		adminService.memberInsert(memberVO);
		
		
			return "admin/ProfessorInsert";
	}	
	
	//교수 등록 버튼
	@RequestMapping("/professorInsertCheck")
	public String professorInsertCheck(Model model, HttpServletRequest request, HttpSession session,
			RedirectAttributes rttr) throws Exception {

		return "redirect:professorInsert";

	}
}
