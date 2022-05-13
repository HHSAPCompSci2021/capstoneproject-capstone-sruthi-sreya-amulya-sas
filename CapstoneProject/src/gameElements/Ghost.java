package gameElements;

import processing.core.PApplet;
import processing.core.PImage;

public class Ghost {

private int x, y;
	
	/**
	 * Assigns values to the x and y coordinates of the ghost.
	 * @param x1 x coordinate of the ghost
	 * @param y1 y coordinate of the ghost
	 */
	public Ghost (int x1, int y1) {
		x = x1;
		y = y1;
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
		img = p.loadImage("images/coin.gif");
		img.resize(20, 20);
		p.image(img, x, y);
	}
}
