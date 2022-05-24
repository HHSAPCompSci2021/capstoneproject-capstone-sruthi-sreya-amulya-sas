package gameElements;

import processing.core.PApplet;
import processing.core.PImage;

public class Ghost {
	
	private int x;
	private int y;
	private int prevX;
	private int prevY;
	private double xVel;
	private double yVel;
	private PImage image;
	
	
	/**
	 * Assigns values to the x and y coordinates of the ghost.
	 * @param x1 x coordinate of the ghost
	 * @param y1 y coordinate of the ghost
	 */
	public Ghost(PApplet p) {
		image = new PImage();
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
		image = p.loadImage("images/ghost.gif");
		image.resize(40, 40);
		p.image(image, x, y);
	}
	
	/**
	 * Stops the ghosts from moving randomly
	 */
	public void stopGhosts() {
		x = prevX;
		y = prevY;
	}
	
	/**
	 * Makes the ghosts move randomly on the screen
	 */
	public void moveGhosts() {
		prevX = 0;
		prevY = 0;
		x = 50 + (int) (Math.random() * 200);
		y = 50 + (int) (Math.random() * 200);
		
		prevX = x;
		prevY = y;
	}
	
	/**
	 * Changes the velocity of the golf ball to make it move
	 * @param vx the change in x of the x velocity
	 * @param vy the change in y of the y velocity
	 */
	public void accelerate(double vx, double vy) {
		this.xVel = vx;
		this.yVel = vy;
	}
	
}
