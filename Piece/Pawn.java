package Piece;

import PieceDecorator.PawnDecorator;

@SuppressWarnings("serial")
public class Pawn extends PawnDecorator {

	private static String name = "pawn";

	public Pawn(String path) {
		super(name, path);
	}
}
	
	
	
	
	
	

