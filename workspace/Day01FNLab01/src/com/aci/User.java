package com.aci;

public class User {
	private Conference conference;

	public Conference getConference() {
		return conference;
	}

	public void setConference(Conference conference) {
		this.conference = conference;
	}
	
	public void printSessions() {
		System.out.println("45-minute sessions: " + conference.getTopics("45").size());
		for (int i = 0; i < conference.getTopics("45").size(); i++) {
			System.out.println("*** " + conference.getTopics("45").get(i));
		}
		System.out.println("50-minute sessions: " + conference.getTopics("50").size());
		for (int i = 0; i < conference.getTopics("50").size(); i++) {
			System.out.println("*** " + conference.getTopics("50").get(i));
		}
		System.out.println("60-minute sessions: " + conference.getTopics("60").size());
		for (int i = 0; i < conference.getTopics("60").size(); i++) {
			System.out.println("*** " + conference.getTopics("60").get(i));
		}
	}
}
