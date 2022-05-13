package gameElements;

import java.awt.Rectangle;

import ameduri.shapes.Circle;
import processing.core.PApplet;
import processing.core.PImage;

public class Coin {

	
	private int x, y, diameter;
	
	public Coin (int x1, int y1) {
		x = x1;
		y = y1;
		diameter = 10;
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
	
	public void draw(PApplet p) {
		
		Circle coin = new Circle(x, y, diameter);
		coin.draw(p);
	}
	

		
}
