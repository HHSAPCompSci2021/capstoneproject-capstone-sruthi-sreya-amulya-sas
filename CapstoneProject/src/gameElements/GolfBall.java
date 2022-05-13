package gameElements;

import core.DrawingSurface;
import processing.core.PApplet;
import processing.core.PImage;

public class GolfBall {
	
	private int x, y;
	private DrawingSurface surface;
	private PImage img;

	public GolfBall(DrawingSurface surface) {
		this.surface = surface;
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
	
	public void draw() {
		img = surface.loadImage("images/golfball.gif");
		img.resize(20, 20);
		surface.image(img, 250, 220);
	}
	
	public void move(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
}
