package com.metanet.educationSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MainController {
    
	
	@RequestMapping("/")
	public String temp(Model model) {
		return "Main";
	}
	
	@RequestMapping("/index")
	public String index(Model model) {
		return "index";
	}


}
