package Piece;

import java.util.Hashtable;


import Enums.ID;
import Enums.Pieces;
import PieceDecorator.PieceDecorator;
import model.GameBoard;

public class FactoryPawn {

	private Pawn black_firstPawn;
	private Pawn black_secondPawn;
	private Pawn black_thirdPawn;
	private Pawn black_fourthPawn;
	private Pawn black_fifthPawn;
	private Pawn black_sixthPawn;
	private Pawn black_seventhPawn;
	private Pawn black_eightPawn;
	
	private Pawn white_firstPawn;
	private Pawn white_secondPawn;
	private Pawn white_thirdPawn;
	private Pawn white_fourthPawn;
	private Pawn white_fifthPawn;
	private Pawn white_sixthPawn;
	private Pawn white_seventhPawn;
	private Pawn white_eightPawn;	
	
	public FactoryPawn(FactoryPiece pieceFactory, GameBoard chessBoard, 
			Hashtable<ID, PieceDecorator> blackChessPieces,
			Hashtable<ID, PieceDecorator> whiteChessPieces) {
		
		createBlackPawns(pieceFactory, Pieces.BLACK_PAWN);
		createWhitePawns(pieceFactory, Pieces.WHITE_PAWN);
		
		setBlackPawnsinitialLocation(chessBoard);
		setWhitePawnsinitialLocation(chessBoard);
		setUniqueIDs();
		initBlackListofPawns(blackChessPieces);
		initWhiteListOfPawns(whiteChessPieces);
	}
	
	
	private void setUniqueIDs() {
		black_firstPawn.setUniqueID(ID.BLACK_PAWN_1);
		black_secondPawn.setUniqueID(ID.BLACK_PAWN_2);
		black_thirdPawn.setUniqueID(ID.BLACK_PAWN_3);
		black_fourthPawn.setUniqueID(ID.BLACK_PAWN_4);
		black_fifthPawn.setUniqueID(ID.BLACK_PAWN_5);
		black_sixthPawn.setUniqueID(ID.BLACK_PAWN_6);
		black_seventhPawn.setUniqueID(ID.BLACK_PAWN_7);
		black_eightPawn.setUniqueID(ID.BLACK_PAWN_8);
		
		white_firstPawn.setUniqueID(ID.WHITE_PAWN_1);
		white_secondPawn.setUniqueID(ID.WHITE_PAWN_2);
		white_thirdPawn.setUniqueID(ID.WHITE_PAWN_3);
		white_fourthPawn.setUniqueID(ID.WHITE_PAWN_4);
		white_fifthPawn.setUniqueID(ID.WHITE_PAWN_5);
		white_sixthPawn.setUniqueID(ID.WHITE_PAWN_6);
		white_seventhPawn.setUniqueID(ID.WHITE_PAWN_7);
		white_eightPawn.setUniqueID(ID.WHITE_PAWN_8);

	}
	private void createBlackPawns(FactoryPiece pieceFactory, Pieces pawn) {
		black_firstPawn = (Pawn) pieceFactory.createPiece(pawn);
		black_secondPawn = (Pawn) pieceFactory.createPiece(pawn);
		black_thirdPawn = (Pawn) pieceFactory.createPiece(pawn);
		black_fourthPawn = (Pawn) pieceFactory.createPiece(pawn);
		black_fifthPawn = (Pawn) pieceFactory.createPiece(pawn);
		black_sixthPawn = (Pawn) pieceFactory.createPiece(pawn);
		black_seventhPawn = (Pawn) pieceFactory.createPiece(pawn);
		black_eightPawn = (Pawn) pieceFactory.createPiece(pawn);
	}
	
	private void createWhitePawns(FactoryPiece pieceFactory, Pieces pawn) {
		white_firstPawn = (Pawn) pieceFactory.createPiece(pawn);
		white_secondPawn = (Pawn) pieceFactory.createPiece(pawn);
		white_thirdPawn = (Pawn) pieceFactory.createPiece(pawn);
		white_fourthPawn = (Pawn) pieceFactory.createPiece(pawn);
		white_fifthPawn = (Pawn) pieceFactory.createPiece(pawn);
		white_sixthPawn = (Pawn) pieceFactory.createPiece(pawn);
		white_seventhPawn = (Pawn) pieceFactory.createPiece(pawn);
		white_eightPawn = (Pawn) pieceFactory.createPiece(pawn);
	}
	
	private void setBlackPawnsinitialLocation(GameBoard chessBoard) {
		black_firstPawn.setPosition(chessBoard.getListCells().get("A2"));
		black_secondPawn.setPosition(chessBoard.getListCells().get("B2"));
		black_thirdPawn.setPosition(chessBoard.getListCells().get("C2"));
		black_fourthPawn.setPosition(chessBoard.getListCells().get("D2"));
		black_fifthPawn.setPosition(chessBoard.getListCells().get("E2"));
		black_sixthPawn.setPosition(chessBoard.getListCells().get("F2"));
		black_seventhPawn.setPosition(chessBoard.getListCells().get("G2"));
		black_eightPawn.setPosition(chessBoard.getListCells().get("H2"));
	}
	
	private void setWhitePawnsinitialLocation(GameBoard chessBoard) {
		white_firstPawn.setPosition(chessBoard.getListCells().get("A7"));
		white_secondPawn.setPosition(chessBoard.getListCells().get("B7"));
		white_thirdPawn.setPosition(chessBoard.getListCells().get("C7"));
		white_fourthPawn.setPosition(chessBoard.getListCells().get("D7"));
		white_fifthPawn.setPosition(chessBoard.getListCells().get("E7"));
		white_sixthPawn.setPosition(chessBoard.getListCells().get("F7"));
		white_seventhPawn.setPosition(chessBoard.getListCells().get("G7"));
		white_eightPawn.setPosition(chessBoard.getListCells().get("H7"));
	}
	
	
	
	private void initBlackListofPawns(Hashtable<ID, PieceDecorator> blackChessPieces) {
		blackChessPieces.put(ID.BLACK_PAWN_1,black_firstPawn);
		blackChessPieces.put(ID.BLACK_PAWN_2,black_secondPawn);
		blackChessPieces.put(ID.BLACK_PAWN_3,black_thirdPawn);
		blackChessPieces.put(ID.BLACK_PAWN_4,black_fourthPawn);
		blackChessPieces.put(ID.BLACK_PAWN_5,black_fifthPawn);
		blackChessPieces.put(ID.BLACK_PAWN_6,black_sixthPawn);
		blackChessPieces.put(ID.BLACK_PAWN_7,black_seventhPawn);
		blackChessPieces.put(ID.BLACK_PAWN_8,black_eightPawn);
	}
	
	private void initWhiteListOfPawns(Hashtable<ID, PieceDecorator> whiteChessPieces) {
		whiteChessPieces.put(ID.WHITE_PAWN_1,white_firstPawn);
		whiteChessPieces.put(ID.WHITE_PAWN_2,white_secondPawn);
		whiteChessPieces.put(ID.WHITE_PAWN_3,white_thirdPawn);
		whiteChessPieces.put(ID.WHITE_PAWN_4,white_fourthPawn);
		whiteChessPieces.put(ID.WHITE_PAWN_5,white_fifthPawn);
		whiteChessPieces.put(ID.WHITE_PAWN_6,white_sixthPawn);
		whiteChessPieces.put(ID.WHITE_PAWN_7,white_seventhPawn);
		whiteChessPieces.put(ID.WHITE_PAWN_8,white_eightPawn);
	}
	
	
}

