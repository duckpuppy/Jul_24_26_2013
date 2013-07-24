package com.lab01;

import java.util.Iterator;
import java.util.Map;

public class SessionPlannerImpl implements SessionPlanner{

	private Map<String, String> topics;
	private int numberOf45MinSessions;
	private int numberOf50MinSessions;
	private int numberOf60MinSessions;
	
	public SessionPlannerImpl(Map<String,String> topics){
		this.topics = topics;
		organizeSessions();
	}

	private void organizeSessions() {
		Iterator<String> values = topics.values().iterator();
		while(values.hasNext()){
			String item = values.next();
			if(item.contains("45 min"))
				numberOf45MinSessions++;
			else if(item.contains("50 min"))
				numberOf50MinSessions++;
			else if(item.contains("60 min"))
				numberOf60MinSessions++;
		}
	}
	
	
	public void setTopics(Map<String, String> topics) {
		this.topics = topics;
	}

	public int getNumberOf45MinSessions() {
		return numberOf45MinSessions;
	}

	public int getNumberOf50MinSessions() {
		return numberOf50MinSessions;
	}

	public int getNumberOf60MinSessions() {
		return numberOf60MinSessions;
	}

}
