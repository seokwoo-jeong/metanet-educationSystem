package com.metanet.educationSystem.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

	@RequestMapping(value = {"/admin"})
	public String temp(Model model) {
		return "/admin/Test";
	}
}
