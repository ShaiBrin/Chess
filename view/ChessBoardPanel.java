package view;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;


import model.Algorithm;
import model.Cell;
import model.Constantes;
import model.GameModel;
import model.PaintAlgorithm;
import model.PanelAlgorithm;

@SuppressWarnings("serial")
public class ChessBoardPanel extends JPanel{
	protected GameModel game;
 	protected PanelAlgorithm panelAlgorithm;
	public ChessBoardPanel(GameModel game, PanelAlgorithm panelAlgorithm) {
		super();
		this.game = game;
		this.panelAlgorithm = panelAlgorithm;
 	}

	
	public void paint(Graphics g) {
		super.paint(g);
		paintBoard(g);
	}
	
	
	/**
	 * 
	 * @param g is the Graphics of the panel.
	 */
	public void paintBoard(Graphics g) {
		for (int counterRows = Constantes.NUMBER_ROWS; counterRows > 0; counterRows--) {
			for (int counterColumns = 0; counterColumns < Constantes.NUMBER_COLUMNS; counterColumns++) {
				String coordinate =  Algorithm.getChessCoordinateWithRowAndColumn(game, counterColumns, counterRows);
				Cell cell = Algorithm.getCellWithCoordinate(game, coordinate);
				Color color = Algorithm.switchColors(counterRows, counterColumns);
				Algorithm.setCellColor(cell, color);	
				Algorithm.setGraphicsColor(g, color);
				panelAlgorithm.getPaintAlgorithm().paintCell(g, cell);	
			}
		}
	}
}
