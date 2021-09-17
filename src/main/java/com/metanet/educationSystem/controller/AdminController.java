package com.metanet.educationSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.metanet.educationSystem.service.admin.AdminService;

@Controller
public class AdminController {
	@Autowired
	private AdminService adminService;

}
