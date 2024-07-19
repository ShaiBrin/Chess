package Piece;

import PieceDecorator.RookDecorator;

@SuppressWarnings("serial")
public class Rook extends RookDecorator {
	private static String name = "rook";

	public Rook(String path) {
		super(name,path);
	}
	
	
}
