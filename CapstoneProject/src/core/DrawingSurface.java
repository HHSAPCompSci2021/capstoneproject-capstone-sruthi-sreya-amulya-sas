package core;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import ameduri.shapes.Line;
import gameElements.*;
import processing.core.PApplet;
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
	private HomeScreen homeScreen;
	private int switchScreen;
	private int x,y;
	
//	private boolean released;
	
	
	public DrawingSurface() {
		l1 = new LevelOne();
		l2 = new LevelTwo();
		l3 = new LevelThree();
		l4 = new LevelFour();
		l5 = new LevelFive();
		l6 = new LevelSix();
		ball = new GolfBall();
		rules = new Instructions(this);
		homeScreen = new HomeScreen();
		switchScreen = 0;
		
//		released = false;
	}
	
	// The statements in the setup() function 
	// execute once when the program begins
	public void setup() {
		homeScreen.draw(this);
	}
	
	
	public void draw() { 
		
		textSize(15);
		fill(0);
		

		
		if (switchScreen == 0) {
			homeScreen.draw(this);
		} else if (switchScreen == 1) {
			background(255);
			rules.draw();
		} else if (switchScreen == 2) {
			background(255);
			l1.draw(this);
			ball.draw(this);
		}
		
		if (keyCode == KeyEvent.VK_ENTER) {
			switchScreen++;
			keyCode = 0;
		}
		

	}
	
	public void mouseDragged() {
		
		ArrayList<Point> points = new ArrayList<Point>();
//		while(released == false) {
			x = mouseX;
			y = mouseY;
			points.add(new Point(x,y));
			Line l = new Line(ball.getX(), ball.getY(), x, y);
			l.draw(this);
//		}
		
		for (int i = 0; i < points.size(); i++) {
			ball.setX(points.get(i).x);
			ball.setY(points.get(i).y);
			ball.draw(this);
		}
//		int dist = ball.getDistance(ball.getX(), ball.getY(), x, y);
//		if (dist >= 50) {
//			ball.setVX(4);
//			ball.setVY(4);
//		} else {
//			ball.setVX(2);
//		}
		
		
	}
	
	
//	public void mouseReleased() {
//		released = true;
//	}
	

	public void switchScreen(int i) {
		switchScreen = i;
	}


}
