package com.aci;

import org.springframework.stereotype.Component;

@Component
public class Employee {
	
	private String role = "User";

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void violateRules() {
		throw new RuntimeException("Rules Violated");
	}
	
	public void enterServerRoom() {
		System.out.println("In the server room");
	}

	public void beginWork() {
		System.out.println("Arriving at work");
	}

	public void work() {
		System.out.println("Coding");
	}

	public void checkMail() {
		System.out.println("Playing with Gmail");
	}

}
