package com.old;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

public class EmployeeAspect implements 
	MethodBeforeAdvice,AfterReturningAdvice,MethodInterceptor{

	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		Employee emp = (Employee)methodInvocation.getThis();
		
		if("enterServerRoom".equals(methodInvocation.getMethod().getName()) &&
				!("Admin".equals(emp.getRole())))
		{
			System.out.println("Cannot enter server room");
			return null;
		}
		return methodInvocation.proceed();
	}

	public void afterReturning(Object target, Method method, Object[] args,
			Object arg3) throws Throwable {
		System.out.println("****after calling " + method.getName());
	}

	public void before(Method method, Object[] args, Object target)
			throws Throwable {
		System.out.println("***Before calling " + method.getName());
	}
	
}
