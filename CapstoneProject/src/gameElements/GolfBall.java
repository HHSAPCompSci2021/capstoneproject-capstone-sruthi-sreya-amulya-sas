package gameElements;


import java.awt.Point;
import java.util.ArrayList;

import ameduri.shapes.Circle;
import ameduri.shapes.Rectangle;
import ameduri.shapes.Line;
import processing.core.PApplet;

public class GolfBall {
	
	private int x, y, diameter;
	private double vx, vy;
	private Circle c;

//	private DrawingSurface surface;
//	private PImage img;
//	private Circle c;

	public GolfBall() {
//		this.surface = surface;
		x = 260;
		y = 220;
		diameter = 15;
		
		this.vx = 0;
		this.vy = 2;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void draw(PApplet marker) {
//		img = surface.loadImage("images/golfball.gif");
//		img.resize(20, 20);
//		surface.image(img, 250, 220);
		c = new Circle(x, y, diameter);
		c.draw(marker);
	}
	
	public void move(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public boolean bounce(PApplet surface, double x_diff, double y_diff) {
		Line l = new Line(50, 50, 150, 50); // right
		Line l2 = new Line(150, 50, 150, 150); // down
		Line l3 = new Line(150, 150, 300, 150); // right
		Line l4 = new Line(300, 150, 300, 250); // down
		Line l5 = new Line(300, 250, 50, 250); // left
		Line l6 = new Line(50, 250, 50, 50); // up
		
		Rectangle r = new Rectangle(50, 50, 100, 0);
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
			this.setY((int)(getY() + y_diff));
			this.setX((int)(150 + x_diff));
			return true;

		}
		if (r3.intersects(temp)) {
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
			this.setX((int)(250 + x_diff));
			this.setY((int)(getY() + y_diff));
			return true;
		}
		if (r6.intersects(temp)) {
			this.setX((int)(50 + x_diff));
			this.setY((int)(getY() + y_diff));
			return true;
		}
		return false; 
	}
	
	public void setVX(double x) {
		vx = x;
	}
	
	public void act() {
		double x = c.getX();
		double y = c.getY();
		
		
		x += vx;
		y += vy;
		
		c.setPoint(x,y);
	}
	

	public void setVY(double y) {
		vy = y;
	}
	
	public int getDistance(double x1, double y1, double x2, double y2) {
		double a = Math.abs(x1 - x2) + 1;
		double b = Math.abs(y1 - y2) + 1;
		double c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
		return (int) c;
	}
}
