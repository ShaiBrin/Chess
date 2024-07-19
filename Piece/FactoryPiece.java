package Piece;

import Enums.ChessColor;
import Enums.Pieces;
import model.Constantes;

public class FactoryPiece {

	
	public Piece createPiece(Pieces pieceName) {
		
		Piece piece = null;
		
		switch (pieceName) {

		case BLACK_PAWN:
			piece =  new Pawn(Constantes.BLACKPAWN_PATH);
			piece.setChessColor(ChessColor.BLACK);
			piece.setValue(100);
			break;
		case BLACK_BISHOP:
			piece =  new Bishop(Constantes.BLACKBISHOP_PATH);
			piece.setChessColor(ChessColor.BLACK);
			piece.setValue(350);
			break;
		case BLACK_KING:
			piece =  new King(Constantes.BLACKKING_PATH);
			piece.setChessColor(ChessColor.BLACK);
			piece.setValue(10000);
			break;
		case BLACK_QUEEN:
			piece =  new Queen(Constantes.BLACKQUEEN_PATH);
			piece.setChessColor(ChessColor.BLACK);
			piece.setValue(1000);
			break;
		case BLACK_KNIGHT:
			piece =  new Knight(Constantes.BLACKKNIGHT_PATH);
			piece.setChessColor(ChessColor.BLACK);
			piece.setValue(350);
			break;
		case BLACK_ROOK:
			piece =  new Rook(Constantes.BLACKROOK_PATH);
			piece.setChessColor(ChessColor.BLACK);
			piece.setValue(525);
			break;
			
			
		case WHITE_PAWN:
			piece =  new Pawn(Constantes.WHITEPAWN_PATH);
			piece.setChessColor(ChessColor.WHITE);
			piece.setValue(100);

			break;
		case WHITE_BISHOP:
			piece =  new Bishop(Constantes.WHITEBISHOP_PATH);
			piece.setChessColor(ChessColor.WHITE);
			piece.setValue(350);

			break;
		case WHITE_KING:
			piece =  new King(Constantes.WHITEKING_PATH);
			piece.setChessColor(ChessColor.WHITE);
			piece.setValue(10000);

			break;
		case WHITE_QUEEN:
			piece =  new Queen(Constantes.WHITEQUEEN_PATH);
			piece.setChessColor(ChessColor.WHITE);
			piece.setValue(1000);
			break;
		case WHITE_KNIGHT:
			piece =  new Knight(Constantes.WHITEKNIGHT_PATH);
			piece.setChessColor(ChessColor.WHITE);
			piece.setValue(10000);
			break;
		case WHITE_ROOK:
			piece =  new Rook(Constantes.WHITEROOK_PATH);
			piece.setChessColor(ChessColor.WHITE);
			piece.setValue(525);

			break;	
		default:
			break;
		}
		
		return piece;
	}
	
}
