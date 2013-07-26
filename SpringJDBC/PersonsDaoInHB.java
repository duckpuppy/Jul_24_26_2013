package com.sf.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.sf.Person;

@Repository
public class PersonsDaoInHB {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public void create(String firstName,String lastName,int age){
		Person person = new Person(firstName,lastName,age);
		hibernateTemplate.save(person);
	}
	
	public void updateAge(int id,int newAge){
		Person person = hibernateTemplate.get(Person.class, id);
		person.setAge(newAge);
		hibernateTemplate.update(person);
	}
	
	public List<Person> loadAllPersons(){
		return hibernateTemplate.find("from com.sf.Person");
	}
	
	public Person select(int id){
		return hibernateTemplate.get(Person.class, id);
	}
}
