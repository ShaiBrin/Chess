package model;

 
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

import Enums.ID;
import view.MainPanel;

public class PanelAlgorithm {
	
	private MouseEvent event;
	private GameModel gameModel;
	private PaintAlgorithm paintAlgorithm;
	private boolean mouseClicked;
 	
	public PanelAlgorithm(GameModel gameModel) {
		setParameters(gameModel);
	}

	/**
	 * 
	 * @param event is the current event of the mouse.
	 */
	public void mouseReleased(MouseEvent event) {
		setEvent(event);
		setMouseClicked();
		setCells();
 	}
	
	/**
	 * 
	 * @param g         is the graphics.
	 * @param mainPanel is the mainPanel.
	 */
	public void paint(Graphics g, MainPanel mainPanel) {
		if (isMouseClicked()) {
			paintPresentCell(g);
			assaultPiece(g);
			select(g,mainPanel);
			play(g,mainPanel);
		}
	}
	
	

	public void setParameters(GameModel gameModel) {
		this.gameModel = gameModel;
		paintAlgorithm = new PaintAlgorithm();
	}
	
	/**
	 * initializes the cells.
	 */
	public void setCells() {
		gameModel.getGameSimulation().setPastCell();
		gameModel.getGameSimulation().setPresentCell(gameModel, event);
		Algorithm.printInfoCells(gameModel.getGameSimulation().getPastCell(), gameModel.getGameSimulation().getPresentCell());
	}
	
	/**
	 * sets the mouse clicked to true.
	 */
	public void setMouseClicked() {
		mouseClicked = true;
	}

	/**
	 * sets the current event.
	 * 
	 * @param event is the current event.
	 */
	public void setEvent(MouseEvent event) {
		this.event = event;
	}

	public void select(Graphics g, MainPanel mainPanel) {
		if(gameModel.getGameSimulation().isPieceSelected(gameModel)) 
			paintSelectedPiece(g, mainPanel);
	}
	
	public void play(Graphics g, MainPanel mainPanel) {
		if (gameModel.getGameSimulation().moveSelected(gameModel))
			movePiece(g, mainPanel);
	}
	
	/**
	 * 
	 * @param g         is the graphics.
	 * @param mainPanel is the main panel.
	 */
	public void movePiece(Graphics g, MainPanel mainPanel) {
		paintEmptyCell(g);
		paintCurrentCellWithPiece(g, mainPanel);
		setPastAndCurrentCell();
		switchTurns(g, mainPanel);
	}
	
	
	public void setPastAndCurrentCell() {
		gameModel.getGameSimulation().getPresentCell().getPiece().setHasMoved(true);
		gameModel.getGameSimulation().getPastCell().setPiece(null);
	}
	public void paintCurrentCellWithPiece(Graphics g, MainPanel mainPanel) {
		g.setColor(gameModel.getGameSimulation().getPresentCell().getColor());
		gameModel.getGameSimulation().setPresentCellWithPast(gameModel);
		paintAlgorithm.paintCellPiece(g,mainPanel,gameModel.getGameSimulation());
	}
	
	public void paintEmptyCell(Graphics g) {
		g.setColor(gameModel.getGameSimulation().getPastCell().getColor());
		paintAlgorithm.paintCell(g, gameModel.getGameSimulation().getPastCell());
	}
	
	public void switchTurns(Graphics g, MainPanel mainPanel) {
		gameModel.getGameRules().setPossibleMoves(gameModel);	
		isPlayerChecked(g,mainPanel);
		gameModel.getGameRules().switchTurns();
		gameModel.getGameSimulation().switchPlayers(gameModel);
	}
	
	public void isPlayerChecked(Graphics g, MainPanel mainPanel) {
		Cell checkedKingCell;
		if(gameModel.getGameSimulation().checked()) {
			g.setColor(Color.RED);
			checkedKingCell = gameModel.getGameSimulation().getCheckedKingCell(gameModel);
			paintAlgorithm.paintCell(g, checkedKingCell);
			paintAlgorithm.paintPiece(g, checkedKingCell, mainPanel);
		}
	}
	
	/**
	 * 
	 * @param g         is the graphics of the panel.
	 * @param mainPanel is the mainPanel.
	 */
	public void assaultPiece(Graphics g) {
		if(gameModel.getGameSimulation().isPieceAssaulted(g,gameModel)) {
			g.setColor(gameModel.getGameSimulation().getPresentCell().getColor());
			paintAlgorithm.paintCell(g, gameModel.getGameSimulation().getPresentCell());
		}
	}


	public void paintPresentCell(Graphics g) {
		paintAlgorithm.paintCell(g, gameModel.getGameSimulation().getPresentCell());
	}
	
	/**
	 * 
	 * @param g         the graphics
	 * @param mainPanel is the main panel.
	 */
	public void paintSelectedPiece(Graphics g, MainPanel mainPanel) {
		g.setColor(gameModel.getGameSimulation().getPresentCell().getColor());
		paintAlgorithm.paintCellPiece(g,mainPanel,gameModel.getGameSimulation());
		paintAlgorithm.paintPossibleMoveCells(g,gameModel.getGameSimulation().getPresentCell());
		paintAlgorithm.paintPossibleAssaultCells(g, mainPanel, gameModel.getGameSimulation().getPresentCell());
	}
 
	public PaintAlgorithm getPaintAlgorithm() {
		return paintAlgorithm;
	}

	/**
	 * 
	 * @return true if the mouse has been clicked.
	 */
	public boolean isMouseClicked() {
		return mouseClicked;
	}
}
