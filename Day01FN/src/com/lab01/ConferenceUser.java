package com.lab01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ConferenceUser {

	public static void main(String[] args) {
		ApplicationContext context = 
				new FileSystemXmlApplicationContext("bin/com/lab01/beans.xml");	
		Conference conference = context.getBean("conference",Conference.class);
		System.out.println("45 min sessions: " + conference.get45MinSessionCount());
		System.out.println("50 min sessions: " + conference.get50MinSessionCount());
		System.out.println("60 min sessions: " + conference.get60MinSessionCount());
	}
}
