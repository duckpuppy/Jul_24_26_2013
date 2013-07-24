package com.aci;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SessionPlanner {
	Map<String,List<String>> sessionMap;

	public Map<String,List<String>> getSessionMap() {
		return sessionMap;
	}

	public void setSessionMap(Map<String,String> flatMap) {
		Iterator<String> values = flatMap.values().iterator();
		this.sessionMap = new HashMap<String,List<String>>();
		sessionMap.put("45", new ArrayList<String>());
		sessionMap.put("50", new ArrayList<String>());
		sessionMap.put("60", new ArrayList<String>());
		
		while(values.hasNext()) {
			String[] item = values.next().split("-");
			if (item[1].contains("45 min")) {
				sessionMap.get("45").add(item[0].trim());
			}
			else if (item[1].contains("50 min")) {
				sessionMap.get("50").add(item[0].trim());
			}
			else if (item[1].contains("60 min")) {
				sessionMap.get("60").add(item[0].trim());
			}
		}
	}
	
	public List<String> getTopics(String duration) {
		return sessionMap.get(duration);
	}
}
