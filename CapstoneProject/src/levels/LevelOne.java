package levels;

import processing.core.PApplet;

public class LevelOne extends Level {

	public void draw(PApplet marker) {
		marker.fill(255);
		marker.line(50, 50, 150, 50);
		marker.line(150, 50, 150, 150);
		marker.line(150, 150, 300, 150);
		marker.line(300, 150, 300, 250);
		marker.line(300, 250, 50, 250);
		marker.line(50, 250, 50, 50);

		marker.push();
		marker.fill(0);
		marker.circle(90, 90, 10);
		marker.pop();
	}

}
