package com.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.dao.TrackerEnquiryDao;
import com.dao.TrackerEnquiryDaoImp;

@Configuration
public class AppConfig {
	@Bean
	public DataSource dataSource() {
		// Configure and return the DataSource bean based on your database settings
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://localhost:5432/chiru");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres");
		return dataSource;
	}

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource());
	}

	@Bean
	public TrackerEnquiryDao trackerenquirydao() {
		return new TrackerEnquiryDaoImp();
	}

}