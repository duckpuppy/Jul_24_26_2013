package com.aci;

import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.dao.DataAccessException;

public class DaoMain {

	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext("bin/com/aci/usingannot.xml");
		DogDao dogDao = (DogDao)context.getBean("dogDao");
		dogDao.insert("Rover");
/*		ApplicationContext context = new FileSystemXmlApplicationContext("bin/com/aci/beans.xml");
		PersonDao personDao = (PersonDao)context.getBean("personDao");
		try{
			personDao.updateName(1, "Joe");
		}
		catch(DataAccessException dex){
			System.out.println("Error: " + dex.getMessage());
			Throwable innerEx = dex.getRootCause();
			System.out.println("Root cause: " + innerEx.getMessage());
		}
			//personDao.updateAge(1, 56);
		//personDao.insert("Sam", 12);
		DogDao dogDao = (DogDao)context.getBean("dogDao");
		dogDao.insert("Snoopy");
		List<Person> persons = personDao.getAllPersons();
		for (Person person : persons) {
			System.out.println(person.getName());
		}*/
		System.out.println("Done");
	}
}
