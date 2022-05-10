import java.awt.event.KeyEvent;

import gameElements.*;
import levels.*;
import processing.core.PApplet;
import processing.event.MouseEvent;

public class DrawingSurface extends PApplet {

	private LevelOne l1;
	private LevelTwo l2;
	private LevelThree l3;
	private LevelFour l4;
	private LevelFive l5;
	private LevelSix l6;
	private GolfBall ball;

	
	public DrawingSurface() {
		l1 = new LevelOne();
		l2 = new LevelTwo();
		l3 = new LevelThree();
		l4 = new LevelFour();
		l5 = new LevelFive();
		l6 = new LevelSix();
		ball = new GolfBall();
	}
	
	// The statements in the setup() function 
	// execute once when the program begins
	public void setup() {
		
	}
	
	// The statements in draw() are executed until the 
	// program is stopped. Each statement is executed in 
	// sequence and after the last line is read, the first 
	// line is executed again.
	public void draw() { 
		
		textSize(15);
		fill(0);
		
		background(255, 192, 203);
		text("Click the Space bar to start!", 150, 230);

		if (keyCode == KeyEvent.VK_SPACE) {
			background(0, 180, 0);
		} 
		textSize(12);
		fill(0);
		
		background(255, 192, 203);
		text("Instructions:\n 1. Press the \"START\" to start the game.\nThere will be two buttons to click, one is to start the game at level one"
				+ "\n and the other one is the instructions on how to play the game and the objectives."
				+ "\n2. Once the player starts, they will use the cursor to pull back the golf ball."
				+ "\n3. They will then release the ball in a direction that will aid them in getting the ball to where the hole is located."
				+ "\nBy using the zoom in and out button located in the bottom right corner you can zoom in and out to view the entire golf course and find where the hole is."
				+ "\n4.The player will have 7 chances to complete each level, and as the difficulty level increases, there will be more obstacles as well."
				+ "\n5.As you progress through the game, at level three ghosts will start roaming around. After five seconds of entering level three,"
				+ "\nand all the levels beyond, the screen will go dark, so be sure to look and see where the ghosts are when the screen goes black."
				+ "\n6:GOAL: Your goal is to make the ball in the hole regardless of the ghosts around starting from level 3."
				+ "\nIf you happen to hit a ghost, you will be sent to level 1, but first, it will ask if you want to pay 5 coins to continue playing from the level you are at."
				+ "\nWhile playing the game, aim for hitting coins while also getting the ball in the hole, because these coins can be used to set your personal high score for"
				+ "\nthe game as well as save yourself if you hit a ghost in level three."
				+ "\nIf you get lost or confused at any point in the game, there will be a navigation bar at the top right so that you can refer back to the instructions.\n"
				+ "", 20, 30);
		
		if (keyCode == KeyEvent.VK_ENTER) {
			background(0, 180, 0);
		} 
		
		l1.draw(this);

	}
	
	public void mouseDragged() {
		ball.setX(mouseX);
		ball.setY(mouseY);
		ball.move(mouseX, mouseY);
	}
	
	public void mouseClicked() {
		
	}

//	public void keyPressed() {
//
//		if (keyCode == KeyEvent.VK_UP) {
//			
//		} 
//		else if (keyCode == KeyEvent.VK_DOWN) {
//			
//		} 
//		else if (keyCode == KeyEvent.VK_LEFT) {
//			
//		} 
//		else if (keyCode == KeyEvent.VK_RIGHT) {
//			
//		}
//	}	
//	

}
