package gameElements;

import processing.core.PApplet;

public class Timer {
	
	private float time;
	
	/**
	 * Assigns a value to the time which is where it will start at
	 * @param set
	 */
	public Timer(float set) {
		time = set;
	}
	/**
	 * Gets the current time in seconds
	 * @return the current time
	 */
	public float getTime() {
		return time;
	}
	
	/**
	 * Sets the time to a new value
	 * @param value the new value the time will be set to
	 */
	public void setTime(int value) {
		time = value;
	}
	
	/**
	 * Increments the time based on the frame rate provided by the Processing library
	 * @param marker used to access elements from Processing
	 * @return the time after incrementing
	 */
	public float countUp(PApplet marker) {
		
		time += 1/marker.frameRate;
		return time;
	}

}