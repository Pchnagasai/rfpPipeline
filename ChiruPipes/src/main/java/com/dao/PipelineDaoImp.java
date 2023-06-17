package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class PipelineDaoImp implements PipelineDao {
	@Autowired
	private JdbcTemplate jdbctemplate;

	private String sql = "select count(*) from tracker_enquiries";
	private String rfp="  select count(*) from tracker_rfp";
	private String activerfps="select count(*) from tracker_rfp where rfpr_status='Open'";
	private String rfpcomplete="select count(*) from tracker_rfpr_documents where rpdf_status='Approved'";

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
		try {
			return jdbctemplate.queryForObject(rfp, Integer.class);
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return 0;
	}

	@Override
	public int getActiverfpscount() {
		// TODO Auto-generated method stub
		try {
			return jdbctemplate.queryForObject(activerfps, Integer.class);
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return 0;
	}

	@Override
	public int getcompleterfpcount() {
		// TODO Auto-generated method stub
		try {
			return jdbctemplate.queryForObject(rfpcomplete, Integer.class);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return 0;
	}

}
