package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.model.EnquiryRowMapper;
import com.model.TrackerEnquiry;
import com.model.TrackerRfp;
import com.model.TrackerRfpRowMapper;

public class TrackerEnquiryDaoImp implements TrackerEnquiryDao {

	@Autowired
	private JdbcTemplate jdbctemplate;

//	private final String enquiry = "select enqr_id from tracker_enquiries";
	
	private final String rejuct ="select e.enqr_id,e.enqr_status,r.rfpr_status from tracker_enquiries e join tracker_rfp r  ON e.enqr_id = r.rfpr_id ";
/*
	@Override
	public List<TrackerEnquiry> getEnquiryById() {
		// TODO Auto-generated method stub
		return jdbctemplate.query(enquiry, new EnquiryRowMapper());
	}

*/

	@Override
	public List<TrackerRfp> getstatus() {
		// TODO Auto-generated method stub
		return jdbctemplate.query(rejuct, new TrackerRfpRowMapper());
	}
	

}