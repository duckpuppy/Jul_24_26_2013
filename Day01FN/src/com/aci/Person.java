package com.aci;

import java.util.ArrayList;

public class Person {
	private String name;
	private ArrayList<String> hobbies;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(ArrayList<String> hobbies) {
		this.hobbies = hobbies;
	}

	public Person(){
		System.out.println("**Person created");
	}
}
