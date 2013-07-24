package com.aci;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class DaoMain {
	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext("bin/com/aci/beans.xml");
		PersonDao persondao = context.getBean("persondao", PersonDao.class);
		
		persondao.resetDatabase();
		
		persondao.insert("Patrick", 39);
		persondao.insert("Renee", 39);
		persondao.insert("Brynn", 3);
		persondao.insert("Drew", 1);

		System.out.println("Persons: " + persondao.getAllPersons());
		
		System.out.println("Drew's Age: " + persondao.getAge(4));
		System.out.println(persondao.getAllNames());
		
		persondao.updateAge(4, 2);
		System.out.println("Drew's Age: " + persondao.getAge(4));
		
		System.out.println("Persons: " + persondao.getAllPersons());
	}
}
