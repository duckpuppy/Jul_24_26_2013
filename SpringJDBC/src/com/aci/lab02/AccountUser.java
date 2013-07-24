package com.aci.lab02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class AccountUser {

	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext("bin/com/aci/lab02/beans.xml");
		AccountService accountService = context.getBean("accountService",AccountService.class);
		accountService.deposit(1, "Interest", 10);
		accountService.withdraw(1, "Fee", 20);
		System.out.println("Done");
	}

}
