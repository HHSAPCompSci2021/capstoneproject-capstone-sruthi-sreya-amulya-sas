import java.awt.event.KeyEvent;

import processing.awt.PSurfaceAWT;
import processing.core.PApplet;
import processing.event.MouseEvent;

public class DrawingSurface extends PApplet {

	

	
	public DrawingSurface() {
	

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
		background(255);   // Clear the screen with a white background
		
		textSize(12);
		fill(0);
			
	}
	
	

	public void mouseWheel(MouseEvent event) {
		  
	}
	
	public void keyPressed() {

		if (keyCode == KeyEvent.VK_UP) {
			
		} 
		else if (keyCode == KeyEvent.VK_DOWN) {
			
		} 
		else if (keyCode == KeyEvent.VK_LEFT) {
			
		} 
		else if (keyCode == KeyEvent.VK_RIGHT) {
			
		}
	}	
	
	public void mouseDragged() {
		
	}

}
