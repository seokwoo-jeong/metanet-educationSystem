package com.metanet.educationSystem.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.metanet.educationSystem.model.MemberVO;
import com.metanet.educationSystem.model.NoticeVO;
import com.metanet.educationSystem.service.admin.AdminService;
import com.metanet.educationSystem.service.notice.NoticeService;
import com.metanet.educationSystem.service.student.StudentService;
import com.metanet.educationSystem.service.professor.ProfessorService;

@Controller
public class MainController {
	@Autowired
	private NoticeService noticeService;

	@Autowired
	private StudentService studentService;

	@Autowired
	private ProfessorService professorService;

	@Autowired
	private AdminService adminService;

	@RequestMapping(value = { "/", "/Main" })
	public String temp(Model model, HttpSession session) throws Exception {
		List<NoticeVO> noticeList = noticeService.getNoticeList();
		MemberVO memberVO = (MemberVO) session.getAttribute("member");
		model.addAttribute("noticeVOList", noticeList);
		if (memberVO != null) {
			switch (memberVO.getMemberDistinct()) {
			case "0":
				model.addAttribute("studentClassVOList",
						this.studentService.getStudentClassList(memberVO.getMemberNO()));
				model.addAttribute("studentClassCnt",
						this.studentService.getStudentClassList(memberVO.getMemberNO()).size());
				model.addAttribute("studentInfo", this.studentService.getStudentInfo(memberVO.getMemberNO()));
				break;
			case "1":
				model.addAttribute("classVOList", professorService.professorGetClassList(memberVO.getMemberNO()));
				model.addAttribute("professorClassCnt", this.professorService.professorGetClassList(memberVO.getMemberNO()).size());
				model.addAttribute("professorInfo", this.professorService.getProfessorInfo(memberVO.getMemberNO()));
				System.out.println(professorService.getProfessorInfo(memberVO.getMemberNO()));
				break;
			case "2":
				model.addAttribute("adminInfo", this.adminService.getAdminInfo(memberVO.getMemberNO()));
				System.out.println(adminService.getAdminInfo(memberVO.getMemberNO()));
				break;
			}
		}
		return "Main";
	}

}
