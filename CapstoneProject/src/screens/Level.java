package screens;

import java.util.ArrayList;

import gameElements.Coin;
import gameElements.Ghost;
import processing.core.PApplet;

public abstract class Level {
	
	private ArrayList<Coin> coins;
	
	public Level() {
		coins = new ArrayList<Coin>();
	}
	
	public abstract void draw(PApplet marker);
	
	public abstract void zoomIn();
	
	public abstract void zoomOut();
	
	
}
