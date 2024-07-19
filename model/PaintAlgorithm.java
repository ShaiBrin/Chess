package model;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Iterator;
import java.util.Set;

import view.MainPanel;

public class PaintAlgorithm {

	public PaintAlgorithm() {}
	
	/**
	 * 
	 * @param g         is the graphics of the panel.
	 * @param cell      is the cell.
	 * @param mainPanel is the JPanel.
	 */
	public void paintPiece(Graphics g, Cell cell, MainPanel mainPanel) {
		cell.getPiece().paintIcon(mainPanel, g, cell.x, cell.y);
	}
	
	/**
	 * 
	 * @param g         is the graphics of the JPanel.
	 * @param list      is the set of the cells.
	 * @param mainPanel is the JPanel.
	 */
	public void paintPieces(Graphics g, Set<Cell> list, MainPanel mainPanel) {
		Iterator<Cell> itr = list.iterator();
		while (itr.hasNext()) {
			paintPiece(g, itr.next(), mainPanel);
		}
	}
	
	/**
	 * 
	 * @param g        is the Graphics of the panel.
	 * @param position is the position of the Square.
	 */
	public void paintCell(Graphics g, Cell cell) {
		g.fillRect(cell.getLocation().x, cell.getLocation().y, Constantes.CELL_SIZE, Constantes.CELL_SIZE);
	}
	
	/**
	 * 
	 * @param g     is the graphics.
	 * @param list  is the list of cells to be painted.
	 * @param color is the specific color.
	 */
	public void paintCells(Graphics g, Set<Cell> list, Color color) {
		g.setColor(color);
		Iterator<Cell> itr = list.iterator();
		while (itr.hasNext()) {
			paintCell(g, itr.next());
		}
	}
	
	/**
	 * paints the possible cells where the piece can move.
	 * 
	 * @param g is the graphics of the panel.
	 */
	public void paintPossibleMoveCells(Graphics g, Cell presentCell) {
		paintCells(g, presentCell.getPiece().getMoves(), Color.GREEN);
	}
	
	/**
	 * 
	 * @param g         is the graphics of the panel.
	 * @param mainPanel is the main panel.
	 */
	public void paintPossibleAssaultCells(Graphics g, MainPanel mainPanel, Cell presentCell) {
		paintCells(g, presentCell.getPiece().assaultMoves(), Color.BLUE);
		paintPieces(g, presentCell.getPiece().assaultMoves(), mainPanel);
	}
	
	
	/**
	 * paints the cell then the piece.
	 * @param g is the graphics.
	 * @param mainPanel is the mainPanel.
	 * @param gameSimulation is the gameSimulation.
	 */
	public void paintCellPiece(Graphics g, MainPanel mainPanel, GameSimulation gameSimulation) {
		paintCell(g, gameSimulation.getPresentCell());
		paintPiece(g, gameSimulation.getPresentCell(), mainPanel);	
	}
}
