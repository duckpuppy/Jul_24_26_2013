package com.aci;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
//@Transactional(propagation=Propagation.NOT_SUPPORTED)
public class PersonDao {
	private JdbcTemplate jdbcTemplate;
	
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=MyException.class)
	public void addTwoDogs(String name1,
			String name2)throws Exception{
		String query = "insert into dogs(name) values(?)";
		jdbcTemplate.update(query,name1);
		int arr[] = {1,2};
		if(arr.length == 2 )
			throw new MyException("Array length should not be 2");
		jdbcTemplate.update(query,name2);
	}
	
	
	public void addPerson(String name,int age){
			String query = "insert into persons(name,age) values(?,?)";
			jdbcTemplate.update(query,name,age);
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void addTwoPersons(String name1,int age1,
			String name2,int age2){
		String query = "insert into persons(name,age) values(?,?)";
		jdbcTemplate.update(query,name1,age1);
		jdbcTemplate.update(query,name2,age2);
	}
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
}
