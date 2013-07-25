package com.aci;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class AccountWorker {
	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext(
				"bin/com/aci/beans.xml");
		Account account = context.getBean("account", Account.class);
		account.setAccountNumber("2341515451");

		account.deposit(500);
		account.withdraw(100);
		account.withdraw(500);
		account.withdraw(800);
		account.deposit(5000);
		account.withdraw(800);
	}
}
