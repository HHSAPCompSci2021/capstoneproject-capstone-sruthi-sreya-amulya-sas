package screens;

import processing.core.PApplet;

public abstract class Level {
	
	private boolean scale;
	
	/**
	 * Instantiates new Coin ArrayList
	 */
	public Level(boolean scale) {
		this.scale = scale;
	}

	/**
	 * 
	 * @param marker PApplet object used to draw golf course
	 */
	public abstract void draw(PApplet marker);
	
	/**
	 * Increases the size of the golf course to make it zoom in
	 */
	public abstract void scaleUp();
	
	/**
	 * Decreases the size of the golf course to make it zoom out
	 */
	public abstract void scaleDown();
	
	/**
	 * Gets whether or not the golf course has been scaled
	 * @return true or false based on whether or not the golf course has been scaled
	 */
	public boolean getScale() {
		return scale;
	}
	
	/**
	 * Sets scale to true or false based on the method input
	 * @param b whether or not the graphics have been scaled (true or false)
	 */
	public void setScale(boolean b) {
		scale = b;
	}
}
