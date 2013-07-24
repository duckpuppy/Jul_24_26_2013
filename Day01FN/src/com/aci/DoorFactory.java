package com.aci;

public class DoorFactory {
	public static Door getDoorWithSoundAlarm(){
		Door door = new Door();
		Alarm alarm = new SoundAlarm();
		door.setAlarm(alarm);
		return door;
	}
}
