package com.metanet.educationSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MainController {
    
	
	@RequestMapping(value = {"/","/Main"})
	public String temp(Model model) {
		return "Main";
	}
	
	
}
