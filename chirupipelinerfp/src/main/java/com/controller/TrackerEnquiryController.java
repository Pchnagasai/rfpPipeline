package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dao.TrackerEnquiryDao;
import com.model.TrackerEnquiry;
import com.model.TrackerRfp;

@Controller
public class TrackerEnquiryController {
	@Autowired
	private TrackerEnquiryDao trackerenquirydao;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getEnquiryid(Model model) {
/*
		List<TrackerEnquiry> enquiry = trackerenquirydao.getEnquiryById();

		for (TrackerEnquiry x : enquiry) {
			System.out.println(x);
		}
		model.addAttribute("enquiry", enquiry);
		
		*/
		List<TrackerRfp> rfp =trackerenquirydao.getstatus();
		for(TrackerRfp x:rfp) {
			System.out.println(x);
		}
		model.addAttribute("enquiry", rfp);
		
		
		return "Enquirystage";

	}

}