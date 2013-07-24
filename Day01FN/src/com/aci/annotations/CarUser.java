package com.aci.annotations;

import org.springframework.context.support.FileSystemXmlApplicationContext;

import org.springframework.context.ApplicationContext;

public class CarUser {

	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext("bin/com/aci/annotations/beans.xml");
		Car car = (Car)context.getBean("car");
		System.out.println(car.getColor());
		System.out.println(car.getAttributes());
		Car car2 = (Car)context.getBean("car");
		System.out.println(car2);
		System.out.println(car.getEngine());
		System.out.println(car2.getEngine());
	}
}
