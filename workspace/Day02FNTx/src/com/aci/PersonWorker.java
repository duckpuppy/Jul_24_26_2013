package com.aci;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class PersonWorker {
	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext(
				"bin/com/aci/beans.xml");

		PersonDao persondao = context.getBean("personDao", PersonDao.class);
		DogDao dogdao = context.getBean("dogDao", DogDao.class);
		persondao.resetDatabase();
		dogdao.resetDatabase();
		persondao.addTwoPersons("Patrick", 39, "Renee", 39);
		try {
			dogdao.addTwoDogs("Honey", "Leyna");
		} catch (Exception e) {}

		((FileSystemXmlApplicationContext) context).close();
	}
}