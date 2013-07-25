package com.aci;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class EmployeeUser {
	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext("bin/com/aci/beans.xml");
		Employee emp = (Employee)context.getBean("employee");
		emp.setRole("User");
		emp.enterServerRoom();
		emp.violateRules();
//		emp.work();
//		emp.checkMail();
		//Security security = (Security)context.getBean("security");
		//security.scan();
		
		//security.frisk(new Employee());
		
		/*Employee emp = (Employee)context.getBean("employee");
		System.out.println(emp.getClass().getName());
		System.out.println(emp.getClass().getSuperclass().getName());
		//emp.gotoOffice();
		emp.work();
		emp.checkMail();*/
	}
}
