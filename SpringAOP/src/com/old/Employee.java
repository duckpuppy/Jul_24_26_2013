package com.old;

import org.springframework.stereotype.Component;

public class Employee {
	private String role = "Intern";
	
	//Used for throws advice
	public void violateRules(){
		throw new RuntimeException("Rules violated");
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public void enterServerRoom(){
		System.out.println("In server room");
	}
	public void gotoOffice(){
		System.out.println("Leaving for work");
	}
	public void work(){
		System.out.println("Coding");
	}
	public void checkMail(){
		System.out.println("Playing with Gmail");
	}
}
