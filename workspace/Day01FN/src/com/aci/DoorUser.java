package com.aci;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class DoorUser {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new FileSystemXmlApplicationContext("bin/com/aci/beans.xml");
		Door door = context.getBean("door", Door.class);
		
		door.open();
		// ...
		door.close();
	}
}
