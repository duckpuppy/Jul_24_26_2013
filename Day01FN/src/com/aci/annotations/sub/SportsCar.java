package com.aci.annotations.sub;

import org.springframework.stereotype.Component;

//<bean id="subSportsCar" class=""/>
@Component("subSportsCar")
public class SportsCar {
	public SportsCar(){
		System.out.println("***sub SportsCar created");
	}
}
