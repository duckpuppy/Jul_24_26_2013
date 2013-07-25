package com.aci;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class TxUser {
	public static void main(String[] args)throws Exception {
		ApplicationContext context = new FileSystemXmlApplicationContext("bin/com/aci/beans.xml");
		PersonDao personDao = (PersonDao)context.getBean("personDao");
		System.out.println(personDao.getClass());
		System.out.println(personDao.getClass().getSuperclass());
		personDao.addTwoDogs("Snoopy", "Rover");
		//personDao.addTwoPersons("Sam", 12, "Johnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn", 56);
		System.out.println("Done");
	}
}
