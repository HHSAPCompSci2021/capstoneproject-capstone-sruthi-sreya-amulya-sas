package gameElements;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//import javax.swing.JFrame;
import javax.swing.JPanel;

public class Timer extends JPanel implements KeyListener {
	
	private int timer;
	private String timerText;
	private boolean timerStart;
	
	public static void wait(int ms)
	{
		try 
		{
			Thread.sleep(ms);
		} 
		catch(InterruptedException ex) 
		{
			Thread.currentThread().interrupt();
		}
	}
	
	public Timer() {
		super();
		
		//maze 1
		timer = 30;
		timerText = "30";	
		timerStart = false;
		
	}
	
	public void keyPressed(KeyEvent e) { }
	
	public void keyReleased(KeyEvent e) { }
	
	public void keyTyped(KeyEvent e) { }
	
	
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g); // Call JPanel's paintComponent method to paint the background
	
		//timer drawer
		if (timerStart = true) {
			if (timer < 5 ) {
				g.setColor(Color.RED);
			}
			else 
				g.setColor(new Color(43, 164, 99));
				
			g.setFont(new Font("Serif", Font.BOLD, 40));
			g.drawString("00:" + timerText, 4, 30);
			
			
			if (timer > 0) {
		
				timer -= 1;
				if (timer < 10 ) {
					timerText = "0"+ Integer.toString(timer);
				}
				else 
					timerText = Integer.toString(timer);
				repaint();
				wait(1000);
					
			} 
		}
		
		
	}

//public static void main(String[] args) {
//		
//		JFrame w = new JFrame("timer tester");
//		w.setBounds(100, 100, 500, 500);
//		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		Timer panel = new Timer();
//		panel.setBackground(Color.WHITE);
//		w.add(panel);
//		w.setResizable(true);
//		w.setVisible(true);
//		w.addKeyListener(panel);
// 
//			
//	}
}
