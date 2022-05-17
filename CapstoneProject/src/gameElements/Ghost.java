package gameElements;

import core.DrawingSurface;
import processing.core.PApplet;
import processing.core.PImage;

public class Ghost {
	
	private int x;
	private int y;
	private int prevX;
	private int prevY;

	private DrawingSurface surface;
	
	/**
	 * Assigns values to the x and y coordinates of the ghost.
	 * @param x1 x coordinate of the ghost
	 * @param y1 y coordinate of the ghost
	 */
	public Ghost() {
//		surface = new DrawingSurface();
//		prevX = 0;
//		prevY = 0;
//		int seconds = surface.getSeconds();
//		if (seconds != 5) {
			x = (int) (Math.random() * 500);
			y = (int) (Math.random() * 500);
//			prevX = x;
//			prevY = y;
//		} else {
//			x = prevX;
//			y = prevY;
//		}
	}	
	
	/**
	 * Gets the x coordinate of the ghost
	 * @return the x coordinate of the ghost
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Gets the y coordinate of the ghost
	 * @return the y coordinate of the ghost
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Sets the x coordinate of the ghost to the new x value passed in as a parameter
	 * @param x new x coordinate of the ghost
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * Sets the y coordinate of the ghost to the new y value passed in as a parameter
	 * @param y new y coordinate of the ghost
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * Draws the ghost at (x,y)
	 * @param p PApplet object used to draw the coin
	 */
	public void draw(PApplet p) {
		PImage img = new PImage();
		img = p.loadImage("images/ghost.gif");
		img.resize(40, 40);
		p.image(img, x, y);
	}
}
