package com.aci;

public class Topic {
	private int id;
	private String title;
	private int duration;

	public Topic(int id, String title, int duration) {
		this.id = id;
		this.title = title;
		this.duration = duration;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	public String toString() {
		return String.format("%s: %s minutes", this.title, this.duration);
	}
}
