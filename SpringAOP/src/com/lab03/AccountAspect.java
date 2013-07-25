package com.lab03;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AccountAspect {
	//NOT REFACTORED
	@Around("execution(void Account.withdraw(double))")
	public void withdrawCheck(ProceedingJoinPoint proceedingJoinPoint)throws Throwable{
		Account account = (Account)proceedingJoinPoint.getTarget();
		double amount = (Double)proceedingJoinPoint.getArgs()[0];
		double balance = account.getBalance();
		if(amount < 500){
			System.out.println("Withdraw denied. You should withdraw atleast $500");
			FileHelper.write("accounts.log", "Withdraw denied. You should withdraw atleast $500");
			return;
		}
		if((balance-amount) < 1000){
			System.out.println("Withdraw denied. Minimum balance should be $1000");
			FileHelper.write("accounts.log", "Withdraw denied. Minimum balance should be $1000");
			return;
		}
		if(amount < balance){
			System.out.println("Withdraw denied. Insufficient balance");
			FileHelper.write("../accounts.log", "Withdraw denied. Insufficient balance");
			return;
		}
		proceedingJoinPoint.proceed();
	}
	@After("execution(void Account.*(double))")
	public void printBalanceAfterWithdrawAndDeposit(JoinPoint joinPoint){
		Account account = (Account)joinPoint.getTarget();
		System.out.println("Balance: " + account.getBalance());
	}
	
}
