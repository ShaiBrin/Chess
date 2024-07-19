package model;

import java.util.Hashtable;

import Enums.ID;
import Piece.FactoryPiece;
import Piece.FactoryPieces;
import PieceDecorator.PieceDecorator;

public class GamePieces {

	private Hashtable<ID, PieceDecorator> blackChessPieces;
	private Hashtable<ID, PieceDecorator> whiteChessPieces;

	
	public GamePieces(GameBoard chessBoard) {
		initBlackPieces();
		initWhitePieces();
		init(chessBoard);
	}

	
	public void initBlackPieces() {
		blackChessPieces = new Hashtable<ID, PieceDecorator>();
	}
	
	public void initWhitePieces() {
		whiteChessPieces = new Hashtable<ID, PieceDecorator>();
	}
	public void init(GameBoard chessBoard) {
		new FactoryPieces(new FactoryPiece(), chessBoard, blackChessPieces, whiteChessPieces);
	}

	

	public Hashtable<ID, PieceDecorator> getBlackPieces() {
		
		return blackChessPieces;
	}

	public Hashtable<ID, PieceDecorator> getWhitePieces() {
		return whiteChessPieces;
	}
}
