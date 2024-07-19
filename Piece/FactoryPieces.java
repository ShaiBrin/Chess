package Piece;

import java.util.Hashtable;

import Enums.ID;
import Enums.Pieces;
import PieceDecorator.PieceDecorator;
import model.GameBoard;

public class FactoryPieces {

	private Bishop black_solidBishop;
	private Bishop black_paleBishop;
	private Rook black_leftRook;
	private Rook black_rightRook;
	private King black_king;
	private Knight black_leftKnight;
	private Knight black_rightKnight;
	private Queen black_queen;
	
	private Bishop white_solidBishop;
	private Bishop white_paleBishop;
	private Rook white_leftRook;
	private Rook white_rightRook;
	private King white_king;
	private Knight white_leftKnight;
	private Knight white_rightKnight;
	private Queen white_queen;
	
	public FactoryPieces(FactoryPiece pieceFactory, GameBoard chessBoard, 
			Hashtable<ID, PieceDecorator> blackchessPieces, 
			Hashtable<ID, PieceDecorator> whitechessPieces) {
		
		new FactoryPawn(pieceFactory, chessBoard, blackchessPieces, whitechessPieces);
		createPieces(pieceFactory);
		setUniqueIDs();
		setPiecesInitialsLocation(chessBoard);
		initPiecesInList(blackchessPieces,whitechessPieces);
	}
	
	private void setUniqueIDs() {
		black_solidBishop.setUniqueID(ID.BLACK_SOLID_BISHOP);
		black_paleBishop.setUniqueID(ID.BLACK_PALE_BISHOP);
		black_leftRook.setUniqueID(ID.BLACK_LEFT_ROOK);
		black_rightRook.setUniqueID(ID.BLACK_RIGHT_ROOK);
		black_king.setUniqueID(ID.BLACK_KING);
		black_leftKnight.setUniqueID(ID.BLACK_LEFT_KNIGHT);
		black_rightKnight.setUniqueID(ID.BLACK_RIGHT_KNIGHT);
		black_queen.setUniqueID(ID.BLACK_QUEEN);
	
		white_solidBishop.setUniqueID(ID.WHITE_SOLID_BISHOP);
		white_paleBishop.setUniqueID(ID.WHITE_PALE_BISHOP);
		white_leftRook.setUniqueID(ID.WHITE_LEFT_ROOK);
		white_rightRook.setUniqueID(ID.WHITE_RIGHT_ROOK);
		white_king.setUniqueID(ID.WHITE_KING);
		white_leftKnight.setUniqueID(ID.WHITE_LEFT_KNIGHT);
		white_rightKnight.setUniqueID(ID.WHITE_RIGHT_KNIGHT);
		white_queen.setUniqueID(ID.WHITE_QUEEN);
	}
	private void createPieces(FactoryPiece pieceFactory) {
		black_solidBishop = (Bishop)pieceFactory.createPiece(Pieces.BLACK_BISHOP);
		black_paleBishop = (Bishop)pieceFactory.createPiece(Pieces.BLACK_BISHOP);
		black_leftRook = (Rook)pieceFactory.createPiece(Pieces.BLACK_ROOK);
		black_rightRook = (Rook)pieceFactory.createPiece(Pieces.BLACK_ROOK);
		black_king = (King)pieceFactory.createPiece(Pieces.BLACK_KING);
		black_leftKnight = (Knight)pieceFactory.createPiece(Pieces.BLACK_KNIGHT);
		black_rightKnight = (Knight)pieceFactory.createPiece(Pieces.BLACK_KNIGHT);
		black_queen = (Queen)pieceFactory.createPiece(Pieces.BLACK_QUEEN);
		
		white_solidBishop = (Bishop)pieceFactory.createPiece(Pieces.WHITE_BISHOP);
		white_paleBishop = (Bishop)pieceFactory.createPiece(Pieces.WHITE_BISHOP);
		white_leftRook = (Rook)pieceFactory.createPiece(Pieces.WHITE_ROOK);
		white_rightRook = (Rook)pieceFactory.createPiece(Pieces.WHITE_ROOK);
		white_king = (King)pieceFactory.createPiece(Pieces.WHITE_KING);
		white_leftKnight = (Knight)pieceFactory.createPiece(Pieces.WHITE_KNIGHT);
		white_rightKnight = (Knight)pieceFactory.createPiece(Pieces.WHITE_KNIGHT);
		white_queen = (Queen)pieceFactory.createPiece(Pieces.WHITE_QUEEN);
		
	}
	
	private void setPiecesInitialsLocation(GameBoard chessBoard) {
		black_solidBishop.setPosition(chessBoard.getListCells().get("C1"));
		black_paleBishop.setPosition(chessBoard.getListCells().get("F1"));
		black_leftRook.setPosition(chessBoard.getListCells().get("A1"));
		black_rightRook.setPosition(chessBoard.getListCells().get("H1"));
		black_king.setPosition(chessBoard.getListCells().get("D1"));
		black_leftKnight.setPosition(chessBoard.getListCells().get("B1"));
		black_rightKnight.setPosition(chessBoard.getListCells().get("G1"));
		black_queen.setPosition(chessBoard.getListCells().get("E1"));
		
		white_solidBishop.setPosition(chessBoard.getListCells().get("C8"));
		white_paleBishop.setPosition(chessBoard.getListCells().get("F8"));
		white_leftRook.setPosition(chessBoard.getListCells().get("A8"));
		white_rightRook.setPosition(chessBoard.getListCells().get("H8"));
		white_king.setPosition(chessBoard.getListCells().get("D8"));
		white_leftKnight.setPosition(chessBoard.getListCells().get("B8"));
		white_rightKnight.setPosition(chessBoard.getListCells().get("G8"));
		white_queen.setPosition(chessBoard.getListCells().get("E8"));

	}
	
	private void initPiecesInList(Hashtable<ID, PieceDecorator> blackchessPieces, 
			Hashtable<ID, PieceDecorator> whitechessPieces) {
		blackchessPieces.put(ID.BLACK_SOLID_BISHOP,black_solidBishop);
		blackchessPieces.put(ID.BLACK_PALE_BISHOP,black_paleBishop);
		blackchessPieces.put(ID.BLACK_LEFT_ROOK,black_leftRook);
		blackchessPieces.put(ID.BLACK_RIGHT_ROOK, black_rightRook);
		blackchessPieces.put(ID.BLACK_KING, black_king);
		blackchessPieces.put(ID.BLACK_LEFT_KNIGHT, black_leftKnight);
		blackchessPieces.put(ID.BLACK_RIGHT_KNIGHT, black_rightKnight);
		blackchessPieces.put(ID.BLACK_QUEEN, black_queen);
		
		whitechessPieces.put(ID.WHITE_SOLID_BISHOP,white_solidBishop);
		whitechessPieces.put(ID.WHITE_PALE_BISHOP,white_paleBishop);
		whitechessPieces.put(ID.WHITE_LEFT_ROOK,white_leftRook);
		whitechessPieces.put(ID.WHITE_RIGHT_ROOK, white_rightRook);
		whitechessPieces.put(ID.WHITE_KING, white_king);
		whitechessPieces.put(ID.WHITE_LEFT_KNIGHT, white_leftKnight);
		whitechessPieces.put(ID.WHITE_RIGHT_KNIGHT, white_rightKnight);
		whitechessPieces.put(ID.WHITE_QUEEN, white_queen);
	}
}
