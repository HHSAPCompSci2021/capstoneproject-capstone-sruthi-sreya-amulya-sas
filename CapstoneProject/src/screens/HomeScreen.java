package screens;

import processing.core.PApplet;
import processing.core.PImage;

public class HomeScreen {
	
	public void draw(PApplet marker) {
		PImage img = new PImage();
		img = marker.loadImage("images/homescreen.gif");
		img.resize(600, 600);
		marker.image(img, 0, 0);
	}
}
