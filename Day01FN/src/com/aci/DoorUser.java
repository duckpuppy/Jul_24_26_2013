package com.aci;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class DoorUser {

	public static void main(String[] args) {
		ApplicationContext context = 
				new FileSystemXmlApplicationContext("bin/com/aci/beans.xml");
		
		Account account1 = context.getBean("account",Account.class);
		Account account2 = context.getBean("account",Account.class);
		Account account3 = context.getBean("account",Account.class);
		System.out.println(account1);
		System.out.println(account2);
		System.out.println(account3);
/*		Door door = context.getBean("door",Door.class);
		//Door door = DoorFactory.getDoorWithSoundAlarm(); 
		door.open();
		//...
		door.close();*/
	}
}
