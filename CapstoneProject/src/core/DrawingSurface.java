package core;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import ameduri.shapes.Line;
import ameduri.shapes.Rectangle;
import gameElements.*;
import processing.core.PApplet;
import processing.core.PImage;
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
	private Timer time3;
	private Timer time4;
	private Timer time5;
	private Timer time6;
	private Instructions rules;
	private HomeScreen homeScreen;
	private int switchScreen;
	private double x,y;
	
	private PImage zoomPicture;
	private PImage popup;
	
	private Ghost g1;
	private Ghost g2;
	
	private String level;
	private int coinCount;
	
	private int zoom;
	private boolean intersects;
	
	private Rectangle rect;
	
	private double dist;
	
	private String highscore;
		
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
		zoomPicture = new PImage();
		
		g1 = new Ghost(this);
		g2 = new Ghost(this);
		
		rect = new Rectangle(0,0,1200,1200);
		
		intersects = false;
		
		popup = new PImage();
		
		dist = 0;
		highscore = "";
	}
	
	/** The statements in the setup() function 
	execute once when the program begins**/
	public void setup() {
		homeScreen.draw(this);
		rectMode(CENTER);
		time3 = new Timer(0);
		time4 = new Timer(0);
		time5 = new Timer(0);
		time6 = new Timer(0);

	}
	
	/**
	 * This method draws the different screens based on where the user is in the game. When the user begins 
	 * the game, there is a home screen and instructions following it. When they finish a level, the screen 
	 * switches to the next level.
	 */
	public void draw() { 
		
		try {
			readFile("images/highscore.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		int high = Integer.parseInt(highscore);
		if (coinCount > high) {
			highscore = highscore.replace(Integer.toString(high), Integer.toString(coinCount));
			try {
				writeFile(highscore, "images/highscore.txt");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if (switchScreen == 0) {
			homeScreen.draw(this);
			scale(zoom);
		} else if (switchScreen == 1) {
			background(255);
			rules.draw();
		} else if (switchScreen == 2) {// LEVEL 1 --------------------------------------
			background(255);
			
			textSize(50);
			fill(0);
			level = "Level 1";
			text(level, 150, 50);
			l1.draw(this);
			ball.draw(this);
			
			coin1.draw(this);
			coin2.draw(this);
			
			if (ball.goal()) {
				textSize(50);
				fill(0);
				text("Good job!", 150, 250);
				textSize(20);
				text("Click enter to go to the next level!", 150, 300);
			}
			
		} else if (switchScreen == 3) { // LEVEL 2 --------------------------------------
			
			background(255);
			textSize(50);
			fill(0);
			level = "Level 2";
			text(level, 150, 50);
			l2.draw(this);
			ball2.draw(this);

			fill(255,255,0);
			coin1.draw(this);
			coin2.draw(this);
			if (ball2.goal()) {
				textSize(50);
				fill(0);
				text("Good job!", 150, 250);
				textSize(20);
				text("Click enter to go to the next level!", 150, 300);
			}
			
		}
		else if (switchScreen == 4) { // LEVEL 3 --------------------------------------
			background(255);
			textSize(50);
			fill(0);
			level = "Level 3";
			text(level, 150, 50);
			l3.draw(this);
			g1.draw(this);
			g2.draw(this);
			
			textSize(15);
			float seconds = time3.countUp(this);
			
			if (seconds <= 3) {
				fill(0);
				text(time3.getTime(), 20, 20);
				g1.moveGhosts();
				g2.moveGhosts();
			} else if (seconds <= 5) {
				fill(0);
				text(time3.getTime(), 20, 20);
				g1.stopGhosts();
				g2.stopGhosts();
			} else {
				fill(0);
				text("5.000", 20, 20);
				rect.setFillColor(Color.BLACK);
				rect.draw(this);
			}


			ball3.draw(this);
			fill(255,255,0);
			coin1.draw(this);
			coin2.draw(this);

			if (ball3.ghostIntersects(g1, g2)) {
				intersects = true;
			}
			if (ball3.goal()) {
				textSize(50);
				fill(0);
				text("Good job!", 150, 250);
				textSize(20);
				text("Click enter to go to the next level!!", 150, 300);
			}
			
			if (intersects == true && seconds > 3) {
				if(ball3.ghostIntersects(g2, g1)) {
					popup = this.loadImage("images/You hit a ghost!.gif");
					popup.resize(533, 300);
					this.image(popup, 35, 70);
					
				}
			}
		}else if (switchScreen == 5) { // LEVEL 4 --------------------------------------
			intersects = false;
			background(255);
			textSize(50);
			fill(0);
			level = "Level 4";
			text(level, 150, 50);
			l4.draw(this);
			g1.draw(this);
			g2.draw(this);

			
			textSize(15);
			float seconds = time4.countUp(this);
			
			if (seconds <= 3) {
				fill(0);
				text(time4.getTime(), 20, 20);
				g1.moveGhosts();
				g2.moveGhosts();
			} else if (seconds <= 5) {
				fill(0);
				text(time4.getTime(), 20, 20);
				g1.stopGhosts();
				g2.stopGhosts();
			} else {
				fill(0);
				text("5.000", 20, 20);
				rect.moveBy(0, 0);
				rect.setFillColor(Color.BLACK);
				rect.draw(this);
			}
			
			ball4.draw(this);
			fill(255,255,0);
			coin1.draw(this);
			coin2.draw(this);

			if (ball4.ghostIntersects(g1, g2)) {
				intersects = true;
			}
			if (ball4.goal()) {
				textSize(50);
				fill(0);
				text("Good job!", 150, 250);
				textSize(20);
				text("Click enter to go to the next level!", 150, 300);
			}
			if (intersects == true && seconds > 3) {
				if(ball4.ghostIntersects(g2, g1)) {
					popup = this.loadImage("images/You hit a ghost!.gif");
					popup.resize(533, 300);
					this.image(popup, 35, 70);
					
				}
			}

		}else if (switchScreen == 6) { // LEVEL 5 --------------------------------------
			intersects = false;
			background(255);
			textSize(50);
			fill(0);
			level = "Level 5";
			text(level, 150, 50);
			l5.draw(this);
			g1.draw(this);
			g2.draw(this);

			
			textSize(15);
			float seconds = time5.countUp(this);
			
			if (seconds <= 3) {
				fill(0);
				text(time5.getTime(), 20, 20);
				g1.moveGhosts();
				g2.moveGhosts();
			} else if (seconds <= 5) {
				fill(0);
				text(time5.getTime(), 20, 20);
				g1.stopGhosts();
				g2.stopGhosts();
			} else {
				fill(0);
				text("5.000", 20, 20);
				rect.moveBy(0, 0);
				rect.setFillColor(Color.BLACK);
				rect.draw(this);
			}

			ball5.draw(this);
			fill(255,255,0);
			coin1.draw(this);
			coin2.draw(this);

			if (ball5.ghostIntersects(g1, g2)) {
				intersects = true;
			}
			if (ball5.goal()) {
				textSize(50);
				fill(0);
				text("Good job!", 150, 250);
				textSize(20);
				text("Click enter to go to the next level!", 150, 300);
			}
			if (intersects == true && seconds > 3) {
				if(ball5.ghostIntersects(g2, g1)) {
					popup = this.loadImage("images/You hit a ghost!.gif");
					popup.resize(533, 300);
					this.image(popup, 35, 70);
					
				}
			}

		}else if (switchScreen == 7) { // LEVEL 6 --------------------------------------
			intersects = false;
			background(255);
			textSize(50);
			fill(0);
			level = "Level 6";
			text(level, 150, 50);
			l6.draw(this);
			g1.draw(this);
			g2.draw(this);
			
			textSize(15);
			float seconds = time6.countUp(this);
			
			if (seconds <= 3) {
				fill(0);
				text(time6.getTime(), 20, 20);
				g1.moveGhosts();
				g2.moveGhosts();
			} else if (seconds <= 5) {
				fill(0);
				text(time6.getTime(), 20, 20);
				g1.stopGhosts();
				g2.stopGhosts();
			} else {
				fill(0);
				text("5.000", 20, 20);
				rect.moveBy(0, 0);
				rect.setFillColor(Color.BLACK);
				rect.draw(this);
			}
			
			ball6.draw(this);
			fill(255,255,0);
			coin1.draw(this);
			coin2.draw(this);

			if (ball6.ghostIntersects(g1, g2)) {
				intersects = true;
			}
			if (ball6.goal()) {
				textSize(50);
				fill(0);
				text("CONGRATS!!", 150, 250);
				textSize(20);
				text("YOU HAVE COMPLETED ALL THE LEVELS!!", 150, 300);
			}
			
			if (intersects == true && seconds > 3) {
				if(ball6.ghostIntersects(g2, g1)) {
					popup = this.loadImage("images/You hit a ghost!.gif");
					popup.resize(533, 300);
					this.image(popup, 35, 70);
					
				}
			}
			
		}
		
		
		if(switchScreen > 1) {
			zoomPicture = this.loadImage("images/fullscreen.gif");
			zoomPicture.resize(20, 20);
			this.image(zoomPicture, 570, 10);
		}
		
		if(switchScreen > 1) {
			push();
			fill(0);
			textSize(30);
			text("Coin: " + coinCount, 20, 35);
			pop();
		}
		if (keyCode == KeyEvent.VK_ENTER) {
			switchScreen++;
			keyCode = 0;
			
		}
		
		fill(0);
		textSize(20);
		text("HIGHSCORE: " + highscore, 400,30);

		
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

		
		rect.setFillColor(Color.WHITE);
		rect.moveBy(1200, 1200);
		rect.draw(this);

		
		if (level.equals("Level 1")) {
			if(ball.coinIntersects()) {
				coinCount++;
			}

			x = mouseX;
			y = mouseY;
			Line l = new Line(ball.getX(), ball.getY(), x, y);
			l.draw(this);
		
			double dist = ball.getDistance(ball.getX(), ball.getY(), x, y);
			double x_diff = (double)(ball.getX() - x)/(dist * 1.5 /10);
			double y_diff = (double)(ball.getY() - y)/(dist * 1.5/10);
			for (int i = 0; i < dist * 1.5/10; i++) {
				if (!ball.bounce1(x_diff, y_diff)) {
					ball.setX((int)(ball.getX() + x_diff));
					ball.setY((int)(ball.getY() + y_diff));
					ball.goal();
				}
			}	

		}
		else if (level.equals("Level 2")) {
			if(ball2.coinIntersects()) {
				coinCount++;
			}

			x = mouseX;
			y = mouseY;
			Line l = new Line(ball2.getX(), ball2.getY(), x, y);
			l.draw(this);
			
			double dist = ball2.getDistance(ball2.getX(), ball2.getY(), x, y);
			double x_diff = (double)(ball2.getX() - x)/(dist * 1.5 /10);
			double y_diff = (double)(ball2.getY() - y)/(dist * 1.5/10);
			for (int i = 0; i < dist * 1.5/10; i++) {
				if (!ball2.bounce1(x_diff, y_diff)) {
					ball2.setX((int)(ball2.getX() + x_diff));
					ball2.setY((int)(ball2.getY() + y_diff));
					ball2.goal();
				}
			}	

		}
		else if (level.equals("Level 3")) {
			if(ball3.coinIntersects()) {
				coinCount++;
			}

			x = mouseX;
			y = mouseY;
			Line l = new Line(ball3.getX(), ball3.getY(), x, y);
			l.draw(this);
			
			double dist = ball3.getDistance(ball3.getX(), ball3.getY(), x, y);
			double x_diff = (double)(ball3.getX() - x)/(dist * 1.5 /10);
			double y_diff = (double)(ball3.getY() - y)/(dist * 1.5/10);
			for (int i = 0; i < dist * 1.5/10; i++) {
				if (!ball3.bounce1(x_diff, y_diff)) {
					ball3.setX((int)(ball3.getX() + x_diff));
					ball3.setY((int)(ball3.getY() + y_diff));
					ball3.goal();
				}
			}	
		}
		else if (level.equals("Level 4")) {
			if(ball4.coinIntersects()) {
				coinCount++;
			}

			x = mouseX;
			y = mouseY;
			Line l = new Line(ball4.getX(), ball4.getY(), x, y);
			l.draw(this);
			
			double dist = ball4.getDistance(ball4.getX(), ball4.getY(), x, y);
			double x_diff = (double)(ball4.getX() - x)/(dist * 1.5 /10);
			double y_diff = (double)(ball4.getY() - y)/(dist * 1.5/10);
			for (int i = 0; i < dist * 1.5/10; i++) {
				if (!ball4.bounce1(x_diff, y_diff)) {
					ball4.setX((int)(ball4.getX() + x_diff));
					ball4.setY((int)(ball4.getY() + y_diff));
					ball4.goal();
				}
			}	
		}
		else if (level.equals("Level 5")) {
			if(ball5.coinIntersects()) {
				coinCount++;
			}

			x = mouseX;
			y = mouseY;
			Line l = new Line(ball5.getX(), ball5.getY(), x, y);
			l.draw(this);
			
			double dist = ball5.getDistance(ball5.getX(), ball5.getY(), x, y);
			double x_diff = (double)(ball5.getX() - x)/(dist * 1.5 /10);
			double y_diff = (double)(ball5.getY() - y)/(dist * 1.5/10);
			for (int i = 0; i < dist * 1.5/10; i++) {
				if (!ball5.bounce1(x_diff, y_diff)) {
					ball5.setX((int)(ball5.getX() + x_diff));
					ball5.setY((int)(ball5.getY() + y_diff));
					ball5.goal();
				}
			}	
		}
		else if (level.equals("Level 6")) {
			if(ball6.coinIntersects()) {
				coinCount++;
			}

			x = mouseX;
			y = mouseY;
			Line l = new Line(ball6.getX(), ball6.getY(), x, y);
			l.draw(this);
			
			double dist = ball6.getDistance(ball6.getX(), ball6.getY(), x, y);
			double x_diff = (double)(ball6.getX() - x)/(dist * 1.5 /10);
			double y_diff = (double)(ball6.getY() - y)/(dist * 1.5/10);
			for (int i = 0; i < dist * 1.5/10; i++) {
				if (!ball6.bounce1(x_diff, y_diff)) {
					ball6.setX((int)(ball6.getX() + x_diff));
					ball6.setY((int)(ball6.getY() + y_diff));
					ball6.goal();
				}
			}	
		}
		
		
	}
	
	public void readFile(String inputFile) throws IOException {
		StringBuffer fileData = new StringBuffer();
		
		Scanner scan = null;
		
		try {
			FileReader fr = new FileReader(inputFile);
			scan = new Scanner(fr);
			
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				fileData.append(line);
			}
		} finally {
			if (scan != null)
				scan.close();
		}
		highscore = fileData.toString();
	}
	
	public void writeFile(String data, String outputFile) throws IOException {
		
		FileWriter fr = null;
		
		try {
			fr = new FileWriter(outputFile);
			
			fr.write(data);
			
			fr.flush();

		} finally {
			if (fr != null)
				fr.close();
		}
		
		
	}

	
	public void keyPressed() {
		
//		if(mouseX >= r.getX() && mouseX >= r.getY() + r.getWidth() && mouseY <= r.getY() && mouseY <= r.getY() + rect.getHeight()) {
		if(keyCode == 'F') {
//			System.out.println("You're in!");
			l1.scaleDown();
			l2.scaleDown();
			l3.scaleDown();
			l4.scaleDown();
			l5.scaleDown();
			l6.scaleDown();
//			System.out.println(l1.returnZ());
		}
		
		if(keyCode == 'Z') {
//			System.out.println("You're out!");
			l1.scaleUp();
			l2.scaleUp();
			l3.scaleUp();
			l4.scaleUp();
			l5.scaleUp();
			l6.scaleUp();
//			System.out.println(l1.returnZ());

		}
		
		if(keyCode == 'S') {
//			System.out.print("LEVEL");
			ball3.setX(260);
			ball3.setY(220);
			ball4.setX(260);
			ball4.setY(220);
			ball5.setX(260);
			ball5.setY(220);
			ball6.setX(260);
			ball6.setY(220);
			time3 = new Timer(0);
			time4 = new Timer(0);
			time5 = new Timer(0);
			time6 = new Timer(0);
			g1.draw(this);
			g2.draw(this);
			g1.moveGhosts();
			g2.moveGhosts();
		}
		
		if(keyCode == 'R') {
//			System.out.println("you reset");
//			coinCount = 0;
			switchScreen = 0;
			homeScreen.draw(this);
		}
		
		if(keyCode == '1') {

			coinCount -= 5;
			
			
//			popup = null;
//			popup = new PImage();
//			popup = this.loadImage("images/transparent.png");
//			popup.resize(10, 10);
//			this.image(popup, 35, 70);
			
					
			
		}
		if(keyCode == '2') {

			switchScreen = 2;
			ball.setX(260);
			ball.setY(220);
		}
//		}
	}
		
	public int getScreen() {
		return switchScreen;
	}
	
	public double getDist() {
		return dist;
	}

}
