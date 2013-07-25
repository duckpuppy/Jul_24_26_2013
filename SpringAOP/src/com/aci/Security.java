package com.aci;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Security {
	private Employee employee;
	@Autowired
	public void setEmployee(Employee employee) {
		this.employee = employee;
		System.out.println("wiring employee: " + employee.getClass().getName());
	}
	public void frisk(Employee emp){
		
	}
	public void scan(){
		System.out.println("Scanning employee");
		employee.gotoOffice();
	}
}
