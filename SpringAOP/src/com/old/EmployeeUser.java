package com.old;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class EmployeeUser {
	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext("bin/com/old/beans.xml");
		Employee emp = (Employee)context.getBean("employee");
		emp.setRole("User");
		emp.enterServerRoom();
		emp.work();
		emp.checkMail();
	}
}
