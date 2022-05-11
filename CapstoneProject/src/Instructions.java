import java.awt.event.KeyEvent;

import processing.core.PApplet;
import processing.core.PImage;

public class Instructions {

	public  Instructions() {
		
	}
	
	public void draw(PApplet marker) {
//		marker.textSize(12);
//		marker.fill(0);
		PImage img = new PImage();
		img = marker.loadImage("images/instructions.gif");
		img.resize(600, 600);
		marker.image(img, 0, 0);
//		surface.background(255, 192, 203);
//		surface.text("Instructions:\n 1. Press the \"START\" to start the game.\nThere will be two buttons to click, one is to start the game at level one and the other one is the instructions on how to play the game and the objectives."
//				+ "\n2. Once the player starts, they will use the cursor to pull back the golf ball."
//				+ "\n3. They will then release the ball in a direction that will aid them in getting the ball to where the hole is located. By using the zoom in and out button located in the bottom right corner you can zoom in and out to view the entire golf course and find where the hole is."
//				+ "\n4.The player will have 7 chances to complete each level, and as the difficulty level increases, there will be more obstacles as well."
//				+ "\n5.As you progress through the game, at level three ghosts will start roaming around. After five seconds of entering level three, and all the levels beyond, the screen will go dark, so be sure to look and see where the ghosts are when the screen goes black."
//				+ "\n6:GOAL: Your goal is to make the ball in the hole regardless of the ghosts around starting from level 3."
//				+ "\nIf you happen to hit a ghost, you will be sent to level 1, but first, it will ask if you want to pay 5 coins to continue playing from the level you are at."
//				+ "\nWhile playing the game, aim for hitting coins while also getting the ball in the hole, because these coins can be used to set your personal high score for the game as well as save yourself if you hit a ghost in level three."
//				+ "\nIf you get lost or confused at any point in the game, there will be a navigation bar at the top right so that you can refer back to the instructions.\n"
//				+ "", 20, 30);
//		
//		
		
//		if (surface.keyCode == KeyEvent.VK_SPACE) {
//			surface.background(0, 180, 0);
//		} 
		
	}
}
