package com.aci;

import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class DaoMain {

	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext("bin/com/aci/beans.xml");
		PersonDao personDao = (PersonDao)context.getBean("personDao");
		personDao.insert("Sam", 12);
		/*DogDao dogDao = (DogDao)context.getBean("dogDao");
		dogDao.insert("Snoopy");*/
		List<Person> persons = personDao.getAllPersons();
		for (Person person : persons) {
			System.out.println(person.getName());
		}
		System.out.println("Done");
	}
}
