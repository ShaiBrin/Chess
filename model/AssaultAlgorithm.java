package model;

import Enums.ID;

public class AssaultAlgorithm {
	
	public  boolean removePiece(GameModel gameModel) {
		ID key = gameModel.getGameSimulation().getPresentCell().getPiece().getUniqueID();

		if(gameModel.getgamePieces().getBlackPieces().containsKey(key)) {
			gameModel.getgamePieces().getBlackPieces().remove(key);
		}
		else {
			gameModel.getgamePieces().getWhitePieces().remove(key);
		}
		
		return true;
	}



	/**
	 * 
	 * @return true if a killer move has been selected.
	 */
	public boolean assaultMoveSelected(GameSimulation gameSimulation) {
		boolean killerMove = false;

		try {
			if (gameSimulation.getPastCell().containsPiece() && gameSimulation.getPresentCell().containsPiece()
					&& gameSimulation.getCurrentPlayer().getChessColor() != gameSimulation.getPresentCell().getPiece()
							.getChessColor()
					&& gameSimulation.getPresentCell().getPiece().getChessColor() != gameSimulation.getPastCell()
							.getPiece().getChessColor()
					&& gameSimulation.getPastCell().getPiece().assaultMoves()
							.contains(gameSimulation.getPresentCell())) {
				killerMove = true;
			}
		} catch (Throwable e) {
		}
		return killerMove;
	} 
}
