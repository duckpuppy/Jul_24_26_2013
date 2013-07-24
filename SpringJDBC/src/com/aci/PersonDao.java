package com.aci;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class PersonDao {
	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public void updateName(int id,String name){
		//ERROR IN THE FOLLOWING CODE
		jdbcTemplate.update("update set age=? where id=?",name,id);		
	}

	public void updateAge(int id,int newAge){
		jdbcTemplate.update("update persons set age=? where id=?",newAge,id);		
	}
	public int getAge(int id){
		int age = -1;
		age = jdbcTemplate.queryForObject("select age from persons where id=?",Integer.class,id);
		return age;
	}
	public List<Person> getAllPersons(){
		List<Person> persons = null;
		persons = jdbcTemplate.query("select * from persons", new RowMapper<Person>(){
			public Person mapRow(ResultSet rs, int rowIndex) throws SQLException {
				Person person = new Person();
				person.setId(rs.getInt("id"));
				person.setName(rs.getString("name"));
				person.setAge(rs.getInt("age"));
				return person;
			}
		});
		return persons;
	} 
	//public int getAge(int id){}
	//public List<String> getAllNames(){}

	public void insert(String name,int age){
		String query = "insert into persons(name,age) value(?,?)";
		jdbcTemplate.update(query,name,age);
	}
}
