package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dao.PipelineDao;

@Controller
public class pipeline {
	@Autowired
	private PipelineDao pipeline;

	@RequestMapping("/")
	public String getpipe(Model model) {
		System.out.println("hello");
		int noofenquires = pipeline.getEnquiryCount();
		model.addAttribute("enquirycount", noofenquires);
		
		int Noofrfps=pipeline.getRFPCount();
		model.addAttribute("rfpcount", Noofrfps);
		
		int noofactiverfps=pipeline.getActiverfpscount();
		model.addAttribute("activerfpcount", noofactiverfps);
		
		int noofrfpcomplete = pipeline.getcompleterfpcount();
		model.addAttribute("completerfp", noofrfpcomplete);
		
		return "fun";
	}
	
}
