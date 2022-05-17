package gameElements;


import java.awt.Point;
//import java.awt.Rectangle;
import java.util.ArrayList;

import ameduri.shapes.Circle;
import ameduri.shapes.Line;
import ameduri.shapes.Rectangle;

import processing.core.PApplet;

public class GolfBall {
	
	private int x, y, diameter;
	private double vx, vy;
	private Circle c;

//	private DrawingSurface surface;
//	private PImage img;
//	private Circle c;

	/**
	 * Assigns values to the x and y coordinates of the golf ball and sets the diameter of the golf ball
	 */
	public GolfBall() {
//		this.surface = surface;
		x = 260;
		y = 220;
		diameter = 15;
	}
	
	/**
	 * Gets the x coordinate of the golf ball
	 * @return the x coordinate of the golf ball
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Gets the y coordinate of the golf ball
	 * @return the y coordinate of the golf ball
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Sets the x coordinate of the golf ball to the new x value passed in as a parameter
	 * @param x new x coordinate of the golf ball
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * Sets the y coordinate of the golf ball to the new y value passed in as a parameter
	 * @param y new y coordinate of the golf ball
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	public void setVX(int x) {
		this.vx = x;
	}
	
	public void setVY(int y) {
		this.vy = y;
	}
	/**
	 * Draws the golf ball at (x,y)
	 * @param p PApplet object used to draw the golf ball
	 */
	public void draw(PApplet marker) {
//		img = surface.loadImage("images/golfball.gif");
//		img.resize(20, 20);
//		surface.image(img, 250, 220);
		c = new Circle(x, y, diameter);
		
		c.draw(marker);
	}
	
	/**
	 * Checks whether or not the golf ball bumps into a boundary, and if it does, it bounces off the boundary
	 * @param x_diff the difference in y by which the y coordinate of the golf ball is changing
	 * @param y_diff the difference in y by which the y coordinate of the golf ball is changing
	 * @return true or false depending on whether or not the golf ball intersects a boundary line
	 */
	public boolean bounce(double x_diff, double y_diff) {
		/*Line invis1= new Line(50, 50, 150, 50); // right
		Line invis2 = new Line(150, 50, 150, 150); // down
		Line invis3 = new Line(150, 150, 300, 150); // right
		Line invis4 = new Line(300, 150, 300, 250); // down
		Line invis5 = new Line(300, 250, 50, 250); // left
		Line invis6 = new Line(50, 250, 50, 50); // up
		*/
		

		Rectangle r = new Rectangle(50, 50, 100, 0); //right
		Rectangle r2 = new Rectangle(150, 50, 0, 100); // down
		Rectangle r3 = new Rectangle(150, 150, 150, 0); // right
		Rectangle r4 = new Rectangle(300, 150, 0, 100); // down
		Rectangle r5 = new Rectangle(50, 250, 250, 0); // left
		Rectangle r6 = new Rectangle(50, 50, 0, 200); // up
		Rectangle temp = new Rectangle(x, y, diameter,diameter);
		
		if (r.intersects(temp)) {
			System.out.println("l");
			
			
			this.setY((int)(50 + y_diff));
			this.setX((int)(getX() + x_diff));
			return true;

		}
		if (r2.intersects(temp)) {
			System.out.println("l2");
//			this.move((int)(150 + x_diff), (int)(getY() + y_diff));
			
			this.setY((int)(getY() + y_diff));
			this.setX((int)(150 + x_diff));
//			System.out.println(("is " + this.getX()));
			
//			System.out.println((int)(150 + x_diff));
//			System.out.println(x_diff);

			
//			this.setX((int)(30));
//			this.setY((int)(30));

			
			return true;

		}
		if (r3.intersects(temp)) {
				vx -= -0.2;
				vy += -0.2;
			System.out.println("l3");
			this.setY((int)(150 + y_diff));
			this.setX((int)(getX() + x_diff));
			return true;

		}
		if (r4.intersects(temp)) {
			System.out.println("l4");
			this.setX((int)(300 + x_diff));
			this.setY((int)(getY() + y_diff));
			return true;
		}
		if (r5.intersects(temp)) {
			System.out.println("l5");
//			this.setX((int)(250 + x_diff));
			this.setX((int)(100 - x_diff));
			
			System.out.println(getX()-50 - x_diff);

			this.setY((int)(getY() + y_diff));
			if(y_diff < 0)
				this.setY((int)(getY() + y_diff));
			else 
				this.setY((int)(getY() - y_diff));
			
			System.out.println(y_diff);
			return true;
		}
		if (r6.intersects(temp)) {
			this.setX((int)(50 + x_diff));
			this.setY((int)(getY() + y_diff));
			return true;
		}
		return false; 
	}
	
	/**
	 * Calculates the distance between two points
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
	 * @return true or false depending on if the golf ball intersected the hole
	 */
	public boolean goal() {
		Rectangle temp = new Rectangle(90, 90, 10, 10);
		Rectangle circle = new Rectangle(x,y,diameter,diameter);
		

		if(temp.intersects(circle)) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Determines if the golf ball hit a coin
	 * @return true or false depending on if the golf ball hit a coin
	 */
	public boolean coinIntersects() {
		Rectangle temp = new Rectangle(100,150,20,20);
		Rectangle r = new Rectangle(x,y, diameter, diameter);
		Rectangle temp2 = new Rectangle(200,200, 20, 20); 
		
//		marker.rect(100,150,20,20);
//		marker.rect(200, 200, 20, 20);
//		marker.rect(x, y, diameter, diameter);
		
		
		if(temp.intersects(r) || temp2.intersects(r)) {
//			System.out.println("coin");
			return true;
		} else {
		return false;
		
		}
	}
	
//	public boolean bounceOff() {
//		
//	}
	
}
