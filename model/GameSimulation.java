package model;

import java.awt.Graphics;
import java.awt.event.MouseEvent;

public class GameSimulation {

	private Cell presentCell;
	private Cell pastCell;
	private Player currentPlayer;
	private Player opponentPlayer;
	private AssaultAlgorithm assaultAlgorithm;
	private DisplacementAlgorithm displacement;
	
	public GameSimulation(GameModel gameModel) {
		setPlayers(gameModel);
		assaultAlgorithm = new AssaultAlgorithm();
		displacement = new DisplacementAlgorithm();
	}

	public void quelquechose(GameModel gameModel) {
		
		currentPlayer.getPlayerPieces().forEach((key,value)->{
			value.setPossibleMoves(gameModel);
			value.getMoves().forEach(System.out::println);
		});
		
	}
	
	public boolean checked() {
		boolean checked = false;
		if(currentPlayerChecked() || opponenentPlayerChecked()) {
			checked = true;
		}
		return checked;
	}
	
	public Cell getCheckedKingCell(GameModel gameModel) {
		Cell cell = new Cell();
		
		if(checked()) {
			if(currentPlayerChecked()) {
				cell = Algorithm.getKingCell(gameModel, gameModel.getGameSimulation().getCurrentPlayer().getChessColor());
			}
			
			else {
				cell = Algorithm.getKingCell(gameModel, gameModel.getGameSimulation().getOpponentPlayer().getChessColor());			}
		}
		return cell;
	}
	
	public boolean currentPlayerChecked() {
		boolean currentPlayerChecked = false;
		
		if(currentPlayer.isChecked() && !opponentPlayer.isChecked()) {
			 currentPlayerChecked = true;
		}
		return currentPlayerChecked;
	}
	
	public boolean opponenentPlayerChecked() {
		boolean opponentPlayerChecked = false;
		
		if(opponentPlayer.isChecked() && !currentPlayer.isChecked()) {
			 opponentPlayerChecked = true;
		}
		return opponentPlayerChecked;
	}
	
	public void setPastCell() {
		try {
			pastCell = presentCell;

		} catch (Exception e) {
		}
	}
	
	
	
	public void setPresentCell(GameModel game, MouseEvent event) {
		presentCell = Algorithm.getCellWithCoordinate(game, Algorithm.getChessCoordinate(game, event.getPoint()));
	}
	
	public void setPresentCellWithPast(GameModel gameModel) {
		presentCell.setPiece(pastCell.getPiece());
	}
	
	public void setPlayers(GameModel gameModel) {
		setCurrentPlayer(gameModel.getGameRules().getPlayer1());
		setOpponentPlayer(gameModel.getGameRules().getPlayer2());
	}
	
	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}
	
	public void setOpponentPlayer(Player opponentPlayer) {
		this.opponentPlayer = opponentPlayer;
	}
	
	
	public void switchPlayers(GameModel gameModel) {
		if(gameModel.getGameRules().getPlayer1Turn()) {
			setCurrentPlayer(gameModel.getGameRules().getPlayer1());
			setOpponentPlayer(gameModel.getGameRules().getPlayer2());
		}
		else {
			setCurrentPlayer(gameModel.getGameRules().getPlayer2());
			setOpponentPlayer(gameModel.getGameRules().getPlayer1());
		}
	}
	
	/**
	 * 
	 * @param g         is the graphics of the panel.
	 * @param mainPanel is the mainPanel.
	 */
	public boolean isPieceAssaulted(Graphics g, GameModel gameModel) {
		boolean pieceRemoved = false;
		if (assaultAlgorithm.assaultMoveSelected(this)) {
			assaultAlgorithm.removePiece(gameModel);
			pieceRemoved = true;
		}
		return pieceRemoved;
	}
	
	
	
	
	
	
	public boolean isPieceSelected(GameModel gameModel) {
		return displacement.isPieceSelectable(gameModel);
	}
	
	public boolean moveSelected(GameModel gameModel) {
		return displacement.moveSelected(gameModel);
	}
	
	public Cell getPastCell() {
		return pastCell;
	}
	
	public Cell getPresentCell() {
		return presentCell;
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public Player getOpponentPlayer() {
		return opponentPlayer;
	}

	

	
}
