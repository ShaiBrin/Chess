package model;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Consumer;

import Enums.ChessColor;
import Enums.ID;
import PieceDecorator.PieceDecorator;

public class Player {
	private String name;
	private Hashtable<ID, PieceDecorator> pieces;	
	private HashMap<PieceDecorator, HashSet<Cell>> uncheckMoves;
	private Thread thread;
	private ChessColor color;
	private boolean checked;

	public Player(String name, ChessColor color) {
		setName(name);
		setChessColor(color);
		setChecked(false);
	}
 
	public void setName(String name) {
		this.name = name;
	}
	
	public void setUnchekedMoves(GameModel game, Player opponentPlayer) {
		
		opponentPlayer.pieces.forEach((key,piece)->{
			piece.setPossibleMoves(game);
		});
		
		
		pieces.forEach((key, piece) -> {
			piece.setPossibleMoves(game);
			while (piece.getMoves().iterator().hasNext()) {
				piece.movePiece(piece.getMoves().iterator().next().getLocation());
				opponentPlayer.setPossibleMoves(game, this);
			}
		});
	}
	

	public void setPossibleMoves(GameModel gameModel, Player opponentPlayer) {
		Enumeration<PieceDecorator> enumPieces = pieces.elements();
		System.out.println("Player name:" + name+" size: " + pieces.size());
		boolean checked = false;
		while(enumPieces.hasMoreElements() && !checked) {
			PieceDecorator currentPiece = enumPieces.nextElement();	
			currentPiece.setPossibleMoves(gameModel);
			if(pieceChecking(gameModel,currentPiece,opponentPlayer)) {		
				System.out.println(currentPiece.getUniqueID());
				checked = true;
				opponentPlayer.setChecked(true);
				System.out.println(name+" is checking " + opponentPlayer.name);
			}
			else {
				opponentPlayer.setChecked(false);
			}
		}
	}

	
	public boolean pieceChecking(GameModel gameModel, PieceDecorator piece, Player opponentPlayer) {
		boolean checked = false;
		Cell kingCell = Algorithm.getKingCell(gameModel, opponentPlayer.getChessColor());
		if(piece.assaultMoves().contains(kingCell)){
			checked = true;
		}
		return checked;
	}
		
	
	public String getName() {
		return name;
	}
 

	public Hashtable<ID, PieceDecorator> getPlayerPieces() {
		return pieces;
	}

	public void setPlayerPieces(Hashtable<ID, PieceDecorator> playerPieces) {
		this.pieces = playerPieces;
	}

	public Thread getThread() {
		return thread;
	}

	public void setThread(Thread thread) {
		this.thread = thread;
	
	}

	public ChessColor getChessColor() {
		return color;
	}

	public void setChessColor(ChessColor color) {
		this.color = color;
	}



	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

}
