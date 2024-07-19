package view;

import java.awt.Graphics;
import javax.swing.JPanel;
import model.GameModel;
import model.PaintAlgorithm;
import model.PanelAlgorithm;

@SuppressWarnings("serial")
public class GamePanel extends JPanel {

	private ChessBoardPanel boardPanel;
	private ChessPawnsPanel pawnsPanel;
	
	public GamePanel(GameModel chessGame, PanelAlgorithm panelAlgorithm) {
		super();		
		initPanels(chessGame, panelAlgorithm);
		addPanels();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		boardPanel.paint(g);
		pawnsPanel.paint(g);
	}
	
	private void initPanels(GameModel chessGame, PanelAlgorithm panelAlgorithm) {
		boardPanel = new ChessBoardPanel(chessGame, panelAlgorithm);
		pawnsPanel = new ChessPawnsPanel(chessGame);
	}
	
	private void addPanels() {
		this.add(boardPanel);
		this.add(pawnsPanel);
	}
	
	
}
