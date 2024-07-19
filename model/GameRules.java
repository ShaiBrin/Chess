package model;

import java.util.HashMap;
import java.util.HashSet;

import Enums.ChessColor;
import Enums.ID;
import PieceDecorator.PieceDecorator;

public class GameRules {

	private Player player1;
	private Player player2;
	private boolean player1Turn;

	public GameRules(GameModel gameModel) {
		initPlayers();
		initPlayersPieces(gameModel);
		initTurn();
	}

	public void initPlayers() {
		player1 = new Player("player 1", ChessColor.WHITE);
		player2 = new Player("player 2", ChessColor.BLACK);
	}

	public void initPlayersPieces(GameModel gameModel) {
		player1.setPlayerPieces(gameModel.getgamePieces().getWhitePieces());
		player2.setPlayerPieces(gameModel.getgamePieces().getBlackPieces());
	}

	public void initTurn() {
		player1Turn = true;
	}

	
	public void switchTurns() {
		if (player1Turn) {
			player1Turn = false;
		}

		else {
			player1Turn = true;
		}
	}

	public void setPossibleMoves(GameModel gameModel) {
			player1.setPossibleMoves(gameModel, player2);
			player2.setPossibleMoves(gameModel, player1);
	}

	Processor process = new Processor();

	public void setPlayersThread(GameModel game) {
		player1.setThread(new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					process.player1Move();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}));

		player2.setThread(new Thread(new Runnable() {

			@Override
			public void run() {
			//	setPossibleMoves(game);
			}

		}));
	}

	public boolean getPlayer1Turn() {
		return player1Turn;
	}

	public Player getPlayer1() {
		return player1;
	}

	public Player getPlayer2() {
		return player2;
	}

}
