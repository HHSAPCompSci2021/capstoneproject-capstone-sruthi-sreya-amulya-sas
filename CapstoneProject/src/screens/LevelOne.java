package screens;

import java.awt.Color;
import java.util.ArrayList;

import ameduri.shapes.Line;
import processing.core.PApplet;

public class LevelOne extends Level {
	
	private Line l1;
	private Line l2;
	private Line l3;
	private Line l4;
	private Line l5;
	private Line l6;
	private ArrayList<Line> lines1;
	
	/**
	 * Calls superclass constructor to assign a value to the scale instance variable. Objects, such as Lines, are instantiated.
	 */
	public LevelOne() {
		super(true);
		
		l1 = new Line(50, 50, 150, 50); // horizontal (right)
		l2 =  new Line(150, 50, 150, 150); // down
		l3 =  new Line(150, 150, 300, 150); // right
		l4 =  new Line(300, 150, 300, 250); // down
		l5 =  new Line(300, 250, 50, 250); // left
		l6 =  new Line(50, 250, 50, 50);
		l2.setStrokeColor(Color.RED);
		l4.setStrokeColor(Color.RED);
		lines1 = new ArrayList<Line>();
		lines1.add(l1);
		lines1.add(l2);
		lines1.add(l3);
		lines1.add(l4);
		lines1.add(l5);
		lines1.add(l6);
	}
	
	public ArrayList<Line> getLines() {
		return lines1;
	}
	
	public void draw(PApplet marker) {
		marker.fill(255);
		
		
		l1.draw(marker);
		l2.draw(marker);
		l3.draw(marker);
		l4.draw(marker);
		l5.draw(marker);
		l6.draw(marker);

		marker.push();
		marker.fill(0);
		marker.circle(90, 90, 10);
		marker.pop();

		
	}
	
	public void scaleUp() {
//		
//		l1.setPoint2(l1.getX2()*z, l1.getY2());
//		
//		l2.setPoint(l2.getX() * z, l2.getY());
//		l2.setPoint2(l2.getX2() * z, l2.getY2() * z);
//		l3.setPoint(l3.getX() * z, l3.getY() * z);
//		l3.setPoint2(l3.getX2() * z, l3.getY2() * z);
//		l4.setPoint(l4.getX() * z, l4.getY()* z);
//		l4.setPoint2(l4.getX2() * z, l4.getY2() * z);
//		l5.setPoint2(l5.getX2(), l5.getY2() * z);
//		l5.setPoint(l5.getX() * z, l5.getY() * z);
//		
//		l6.setPoint(l6.getX(), l6.getY() * z);
		
		if(getScale() == true) {
			l1.setPoint2(l1.getX2()*1.5, l1.getY2());
			
			l2.setPoint(l2.getX() * 1.5, l2.getY());
			l2.setPoint2(l2.getX2() * 1.5, l2.getY2() * 1.5);
			l3.setPoint(l3.getX() * 1.5, l3.getY() * 1.5);
			l3.setPoint2(l3.getX2() * 1.5, l3.getY2() * 1.5);
			l4.setPoint(l4.getX() * 1.5, l4.getY()* 1.5);
			l4.setPoint2(l4.getX2() * 1.5, l4.getY2() * 1.5);
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
