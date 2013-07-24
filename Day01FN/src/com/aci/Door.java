package com.aci;

public class Door {
	private Alarm alarm;
	private String material;
	
	public Door(){}
	public Door(Alarm alarm,String material){
		this.alarm = alarm;
		this.material = material;
	}
	public void setAlarm(Alarm alarm) {
		this.alarm = alarm;
	}
	public void open(){
		alarm.activate();
	}
	public void close(){
		alarm.deactivate();
	}
}
