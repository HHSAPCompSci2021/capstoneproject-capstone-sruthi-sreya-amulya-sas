package screens;

import processing.core.PImage;
import core.DrawingSurface;

public class Instructions {
	
	private DrawingSurface surface;
	private PImage img;
	
	/**
	 * Instantiates new DrawingSurface and PImage objects
	 */
	public  Instructions(DrawingSurface surface) {
		this.surface = surface;
		img = new PImage();
	}
	
	/**
	 * Draws the home screen
	 */
	public void draw() {

		img = surface.loadImage("images/instructions.gif");
		img.resize(600, 600);
		surface.image(img, 0, 0);
		
	}
}
