package Piece;

import PieceDecorator.KingDecorator;

@SuppressWarnings("serial")
public class King extends KingDecorator{

	
	private static String name = "king";
	
	public King(String path) {
		super(name, path);
	}




}
