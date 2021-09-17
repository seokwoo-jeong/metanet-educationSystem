package com.metanet.educationSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.metanet.educationSystem.service.TempService;

@Controller
public class TempController {
    @Autowired
    private TempService tempService;
	
	@RequestMapping(value = {"/","/Main"})
	public String temp(Model model) {
		//model.addAttribute("dept",tempService.getAll());
		return "Main";
	}

}
