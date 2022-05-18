package screens;

import processing.core.PApplet;

public class LevelSix extends Level {

	
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
	}

	public void zoomIn() {
		// code to resize

	}

	public void zoomOut() {
		// code to resize

	}

}
