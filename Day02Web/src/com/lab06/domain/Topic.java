package com.lab06.domain;

public class Topic {
	private int id;
	private String title;
	private int duration;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public Topic(int id, String title, int duration) {
		this.id = id;
		this.title = title;
		this.duration = duration;
	}
	public Topic() {
	}
}
