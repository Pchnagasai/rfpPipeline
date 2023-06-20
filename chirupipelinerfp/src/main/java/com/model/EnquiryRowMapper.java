package com.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EnquiryRowMapper implements RowMapper<TrackerEnquiry> {

	@Override
	public TrackerEnquiry mapRow(ResultSet rs, int rowNum) throws SQLException {

		TrackerEnquiry enquiry = new TrackerEnquiry();

		enquiry.setEnqrid(rs.getInt("enqr_id"));
		enquiry.setEnqrstatus(rs.getString("enqr_status"));
		
		
	

		return enquiry;
	}
}