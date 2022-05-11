import java.awt.event.KeyEvent;

import gameElements.*;
import processing.core.PApplet;
import processing.event.MouseEvent;
import screens.*;

public class DrawingSurface extends PApplet {

	private LevelOne l1;
	private LevelTwo l2;
	private LevelThree l3;
	private LevelFour l4;
	private LevelFive l5;
	private LevelSix l6;
	private GolfBall ball;
	private Instructions rules;

	
	public DrawingSurface() {
		l1 = new LevelOne();
		l2 = new LevelTwo();
		l3 = new LevelThree();
		l4 = new LevelFour();
		l5 = new LevelFive();
		l6 = new LevelSix();
		ball = new GolfBall();
		rules = new Instructions();
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

		rules.draw(this);
		l1.draw(this);

	}
	
	public void mouseDragged() {
		ball.move(mouseX, mouseY);
		ball.setX(mouseX);
		ball.setY(mouseY);
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
