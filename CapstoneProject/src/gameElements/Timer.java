package gameElements;

import processing.core.PApplet;

public class Timer {
	
	private float time;
	
	public Timer(float set) {
		time = set;
	}
	
	public float getTime() {
		return time;
	}
	
	public void setTime(int value) {
		time = value;
	}
	
	public float countUp(PApplet marker) {
		
		time += 1/marker.frameRate;
		return time;
	}

}