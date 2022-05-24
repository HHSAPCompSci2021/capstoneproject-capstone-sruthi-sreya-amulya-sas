package gameElements;

import ameduri.shapes.Circle;
import ameduri.shapes.Rectangle;
import processing.core.PApplet;

public class GolfBall{

	private double x, y, diameter;
	private double vx, vy;
	private Circle c;
	private float r,g,b;

	/**
	 * Assigns values to the x and y coordinates of the golf ball and sets the
	 * diameter of the golf ball
	 */
	public GolfBall() {
		x = 260;
		y = 220;
		diameter = 15;
		vx = 0;
		vy = 0;
	}

	/**
	 * Gets the x coordinate of the golf ball
	 * 
	 * @return the x coordinate of the golf ball
	 */
	public double getX() {
		return x;
	}

	/**
	 * Gets the y coordinate of the golf ball
	 * 
	 * @return the y coordinate of the golf ball
	 */
	public double getY() {
		return y;
	}

	/**
	 * Sets the x coordinate of the golf ball to the new x value passed in as a
	 * parameter
	 * 
	 * @param x new x coordinate of the golf ball
	 */
	public void setX(double x) {
		this.x = x;
	}

	/**
	 * Sets the y coordinate of the golf ball to the new y value passed in as a
	 * parameter
	 * 
	 * @param y new y coordinate of the golf ball
	 */
	public void setY(double y) {
		this.y = y;
	}

	/**
	 * Draws the golf ball at (x,y)
	 * 
	 * @param p PApplet object used to draw the golf ball
	 */
	public void draw(PApplet marker) {
		c = new Circle(x, y, diameter);

		c.draw(marker);
		
		
	}
	
	/**
	 * Checks whether or not the golf ball bumps into a boundary, and if it does, it
	 * bounces off the boundary
	 * 
	 * @param x_diff the difference in y by which the y coordinate of the golf ball
	 *               is changing
	 * @param y_diff the difference in y by which the y coordinate of the golf ball
	 *               is changing
	 * @return true or false depending on whether or not the golf ball intersects a
	 *         boundary line
	 */
	public boolean bounce1(double x_diff, double y_diff) {


		Rectangle r = new Rectangle(50, 50, 100, 0); // right
		Rectangle r2 = new Rectangle(150, 50, 0, 100); // down
		Rectangle r3 = new Rectangle(150, 150, 150, 0); // right
		Rectangle r4 = new Rectangle(300, 150, 0, 100); // down
		Rectangle r5 = new Rectangle(50, 250, 250, 0); // left
		Rectangle r6 = new Rectangle(50, 50, 0, 200); // up
		Rectangle temp = new Rectangle(x, y, diameter, diameter);

		if (r.intersects(temp)) {

			this.setY((int) (50 + y_diff));
			this.setX((int) (getX() + x_diff));
			return true;

		}
		if (r2.intersects(temp)) {

			this.setY((int) (getY() + y_diff));
			this.setX((int) (150 + x_diff));
			return true;

		}
		if (r3.intersects(temp)) {
			vx -= -0.2;
			vy += -0.2;
			this.setY((int) (150 + y_diff));
			this.setX((int) (getX() + x_diff));
			return true;

		}
		if (r4.intersects(temp)) {
			this.setX((int) (300 + x_diff));
			this.setY((int) (getY() + y_diff));
			return true;
		}
		if (r5.intersects(temp)) {
			this.setX((int) (100 - x_diff));


			this.setY((int) (getY() + y_diff));
			if (y_diff < 0)
				this.setY((int) (getY() + y_diff));
			else
				this.setY((int) (getY() - y_diff));

			return true;
		}
		if (r6.intersects(temp)) {
			this.setX((int) (50 + x_diff));
			this.setY((int) (getY() + y_diff));
			return true;
		}
		return false;
	}


	/**
	 * Calculates the distance between two points
	 * 
	 * @param x1 starting x coordinate
	 * @param y1 starting y coordinate
	 * @param x2 ending x coordinate
	 * @param y2 ending y coordinate
	 * @return the distance between two points
	 */
	public int getDistance(double x1, double y1, double x2, double y2) {
		double a = Math.abs(x1 - x2) + 1;
		double b = Math.abs(y1 - y2) + 1;
		double c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
		return (int) c;
	}

	/**
	 * Determines if the golf ball fell in the hole
	 * 
	 * @return true or false depending on if the golf ball intersected the hole
	 */
	public boolean goal() {
		Circle temp = new Circle(90, 90, 10);

		if (temp.intersects(c)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Determines if the golf ball hit a coin
	 * 
	 * @return true or false depending on if the golf ball hit a coin
	 */
	public boolean coinIntersects() {
		Rectangle temp = new Rectangle(100, 150, 20, 20);
		Rectangle r = new Rectangle(x, y, diameter, diameter);
		Rectangle temp2 = new Rectangle(200, 200, 20, 20);

		if (temp.intersects(r) || temp2.intersects(r)) {
			return true;
		} else {
			return false;

		}
	}

	/**
	 * Determines if the golf ball hit a ghost
	 * 
	 * @return true or false depending on if the golf ball hit a ghost
	 */
	public boolean ghostIntersects(Ghost one, Ghost two) {
		Rectangle temp = new Rectangle(one.getX(), one.getY(), 40, 40);
		Rectangle temp2 = new Rectangle(two.getX(), two.getY(), 40, 40);
		Rectangle r = new Rectangle(x, y, diameter, diameter);
		if (temp.intersects(r) || temp2.intersects(r)) {
			return true;
		} else {
			return false;

		}

	}
	
	/**
	 * This method is used to set the golf ball to an rgb color value
	 * @param a the r value in rgb
	 * @param b the g value in rgb
	 * @param c the b value in rgb
	 */
	public void setRGB(float a, float b, float c) {
		r = a;
		g = b;
		this.b = c;
	}
	
	/**
	 * Gets the r value in rgb
	 * @return the r value in rgb
	 */
	public float getR() {
		return r;
	}
	
	/**
	 * Gets the g value in rgb
	 * @return the g value in rgb
	 */
	public float getG() {
		return g;
	}
	
	/**
	 * Gets the b value in rgb
	 * @return the b value in rgb
	 */
	public float getB() {
		return b;
	}
	
	/**
	 * Sets the x-velocity to a new value
	 * @param x the new x-velocity value
	 */
	public void setVX(double x) {
		this.vx = x;
	}

	/**
	 * Sets the y-velocity to a new value
	 * @param y the new y-velocity value
	 */
	public void setVY(double y) {
		this.vy = y;
	}
	
	/**
	 * Gets the x-velocity
	 * @return the x-velocity
	 */
	public double getVX() {
		return vx;
	}
	
	/**
	 * Gets the y-velocity
	 * @return the y-velocity
	 */
	public double getVY() {
		return vy;
	}

	/**
	 * Moves the x and y coordinates by incrementing them based on the x-velocity and y-velocity
	 */
	public void act() {
		double x1 = x;
		double y1 = y;
		
		
		x1 += vx;
		y1 += vy;
		
		setX(x1);
		setY(y1);
	}
	
	/**
	 * Gets the diameter of the golf ball
	 * @return the diameter of the golf ball
	 */
	public double getDiameter() {
		return diameter;
	}


}
