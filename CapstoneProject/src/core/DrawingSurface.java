package core;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.xml.soap.Text;

import java.awt.Toolkit;

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
	private GolfBall ball2;
	private GolfBall ball3;
	private GolfBall ball4;
	private GolfBall ball5;
	private GolfBall ball6;
	private Coin coin1;
	private Coin coin2;
	private Timer time;
	private Instructions rules;
	private HomeScreen homeScreen;
	private int switchScreen;
	private double x,y;
	
	private String level;
	private int coinCount;
	
//	private boolean released;
	
	/**
	 * Creates new Levels, GolfBalls, Coins, Instructions, and a HomeScreen
	 */
	public DrawingSurface() {
		l1 = new LevelOne();
		l2 = new LevelTwo();
		l3 = new LevelThree();
		l4 = new LevelFour();
		l5 = new LevelFive();
		l6 = new LevelSix();
		ball = new GolfBall();
		ball2 = new GolfBall();
		ball3 = new GolfBall();
		ball4 = new GolfBall();
		ball5 = new GolfBall();
		ball6 = new GolfBall();
		coin1 = new Coin(100,150);
		coin2 = new Coin(200,200);
		rules = new Instructions(this);
		homeScreen = new HomeScreen();
		switchScreen = 0;
		
		level = "";
		coinCount = 0;
		
//		released = false;
	}
	
	/** The statements in the setup() function 
	execute once when the program begins**/
	public void setup() {
		homeScreen.draw(this);
		
		time = new Timer(0);
	}
	
	/**
	 * This method draws the different screens based on where the user is in the game. When the user begins 
	 * the game, there is a home screen and instructions following it. When they finish a level, the screen 
	 * switches to the next level.
	 */
	public void draw() { 
				
		
		if (switchScreen == 0) {
			homeScreen.draw(this);
		} else if (switchScreen == 1) {
			background(255);
			rules.draw();
		} else if (switchScreen == 2) {
			background(255);
			textSize(50);
			fill(0);
			level = "Level 1";
			text(level, 150, 50);
			l1.draw(this);
			ball.draw(this);
			
			coin1.draw(this);
			coin2.draw(this);
			
			
			
			if(ball.coinIntersects()){
				coinCount++;
				fill(0);
				text("You hit coin!", 200, 400);
				textSize(10);
//				System.out.print("hi");
			}
//				fill(0);
//				text("you hit ball", 100, 100);
//				textSize(20);
			if (ball.goal()) {
				textSize(50);
				fill(0);
				text("Good job!", 150, 250);
				textSize(20);
				text("Click enter to go to the next level!", 150, 300);
			}
		} else if (switchScreen == 3) {
			
			background(255);
			textSize(50);
			fill(0);
			level = "Level 2";
			text(level, 150, 50);
			l2.draw(this);
			ball2.draw(this);
			
			fill(255,255,0);
			coin1.draw(this);
//			fill(255,255,0);
			coin2.draw(this);
			if(ball2.coinIntersects()){
				coinCount++;
			}
			if (ball2.goal()) {
				textSize(50);
				fill(0);
				text("Good job!", 150, 250);
				textSize(20);
				text("Click enter to go to the next level!", 150, 300);
			}
			
		}
		else if (switchScreen == 4) {
			background(255);
			textSize(50);
			fill(0);
			level = "Level 3";
			text(level, 150, 50);
			l3.draw(this);
			
			
			textSize(15);
			if (time.countUp(this) <= 5) {
				fill(0);
				text(time.getTime(), 20, 20);
			} else {
				fill(0);
				text("5", 20, 20);
			}
			
			ball3.draw(this);
			fill(255,255,0);
			coin1.draw(this);
//			fill(255,255,0);
			coin2.draw(this);
			if(ball3.coinIntersects()){
				coinCount++;
			}
			if (ball3.goal()) {
				textSize(50);
				fill(0);
				text("Good job!", 150, 250);
				textSize(20);
				text("Click enter to go to the next level!!", 150, 300);
			}
		}else if (switchScreen == 5) {
			background(255);
			textSize(50);
			fill(0);
			level = "Level 4";
			text(level, 150, 50);
			l4.draw(this);
			ball4.draw(this);
			fill(255,255,0);
			coin1.draw(this);
//			fill(255,255,0);
			coin2.draw(this);
			if(ball4.coinIntersects()){
				coinCount++;
			}
			if (ball4.goal()) {
				textSize(50);
				fill(0);
				text("Good job!", 150, 250);
				textSize(20);
				text("Click enter to go to the next level!", 150, 300);
			}
		}else if (switchScreen == 6) {
			background(255);
			textSize(50);
			fill(0);
			level = "Level 5";
			text(level, 150, 50);
			l5.draw(this);
			ball5.draw(this);
			fill(255,255,0);
			coin1.draw(this);
//			fill(255,255,0);
			coin2.draw(this);
			if(ball5.coinIntersects()){
				coinCount++;
			}
			if (ball5.goal()) {
				textSize(50);
				fill(0);
				text("Good job!", 150, 250);
				textSize(20);
				text("Click enter to go to the next level!", 150, 300);
			}
		}else if (switchScreen == 7) {
			background(255);
			textSize(50);
			fill(0);
			level = "Level 6";
			text(level, 150, 50);
			l6.draw(this);
			ball6.draw(this);
			fill(255,255,0);
			coin1.draw(this);
//			fill(255,255,0);
			coin2.draw(this);
			if(ball6.coinIntersects()){
				coinCount++;
			}
			if (ball6.goal()) {
				textSize(50);
				fill(0);
				text("CONGRATS!!", 150, 250);
				textSize(20);
				text("YOU HAVE COMPLETED ALL THE LEVELS!!", 150, 300);
			}
			
		}
		
		if (keyCode == KeyEvent.VK_ENTER) {
			switchScreen++;
			keyCode = 0;
		}
		
		fill(0);
		textSize(20);
		text("Coins: " + Integer.toString(coinCount), 50, 40);
		
	}
	
	/**
	 * This method draws a line to help the user aim the golfball in a certain direction.
	 */
	public void mouseDragged() {
		if (level.equals("Level 1")) {
			Line l = new Line(ball.getX(), ball.getY(), mouseX, mouseY);
			l.draw(this);
		}
		else if (level.equals("Level 2")) {
			Line l = new Line(ball2.getX(), ball2.getY(), mouseX, mouseY);
			l.draw(this);
		}
		else if (level.equals("Level 3")) {
			Line l = new Line(ball3.getX(), ball3.getY(), mouseX, mouseY);
			l.draw(this);
		}
		else if (level.equals("Level 4")) {
			Line l = new Line(ball4.getX(), ball4.getY(), mouseX, mouseY);
			l.draw(this);
		}
		else if (level.equals("Level 5")) {
			Line l = new Line(ball5.getX(), ball5.getY(), mouseX, mouseY);
			l.draw(this);
		}
		else if (level.equals("Level 6")) {
			Line l = new Line(ball6.getX(), ball6.getY(), mouseX, mouseY);
			l.draw(this);
		}

	}
	
	/**
	 * This method records the x and y coordinate of the cursor when the mouse is released in order to make the 
	 * golf ball move in that direction. Also, when the ball hits the boundary of the golf course, it bounces off. 
	 */
	public void mouseReleased() {
		
		ArrayList<Point> points = new ArrayList<Point>();

		
		
		if (level.equals("Level 1")) {
			x = mouseX;
			y = mouseY;
			Line l = new Line(ball.getX(), ball.getY(), x, y);
			l.draw(this);
			
			double dist = ball.getDistance(ball.getX(), ball.getY(), x, y);
			double x_diff = (double)(ball.getX() - x)/(dist * 1.5 /10);
			double y_diff = (double)(ball.getY() - y)/(dist * 1.5/10);
			boolean check = false; 
			for (int i = 0; i < dist * 1.5/10; i++) {
				if (!ball.bounce(x_diff, y_diff)) {
					ball.setX((int)(ball.getX() + x_diff));
					ball.setY((int)(ball.getY() + y_diff));
					ball.goal();
				}
			}
		}
		else if (level.equals("Level 2")) {
			x = mouseX;
			y = mouseY;
			Line l = new Line(ball2.getX(), ball2.getY(), x, y);
			l.draw(this);
			
			double dist = ball2.getDistance(ball2.getX(), ball2.getY(), x, y);
			double x_diff = (double)(ball2.getX() - x)/(dist * 1.5 /10);
			double y_diff = (double)(ball2.getY() - y)/(dist * 1.5/10);
			boolean check = false; 
			for (int i = 0; i < dist * 1.5/10; i++) {
				if (!ball2.bounce(x_diff, y_diff)) {
					ball2.setX((int)(ball2.getX() + x_diff));
					ball2.setY((int)(ball2.getY() + y_diff));
					ball2.goal();
				}
			}
		}
		else if (level.equals("Level 3")) {
			x = mouseX;
			y = mouseY;
			Line l = new Line(ball3.getX(), ball3.getY(), x, y);
			l.draw(this);
			
			double dist = ball3.getDistance(ball3.getX(), ball3.getY(), x, y);
			double x_diff = (double)(ball3.getX() - x)/(dist * 1.5 /10);
			double y_diff = (double)(ball3.getY() - y)/(dist * 1.5/10);
			boolean check = false; 
			for (int i = 0; i < dist * 1.5/10; i++) {
				if (!ball3.bounce(x_diff, y_diff)) {
					ball3.setX((int)(ball3.getX() + x_diff));
					ball3.setY((int)(ball3.getY() + y_diff));
					ball3.goal();
				}
			}
		}
		else if (level.equals("Level 4")) {
			x = mouseX;
			y = mouseY;
			Line l = new Line(ball4.getX(), ball4.getY(), x, y);
			l.draw(this);
			
			double dist = ball4.getDistance(ball4.getX(), ball4.getY(), x, y);
			double x_diff = (double)(ball4.getX() - x)/(dist * 1.5 /10);
			double y_diff = (double)(ball4.getY() - y)/(dist * 1.5/10);
			boolean check = false; 
			for (int i = 0; i < dist * 1.5/10; i++) {
				if (!ball4.bounce(x_diff, y_diff)) {
					ball4.setX((int)(ball4.getX() + x_diff));
					ball4.setY((int)(ball4.getY() + y_diff));
					ball4.goal();
				}
			}
		}
		else if (level.equals("Level 5")) {
			x = mouseX;
			y = mouseY;
			Line l = new Line(ball5.getX(), ball5.getY(), x, y);
			l.draw(this);
			
			double dist = ball5.getDistance(ball5.getX(), ball5.getY(), x, y);
			double x_diff = (double)(ball5.getX() - x)/(dist * 1.5 /10);
			double y_diff = (double)(ball5.getY() - y)/(dist * 1.5/10);
			boolean check = false; 
			for (int i = 0; i < dist * 1.5/10; i++) {
				if (!ball5.bounce(x_diff, y_diff)) {
					ball5.setX((int)(ball5.getX() + x_diff));
					ball5.setY((int)(ball5.getY() + y_diff));
					ball5.goal();
				}
			}
		}
		else if (level.equals("Level 6")) {
			x = mouseX;
			y = mouseY;
			Line l = new Line(ball6.getX(), ball6.getY(), x, y);
			l.draw(this);
			
			double dist = ball6.getDistance(ball6.getX(), ball6.getY(), x, y);
			double x_diff = (double)(ball6.getX() - x)/(dist * 1.5 /10);
			double y_diff = (double)(ball6.getY() - y)/(dist * 1.5/10);
			boolean check = false; 
			for (int i = 0; i < dist * 1.5/10; i++) {
				if (!ball6.bounce(x_diff, y_diff)) {
					ball6.setX((int)(ball6.getX() + x_diff));
					ball6.setY((int)(ball6.getY() + y_diff));
					ball6.goal();
				}
			}
		}

//		double dist = ball.getDistance(ball.getX(), ball.getY(), x, y);
//		for (int i = 0; i < dist * 1.5/10; i++) {
//			ball.setX(ball.getX() - )
//		}
		
		
		double dist = ball.getDistance(ball.getX(), ball.getY(), x, y);
		double x_diff = (double)(ball.getX() - x)/(dist * 1.5 /10);
		double y_diff = (double)(ball.getY() - y)/(dist * 1.5/10);
		boolean check = false; 
		for (int i = 0; i < dist * 1.5/10; i++) {
			if (!ball.bounce(x_diff, y_diff)) {
				ball.setX((int)(ball.getX() + x_diff));
				ball.setY((int)(ball.getY() + y_diff));
				ball.goal();
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
	
	
//	public void mouseReleased() {
//		released = true;
//	}
	

}
