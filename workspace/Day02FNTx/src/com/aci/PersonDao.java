package com.aci;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class PersonDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public void addTwoPersons(String name1, int age1, String name2, int age2) {
		String query = "insert into persons(name,age) values(?,?)";
		jdbcTemplate.update(query, name1, age1);
		jdbcTemplate.update(query, name2, age2);
	}
	
	public void resetDatabase() {
		String emptyTable = "delete from persons;";
		String resetCounter = "alter table persons AUTO_INCREMENT=1;";
		
		jdbcTemplate.update(emptyTable);
		jdbcTemplate.update(resetCounter);
	}
}
