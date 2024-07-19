package model;

import Piece.Piece;

public class DisplacementAlgorithm {

	/**
	 * 
	 * @param presentCell is the current cell.
	 * @param game        is the game.
	 * @return true if the piece selected corresponds to the player's pieces.
	 */
	public boolean isPieceSelectable(GameModel gameModel) {
		boolean pieceHasBeenSelected = false;
		
		if(gameModel.getGameSimulation().getPresentCell().containsPiece 
			&&gameModel.getGameSimulation().getPresentCell().getPiece().getChessColor() == gameModel.getGameSimulation().getCurrentPlayer().getChessColor()) {
			pieceHasBeenSelected = true;
			gameModel.getGameSimulation().getPresentCell().getPiece().setPossibleMoves(gameModel);
		}
		
		return pieceHasBeenSelected;
	}
	
	/**
	 * 
	 * @return true if a move has been selected.
	 */
	public boolean moveSelected(GameModel gameModel) {
		boolean moveSelected = false;
		try {
			if(gameModel.getGameSimulation().getPastCell().containsPiece() 
					&& gameModel.getGameSimulation().getPastCell().getPiece().getChessColor().equals(gameModel.getGameSimulation().getCurrentPlayer().getChessColor())
					&& gameModel.getGameSimulation().getPastCell().getPiece().getMoves().contains(gameModel.getGameSimulation().getPresentCell())) {
				moveSelected = true;
			}
		} catch (Exception e) {
		}
		return moveSelected;
	}
	
	
	
}
