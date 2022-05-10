package levels;

import java.util.ArrayList;

import gameElements.Coin;
import gameElements.Ghost;
import processing.core.PApplet;

public abstract class Level {
	
	private ArrayList<Coin> coins;
	
	public abstract void draw(PApplet marker);
	
	
}
