package com.aci;

import java.util.List;

public class Conference {
	private SessionPlanner planner;

	public SessionPlanner getPlanner() {
		return planner;
	}

	public void setPlanner(SessionPlanner planner) {
		this.planner = planner;
	}
	
	public List<String> getTopics(String duration) {
		return planner.getTopics(duration);
	}
}
