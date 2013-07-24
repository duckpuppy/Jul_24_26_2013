package com.aci;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class PersonUser {

	public static void main(String[] args) {
		ApplicationContext context = 
				new FileSystemXmlApplicationContext("bin/com/aci/beans3.xml");
		Person person = context.getBean("person3",Person.class);
		System.out.println(person.getHobbies());
		//System.out.println(person.getName());
/*		System.out.println("I'm going to call getBean('person')");
		Person p = (Person)context.getBean("person");
		//Person p = context.getBean("person",Person.class);
		System.out.println(p);
		Person p2 = (Person)context.getBean("person");
		System.out.println(p2);*/
	}
}
