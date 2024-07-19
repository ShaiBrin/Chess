package view;

import java.awt.Graphics;

import javax.swing.JPanel;

import model.GameModel;

@SuppressWarnings("serial")
public class ChessPawnsPanel extends JPanel {
	private GameModel game;

	public ChessPawnsPanel(GameModel game) {
		this.game = game;
	}

	public void paint(Graphics g) {
		super.paint(g);
		paintPieces(g);
	}

	public void paintPieces(Graphics g) {

		game.getgamePieces().getBlackPieces().forEach((key,value)->{
			value.paintIcon(this, g, value.getPosition().x, value.getPosition().y);
			
		});
		
		game.getgamePieces().getWhitePieces().forEach((key,value)->{
			value.paintIcon(this, g, value.getPosition().x, value.getPosition().y);
			
		});
	}
}
