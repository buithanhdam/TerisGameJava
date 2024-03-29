package Main;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class HighScores {

	Scanner scanner;
	public Rectangle back;
	public Point mousePoint;
	
	public int[] scores = {0, 0, 0, 0, 0};
	
	public void init() {
		mousePoint = new Point(0, 0);
		back = new Rectangle( Controller.WIDTH/2-100, 400, 200, 50);
		scores = Scoring.readFile(Scoring.HIGHSCOREPATH);
	}
	
	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Controller.WIDTH, Controller.HEIGHT);
		g.setColor(new Color(100, 100, 100));
		g.fillRoundRect(100, 50, Controller.WIDTH/3*2, Controller.HEIGHT/3*2, 25, 25);
		g.setColor(Color.white);
		g.drawString("Scores", Controller.WIDTH/2-g.getFontMetrics().stringWidth("Scores")/2, 100);
		for(int i = 0; i < scores.length; i++) {
			g.drawString("" + scores[i], Controller.WIDTH/2-50, 150+40*i);
		}
		
		if(back.contains(mousePoint)) {
			g.fillRoundRect(back.x, back.y, back.width, back.height, 25, 25);
		}
		g.drawString("Back",back.x +back.x/2 - g.getFontMetrics().stringWidth("Back")/2, back.y + 35);
		g.setColor(Color.red);
		g.drawRoundRect(back.x, back.y, back.width, back.height, 25, 25);
	}
	public void goBack() {
		Controller.switchClasses(Controller.STATE.MENU);
	}
	
}
