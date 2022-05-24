package screens;

import java.awt.Color;
import java.util.ArrayList;

import ameduri.shapes.Line;
import ameduri.shapes.Rectangle;
import processing.core.PApplet;

public class LevelSix extends Level {
	
	private Line l1;
	private Line l2;
	private Line l3;
	private Line l4;
	private Line l5;
	private Line l6;
	private Rectangle l7;
	private Rectangle l8;
	private Rectangle l9;
	private Rectangle l10;

	private ArrayList<Line> lines6;
	private ArrayList<Rectangle> redLines6;

	
	/**
	 * Calls superclass constructor to assign a value to the scale instance variable. Objects, such as Lines and Rectangles, are instantiated.
	 */
	public LevelSix() {
		super(true);
		
		l1 = new Line(50, 50, 150, 50); // horizontal (right)
		l2 =  new Line(150, 50, 150, 150); // down
		l3 =  new Line(150, 150, 300, 150); // right
		l4 =  new Line(300, 150, 300, 250); // down
		l5 =  new Line(300, 250, 50, 250); // left
		l6 =  new Line(50, 250, 50, 50);
		l7 = new Rectangle(200,230,10,30);
		l8 = new Rectangle(90,200, 75, 10);
		l9 = new Rectangle(90,60,75,10);
		l10 = new Rectangle(200,229,10,30);

		l2.setStrokeColor(Color.RED);
		l4.setStrokeColor(Color.RED);
		l7.setStrokeColor(Color.RED);
		l8.setStrokeColor(Color.RED);
		l9.setStrokeColor(Color.RED);
		l10.setStrokeColor(Color.RED);

		lines6 = new ArrayList<Line>();
		lines6.add(l1);
		lines6.add(l2);
		lines6.add(l3);
		lines6.add(l4);
		lines6.add(l5);
		lines6.add(l6);
		redLines6 = new ArrayList<Rectangle>();
		redLines6.add(l7);
		redLines6.add(l8);
		redLines6.add(l9);
		redLines6.add(l10);

	}
	
	public ArrayList<Line> getLines() {
		return lines6;
	}

	/**
	 * Gets the red lines that draw the obstacles in the golf course in a particular level
	 * @return the red lines that draw the obstacles in the golf course
	 */
	public ArrayList<Rectangle> getRedLines() {
		return redLines6;
	}
	
	public void draw(PApplet marker) {
		marker.fill(255);
		
		
		l1.draw(marker);
		l2.draw(marker);
		l3.draw(marker);
		l4.draw(marker);
		l5.draw(marker);
		l6.draw(marker);
		l7.draw(marker);
		l8.draw(marker);
		l9.draw(marker);
		l10.draw(marker);

		marker.push();
		marker.fill(0);
		marker.circle(90, 90, 10);
		marker.pop();

		
	}
	
	public void scaleUp() {

		if(getScale() == true) {
		l1.setPoint2(l1.getX2()*1.5, l1.getY2());
		
		l2.setPoint(l2.getX() * 1.5, l2.getY());
		l2.setPoint2(l2.getX2() * 1.5, l2.getY2() * 1.5);
		l3.setPoint(l3.getX() * 1.5, l3.getY() * 1.5);
		l3.setPoint2(l3.getX2() * 1.5, l3.getY2() * 1.5);
		l4.setPoint(l4.getX() * 1.5, l4.getY()* 1.5);
		l4.setPoint2(l4.getX2() *1.5, l4.getY2() * 1.5);
		l5.setPoint2(l5.getX2(), l5.getY2() * 1.5);
		l5.setPoint(l5.getX() * 1.5, l5.getY() * 1.5);
		
		l6.setPoint(l6.getX(), l6.getY() * 1.5);
		setScale(false);
		}
		
	}
	
	public void scaleDown() {
		if(getScale() == false) {
		l1 = new Line(50, 50, 150, 50); // horizontal (right)
		l2 =  new Line(150, 50, 150, 150); // down
		l3 =  new Line(150, 150, 300, 150); // right
		l4 =  new Line(300, 150, 300, 250); // down
		l5 =  new Line(300, 250, 50, 250); // left
		l6 =  new Line(50, 250, 50, 50);
		setScale(true);
		}	
		}
		

	



}
