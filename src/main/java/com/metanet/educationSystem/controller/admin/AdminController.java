package com.metanet.educationSystem.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.metanet.educationSystem.constant.Constant;
import com.metanet.educationSystem.model.MemberVO;
import com.metanet.educationSystem.service.admin.AdminService;

@Controller
public class AdminController {
	@Autowired
	private AdminService adminService;

	@RequestMapping(value = { "/admin" })
	public String temp(Model model) {
		return "/admin/Test";
	}

	// 학생 등록 페이지
	@RequestMapping("/studentIns")
	public String studentApplyClass(Model model, HttpServletRequest request, HttpSession session,
			RedirectAttributes rttr) throws Exception {

		return "admin/StudentIns";
	}

	// 학생 등록 페이지
	// 1. URL맵핑, 파라미터 맵핑
	@RequestMapping("/studentInsert")
	public String studentApplyClass(HttpServletRequest request, HttpSession session, MemberVO memberVO) throws Exception {
		System.out.println(memberVO);
		//2. 비즈니스 로직(Insert)
		adminService.memberInsert(memberVO);
		
		
		return "admin/StudentIns";
	}

}
