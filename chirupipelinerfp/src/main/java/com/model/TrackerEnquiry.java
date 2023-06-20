package com.model;

import org.springframework.stereotype.Component;

@Component
public class TrackerEnquiry {

	private int enqrid;
	private String enqrstatus;

	
	public int getEnqrid() {
		return enqrid;
	}

	public void setEnqrid(int enqrid) {
		this.enqrid = enqrid;
	}

	public String getEnqrstatus() {
		return enqrstatus;
	}

	public void setEnqrstatus(String enqrstatus) {
		this.enqrstatus = enqrstatus;
	}

	

	

}