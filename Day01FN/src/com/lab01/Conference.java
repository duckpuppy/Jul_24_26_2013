package com.lab01;

public class Conference {
	private SessionPlanner sessionPlanner;

	public void setSessionPlanner(SessionPlanner sessionPlanner) {
		this.sessionPlanner = sessionPlanner;
	}
	public int get45MinSessionCount(){
		return sessionPlanner.getNumberOf45MinSessions();
	}
	public int get50MinSessionCount(){
		return sessionPlanner.getNumberOf50MinSessions();
	}
	public int get60MinSessionCount(){
		return sessionPlanner.getNumberOf60MinSessions();
	}
}
