package com.aci;

import org.springframework.jdbc.core.JdbcTemplate;

public class DogDao {
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
