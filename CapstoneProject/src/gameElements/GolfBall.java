package gameElements;

import ameduri.shapes.Circle;
import core.DrawingSurface;
import processing.core.PApplet;
import processing.core.PImage;

public class GolfBall {
	
	private int x, y, diameter;
//	private DrawingSurface surface;
//	private PImage img;
//	private Circle c;

	public GolfBall() {
//		this.surface = surface;
		x = 260;
		y = 220;
		diameter = 15;
		
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
		Circle c = new Circle(x, y, diameter);
		c.draw(marker);
	}
	
	public void move(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
}
