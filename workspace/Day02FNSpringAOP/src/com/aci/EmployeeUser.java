package com.aci;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class EmployeeUser {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new FileSystemXmlApplicationContext(
				"bin/com/aci/beans.xml");
		Security sec = context.getBean("security", Security.class);
		Employee emp = context.getBean("employee", Employee.class);
		sec.scanEmployee();
		emp.work();
		emp.enterServerRoom();
		emp.checkMail();
		try {
			emp.violateRules();
		} finally {}
	}

}
