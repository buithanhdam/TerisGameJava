package Handling;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Main.Controller;
import Main.Game;
import Main.HighScores;
import Main.StartingMenu;
import Main.Controller.STATE;
import Main.EndScreen;

public class MouseHandler implements MouseListener {
	
	StartingMenu menu;
	Game game;
	HighScores scores;
	EndScreen endscreen;

	public MouseHandler(StartingMenu menu, Game game, HighScores scores, EndScreen endscreen) {
		this.menu = menu;
		this.game = game;
		this.scores = scores;
		this.endscreen = endscreen;
	}
	
	public void mouseClicked(MouseEvent e) {
		
	}

	public void mousePressed(MouseEvent e) {
		
	}

	public void mouseReleased(MouseEvent e) {
		//clear game
		if(Controller.state == Controller.STATE.GAME) {
			if(game.buttons[0].contains(e.getPoint())) {
				game.clearGame();
			}
			//Main Menu
			if(game.buttons[1].contains(e.getPoint())) {
				game.showGuide = !game.showGuide;
			}
			//Main Menu
			if(game.buttons[2].contains(e.getPoint())) {
				game.running = false;
				Controller.switchClasses(Controller.STATE.MENU);
			}
		}
		if(Controller.state == Controller.STATE.MENU) {
			if(menu.buttons[0].contains(e.getPoint())) {
				menu.running = false;
				menu.playGame();
			}
			//Machine Learning
			if(menu.buttons[1].contains(e.getPoint())) {
				menu.running = false;
				menu.highScores();
			}
			//Main Menu
			if(menu.buttons[2].contains(e.getPoint())) {
				menu.running = false;
				menu.visitSite();
			}
		}
		if(Controller.state == Controller.STATE.SCORES) {
			if(scores.back.contains(e.getPoint())) {
				scores.goBack();
			}
		}
		if(Controller.state == Controller.STATE.ENDSCREEN) {
			if(endscreen.menu.contains(e.getPoint())) {
				Controller.switchClasses(Controller.STATE.MENU);
			}
		}
	}

	public void mouseEntered(MouseEvent e) {
	
	}

	public void mouseExited(MouseEvent e) {
		
	}
}
