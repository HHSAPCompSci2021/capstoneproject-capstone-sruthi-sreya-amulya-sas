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
	
	public abstract void scaleUp();
	
	public abstract void scaleDown();
	
	public boolean getScale() {
		return scale;
	}
	
	public void setScale(boolean b) {
		scale = b;
	}
}
