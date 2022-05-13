package screens;

import core.DrawingSurface;
import processing.core.PApplet;
import processing.core.PImage;

public class HomeScreen {
	
	private PImage img;
	
	/**
	 * Instantiates new DrawingSurface and PImage objects
	 */
	public HomeScreen() {
		img = new PImage();
	}
	
	/**
	 * Draws the home screen
	 */
	public void draw(PApplet marker) {
		img = marker.loadImage("images/homescreen.gif");
		img.resize(600, 600);
		marker.image(img, 0, 0);
	}
}
