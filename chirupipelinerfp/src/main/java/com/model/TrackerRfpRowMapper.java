package com.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class TrackerRfpRowMapper implements RowMapper<TrackerRfp> {

	@Override
	public TrackerRfp mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		TrackerRfp trackerrfp = new TrackerRfp();
		
		trackerrfp.setEnqr_id(rs.getInt("enqr_id"));
		trackerrfp.setEnqr_status(rs.getString("enqr_status"));
		trackerrfp.setRfpr_status(rs.getString("rfpr_status"));
		
		

		return trackerrfp;
	}

}
