package gameElements;

import processing.core.PApplet;
import processing.core.PImage;

public class Coin {

	private int x, y;
	
	public Coin (int x1, int y1) {
		x = x1;
		y = y1;
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
		PImage img = new PImage();
		img = p.loadImage("images/coin.gif");
		img.resize(20, 20);
		p.image(img, x, y);
	}
		
}
