package com.lab03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class AccountUser {
	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext("bin/com/lab03/beans.xml");
		Account account = (Account)context.getBean("account");
		account.deposit(200);
		account.withdraw(300);
		account.deposit(1000);
		account.withdraw(1400);
	}
}
