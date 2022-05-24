package gameElements;

import java.util.ArrayList;


import ameduri.shapes.Circle;
import ameduri.shapes.Line;
import ameduri.shapes.Rectangle;
import core.DrawingSurface;
import processing.core.PApplet;
import screens.LevelFive;
import screens.LevelFour;
import screens.LevelOne;
import screens.LevelSix;
import screens.LevelThree;
import screens.LevelTwo;

public class GolfBall{

	private double x, y, diameter;
	private double vx, vy;
	private Circle c;
	private float r,g,b;

//	private DrawingSurface surface;
//	private PImage img;
//	private Circle c;

	/**
	 * Assigns values to the x and y coordinates of the golf ball and sets the
	 * diameter of the golf ball
	 */
	public GolfBall() {
//		this.surface = surface;
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
//		img = surface.loadImage("images/golfball.gif");
//		img.resize(20, 20);
//		surface.image(img, 250, 220);
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
	public boolean bounce(double x_diff, double y_diff, DrawingSurface surface) {
		Line left = new Line(c.getX(), c.getY(), c.getX(), c.getY()+diameter);
		Line right = new Line(c.getX()+diameter, c.getY(), c.getX()+diameter, c.getY()+diameter);
		Line up = new Line(c.getX(), c.getY(), c.getX()+diameter, c.getY());
		Line down = new Line(c.getX(), c.getY()+diameter, c.getX()+diameter, c.getY()+diameter);
		
		
		if (surface.getScreen() == 2) {
			LevelOne l1 = new LevelOne();
			ArrayList<Line> lines = l1.getLines();
			for (Line l : lines) {
				if (l.intersects(left) || l.intersects(right) || l.intersects(up) || l.intersects(down)) {
					if (l.getX() == l.getX2()) {
						vx = -vx;
						act();
					} else if (l.getY() == l.getY2()) {
						vy = -vy;
						act();
					}
					return true;
				}
			}
		} else if (surface.getScreen() == 3) {
			LevelTwo l2 = new LevelTwo();
			ArrayList<Line> lines = l2.getLines();
			for (Line l : lines) {
				if (l.intersects(left) || l.intersects(right) || l.intersects(up) || l.intersects(down)) {
					return true;
				}
			}
		} else if (surface.getScreen() == 4) {
			LevelThree l3 = new LevelThree();
			ArrayList<Line> lines = l3.getLines();
			for (Line l : lines) {
				if (l.intersects(left) || l.intersects(right) || l.intersects(up) || l.intersects(down)) {
					return true;
				}
			}
		} else if (surface.getScreen() == 5) {
			LevelFour l4 = new LevelFour();
			ArrayList<Line> lines = l4.getLines();
			for (Line l : lines) {
				if (l.intersects(left) || l.intersects(right) || l.intersects(up) || l.intersects(down)) {
					return true;
				}
			}
		} else if (surface.getScreen() == 6) {
			LevelFive l5 = new LevelFive();
			ArrayList<Line> lines = l5.getLines();
			for (Line l : lines) {
				if (l.intersects(left) || l.intersects(right) || l.intersects(up) || l.intersects(down)) {
					return true;
				}
			}
		} else if (surface.getScreen() == 7) {
			LevelSix l6 = new LevelSix();
			ArrayList<Line> lines = l6.getLines();
			for (Line l : lines) {
				if (l.intersects(left) || l.intersects(right) || l.intersects(up) || l.intersects(down)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean bounce1(double x_diff, double y_diff) {

		/*
		 * Line invis1= new Line(50, 50, 150, 50); // right Line invis2 = new Line(150,
		 * 50, 150, 150); // down Line invis3 = new Line(150, 150, 300, 150); // right
		 * Line invis4 = new Line(300, 150, 300, 250); // down Line invis5 = new
		 * Line(300, 250, 50, 250); // left Line invis6 = new Line(50, 250, 50, 50); //
		 * up
		 */

		Rectangle r = new Rectangle(50, 50, 100, 0); // right
		Rectangle r2 = new Rectangle(150, 50, 0, 100); // down
		Rectangle r3 = new Rectangle(150, 150, 150, 0); // right
		Rectangle r4 = new Rectangle(300, 150, 0, 100); // down
		Rectangle r5 = new Rectangle(50, 250, 250, 0); // left
		Rectangle r6 = new Rectangle(50, 50, 0, 200); // up
		Rectangle temp = new Rectangle(x, y, diameter, diameter);

//		if(temp.getX() - 50 <= )
		if (r.intersects(temp)) {
			System.out.println("l");

			this.setY((int) (50 + y_diff));
			this.setX((int) (getX() + x_diff));
			return true;

		}
		if (r2.intersects(temp)) {
			System.out.println("l2");
//			this.move((int)(150 + x_diff), (int)(getY() + y_diff));

			this.setY((int) (getY() + y_diff));
			this.setX((int) (150 + x_diff));
			return true;

		}
		if (r3.intersects(temp)) {
			vx -= -0.2;
			vy += -0.2;
			System.out.println("l3");
			this.setY((int) (150 + y_diff));
			this.setX((int) (getX() + x_diff));
			return true;

		}
		if (r4.intersects(temp)) {
			System.out.println("l4");
			this.setX((int) (300 + x_diff));
			this.setY((int) (getY() + y_diff));
			return true;
		}
		if (r5.intersects(temp)) {
			System.out.println("l5");
//			this.setX((int)(250 + x_diff));
			this.setX((int) (100 - x_diff));

//			System.out.println(getX() - 50 - x_diff);

			this.setY((int) (getY() + y_diff));
			if (y_diff < 0)
				this.setY((int) (getY() + y_diff));
			else
				this.setY((int) (getY() - y_diff));

//			System.out.println(y_diff);
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

//		marker.rect(100,150,20,20);
//		marker.rect(200, 200, 20, 20);
//		marker.rect(x, y, diameter, diameter);

		if (temp.intersects(r) || temp2.intersects(r)) {
//			System.out.println("coin");
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
//			System.out.println("coin");
			return true;
		} else {
			return false;

		}

	}

//	public boolean bounceOff() {
//		
//	}
	
//	public void intersects(Line l) {
//		l.inter
//	}
	
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
	
	public void accelerate(double vx, double vy) {
		this.vx += vx;
		this.vy += vy;
	}
	
	public void setVX(double x) {
		this.vx = x;
	}

	public void setVY(double y) {
		this.vy = y;
	}

	public void act() {
		double x1 = x;
		double y1 = y;
		
		
		x1 += vx;
		y1 += vy;
		
		setX(x1);
		setY(y1);
	}


}
