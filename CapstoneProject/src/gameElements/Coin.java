package gameElements;

import java.awt.Color;
import java.awt.Rectangle;

import ameduri.shapes.Circle;
import processing.core.PApplet;
import processing.core.PImage;

public class Coin {

	
	private int x, y, diameter;
	
	/**
	 * Assigns values to the x and y coordinates of the coin. The diameter is also assigned a value.
	 * @param x1 x coordinate of the coin
	 * @param y1 y coordinate of the coin
	 */
	public Coin (int x1, int y1) {
		x = x1;
		y = y1;
		diameter = 10;
	}
	
	/**
	 * Gets the x coordinate of the coin
	 * @return the x coordinate of the coin
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Gets the y coordinate of the coin
	 * @return the y coordinate of the coin
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Sets the x coordinate of the coin to the new x value passed in as a parameter
	 * @param x new x coordinate of the coin
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * Sets the y coordinate of the coin to the new y value passed in as a parameter
	 * @param y new y coordinate of the coin
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * Draws the coin at (x,y) with a diameter
	 * @param p PApplet object used to draw the coin
	 */
	public void draw(PApplet p) {
		
		Circle coin = new Circle(x, y, diameter);
		coin.setFillColor(Color.YELLOW);
		coin.draw(p);
	}
	

		
}
