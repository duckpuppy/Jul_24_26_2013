package com.aci;

import org.springframework.jdbc.core.JdbcTemplate;

public class DogDao {
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void insert(String name){
		String query = "insert into dogs(name) value(?)";
		jdbcTemplate.update(query,name);
	}
}
