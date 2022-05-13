package screens;

import core.DrawingSurface;
import processing.core.PApplet;
import processing.core.PImage;

public class HomeScreen {
	
	private DrawingSurface surface;
	private PImage img;
	
	public HomeScreen() {
		surface = new DrawingSurface();
		img = new PImage();
	}
	
	public void draw() {
		img = surface.loadImage("images/homescreen.gif");
		img.resize(600, 600);
		surface.image(img, 0, 0);
	}
}
