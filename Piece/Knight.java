package Piece;

import PieceDecorator.KnightDecorator;

@SuppressWarnings("serial")
public class Knight extends KnightDecorator{

	private static String name = "knight";
	public Knight(String path) {
		super(name, path);
	}
}
