package com.metanet.educationSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.metanet.educationSystem.model.DeptVO;
import com.metanet.educationSystem.service.TempService;

@Controller
public class TempController {
    @Autowired
    private TempService tempService;
	
	@RequestMapping("/")
	public String temp(Model model) {
		DeptVO a = tempService.getAll();
		
		model.addAttribute("dept",tempService.getAll());
		
		
//		var t = "Hello World";
//		System.out.println(String.format("%14s", t));
//		System.out.println("".formatted("%-14s",t));
		
		
		
		
		return "Main";
	}


}
