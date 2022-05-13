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
	private double x,y;
	
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
		Line l = new Line(ball.getX(), ball.getY(), mouseX, mouseY);
		l.draw(this);
	}
	
	public void mouseReleased() {
		
		ArrayList<Point> points = new ArrayList<Point>();

		x = mouseX;
		y = mouseY;
		Line l = new Line(ball.getX(), ball.getY(), x, y);
		l.draw(this);

//		double dist = ball.getDistance(ball.getX(), ball.getY(), x, y);
//		for (int i = 0; i < dist * 1.5/10; i++) {
//			ball.setX(ball.getX() - )
//		}
		
		
		double dist = ball.getDistance(ball.getX(), ball.getY(), x, y);
		double x_diff = (double)(ball.getX() - x)/(dist * 1.5 /10);
		double y_diff = (double)(ball.getY() - y)/(dist * 1.5/10);
		boolean check = false; 
		for (int i = 0; i < dist * 1.5/10; i++) {
			if (!ball.bounce(this, x_diff, y_diff)) {
				ball.setX((int)(ball.getX() + x_diff));
				ball.setY((int)(ball.getY() + y_diff));
			}
			
			
//			if (check == false && ball.bounce(this) == 1) {
//				y_diff *= -1;
//				check = true;
//			}
//			
//			if (check == false && ball.bounce(this) == 2) {
//				ball.setX((int)(ball.getX() + x_diff));
//				x_diff *= -1;
//				check = true;
//			}	
//			if (check == false && ball.bounce(this) == 3) {
//				ball.setX((int)(ball.getX() + x_diff));
//				ball.setY((int)(ball.getY() + y_diff));
//				y_diff *= -1;
//				x_diff *= -1;
//				check = true;
//			}
		}
		
		
		
		
		/*
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
		*/
//		int dist = ball.getDistance(ball.getX(), ball.getY(), x, y);
//		if (dist >= 50) {
//			ball.setVX(4);
//			ball.setVY(4);
//		} else {
//			ball.setVX(2);
//		}
		
		
	}
	
	public void mouseClicked() {
		if(mouseX <= 100) {
			this.frameResized(400, 400);
		}
	}
	
	
//	public void mouseReleased() {
//		released = true;
//	}
	

	public void switchScreen(int i) {
		switchScreen = i;
	}


}
