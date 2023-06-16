package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dao.PipelineDao;

@Controller
public class pipeline {
	@Autowired
	private PipelineDao pipeline;

	@GetMapping("/")
	public String getpipe(Model model) {
		int noofenquires = pipeline.getEnquiryCount();
		model.addAttribute("enquirycount", noofenquires);
		return "funnel";
	}
}
