package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class PipelineDaoImp implements PipelineDao {
	@Autowired
	private JdbcTemplate jdbctemplate;

	private String sql = "select count(*)  from tracker_enquiries";
	private String rfpsql = "";

	@Override
	public int getEnquiryCount() {
		// TODO Auto-generated method stub

		try {
			return jdbctemplate.queryForObject(sql, Integer.class);
		} catch (EmptyResultDataAccessException e) {
			return 0; // Return a default value when no result is found
		}
	}

	@Override
	public int getRFPCount() {
		// TODO Auto-generated method stub
		return 0;
	}

}
