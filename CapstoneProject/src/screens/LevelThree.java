package screens;

import java.util.ArrayList;

import gameElements.Ghost;
import processing.core.PApplet;

public class LevelThree extends Level {

	private ArrayList<Ghost> ghosts;
//	private final int ghost1X1, ghost1Y1, ghost1X2, ghost1Y2, ghost1X3, ghost1Y3;
////	private final int ghost2X1, ghost2Y1, ghost2X2, ghost2Y2, ghost2X3, ghost2Y3;
	
	public LevelThree() {
//		ghost1X1 = (int) (Math.random() * 500);
//		ghost1Y1 = (int) (Math.random() * 500);
//		ghost1X2 = (int) (Math.random() * 500);
//		ghost1Y2 = (int) (Math.random() * 500);
//		ghost1X3 = (int) (Math.random() * 500);
//		ghost1Y3 = (int) (Math.random() * 500);
//		
//		ghost2X1 = (int) (Math.random() * 500);
//		ghost2Y1 = (int) (Math.random() * 500);
//		ghost2X2 = (int) (Math.random() * 500);
//		ghost2Y2 = (int) (Math.random() * 500);
//		ghost2X3 = (int) (Math.random() * 500);
//		ghost2Y3 = (int) (Math.random() * 500);
		
		
		
		
//		ghost2X = (int) (Math.random() * 500);
//		ghost2Y = (int) (Math.random() * 500);
	}
	
	@Override
	public void draw(PApplet marker) {
		marker.fill(255);
		marker.line(50, 50, 150, 50); // horizontal (right)
		marker.line(150, 50, 150, 150); // down
		marker.line(150, 150, 300, 150); // right
		marker.line(300, 150, 300, 250); // down
		marker.line(300, 250, 50, 250); // left
		marker.line(50, 250, 50, 50); // up

		marker.push();
		marker.fill(0);
		marker.circle(90, 90, 10);
		marker.pop();
		
		//for (int i = 0; i % 10 == 0 && i < 100) {
//		Ghost g = new Ghost(ghost1X1, ghost1Y1);
//		Ghost g2 = new Ghost(ghost2X1, ghost2Y1);
		
		Ghost g = new Ghost();
		Ghost g2 = new Ghost();
		
		
//		g.draw(marker);
//
//		g.setX(ghost1X2);
//		g.setY(ghost1Y2);
//		g.draw(marker);
//
//		g.setX(ghost1X3);
//		g.setY(ghost1Y3);
//		g.draw(marker);
		
		
		
		
		

//		for(int i = 0; i <= 3; i++) {
//			
//			g.setX((int)(Math.random()*500));
//			g.setY((int)(Math.random()*500));
//
//			g2.setX((int)(Math.random()*500));
//			g2.setY((int)(Math.random()*500));
//		}

		g.draw(marker);
		g2.draw(marker);
		
		
//		g.draw(marker);

//		g.setX(ghost1X2);
//		g.setY(ghost1Y2);
//		g.draw(marker);

//		g.setX(ghost1X3);
//		g.setY(ghost1Y3);
//		g.draw(marker);
		
//		g2.setX(ghost2X2);
//		g2.setY(ghost2Y2);
//		g2.draw(marker);

//		g2.setX(ghost2X3);
//		g2.setY(ghost2Y3);
//		g2.draw(marker);
		
		
	}

	@Override
	public void zoomIn() {
		// code to resize
		
	}

	@Override
	public void zoomOut() {
		// code to resize
		
	}

}
