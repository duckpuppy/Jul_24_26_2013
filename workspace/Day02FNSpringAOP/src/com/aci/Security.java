package com.aci;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Security {
	@Autowired
	private Employee emp;
	
	public void scanEmployee() {
		emp.beginWork();
	}
}
