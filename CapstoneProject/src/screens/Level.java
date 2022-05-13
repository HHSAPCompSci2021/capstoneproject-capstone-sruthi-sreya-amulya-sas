package screens;

import java.util.ArrayList;

import gameElements.Coin;
import gameElements.Ghost;
import processing.core.PApplet;

public abstract class Level {
	
	private ArrayList<Coin> coins;
	
	/**
	 * Instantiates new Coin ArrayList
	 */
	public Level() {
		coins = new ArrayList<Coin>();
	}
	
	/**
	 * 
	 * @param marker PApplet object used to draw golf course
	 */
	public abstract void draw(PApplet marker);
	
	/**
	 * Zooms into the golf course
	 */
	public abstract void zoomIn();
	
	/**
	 * Zooms out to see the birds-eye view of the golf course
	 */
	public abstract void zoomOut();
	
	
}
