package com.lab05;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value="session",proxyMode=ScopedProxyMode.TARGET_CLASS)
public class GuessingGame implements Serializable{
	private int target;
	private int attempts;
	private String message;
	public GuessingGame(){
		target = (int)(Math.random()*100);
	}
	public void play(int guess){
		attempts++;
		if(guess > target)
			message = "Aim Lower";
		else if(guess < target)
			message = "Aim Higher";
		else
			message = "You have got it!!!";
	}
	public int getTarget() {
		return target;
	}
	public int getAttempts() {
		return attempts;
	}
	public String getMessage() {
		return message;
	}
}
