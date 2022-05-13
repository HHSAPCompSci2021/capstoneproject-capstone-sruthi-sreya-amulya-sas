package gameElements;


import ameduri.shapes.Circle;
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
	
	public void bounce(PApplet surface) {
		System.out.println("intersected");
		Line l = new Line(50, 50, 150, 50); // right
		Line l2 = new Line(150, 50, 150, 150); // down
		Line l3 = new Line(150, 150, 300, 150); // right
		Line l4 = new Line(300, 150, 300, 250); // down
		Line l5 = new Line(300, 250, 50, 250); // left
		Line l6 = new Line(50, 250, 50, 50); // up
		
		double min, max;

		if (l.intersects(c)) {
			min = 2;
			max = 5;
			vx = (min + (int)(Math.random() * ((max - min) + 1)));
			vy = -1*(min + (int)(Math.random() * ((max - min) + 1)));
		}
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
	
	public int getDistance(int x1, int y1, int x2, int y2) {
		int a = Math.abs(x1 - x2) + 1;
		int b = Math.abs(y1 - y2) + 1;
		double c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
		return (int) c;
	}
}
