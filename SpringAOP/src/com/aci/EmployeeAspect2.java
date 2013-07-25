package com.aci;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

public class EmployeeAspect2 {

	public void check(ProceedingJoinPoint proceedingJoinPoint)throws Throwable{
		Employee emp = (Employee)proceedingJoinPoint.getTarget();
		if(!"Admin".equals(emp.getRole())){
			System.out.println("-->Server room access DENIED for " + emp.getRole());
		}
		else
			proceedingJoinPoint.proceed();
	}
	
	public void printInfoAfter(JoinPoint joinPoint){
		System.out.println("***After calling  " + joinPoint.getSignature());
	}

	public void printInfo(JoinPoint joinPoint){
		System.out.println("***Before calling  " + joinPoint.getSignature());
	}
	public void handleExceptions(JoinPoint joinPoint,Throwable throwable){
		System.out.println("ERROR " + throwable.getMessage() );
		throw new RuntimeException("HORROR");
	}
}
