package Piece;

import PieceDecorator.BishopDecorator;

@SuppressWarnings("serial")
public class Bishop extends BishopDecorator {

	private static String name = "bishop";

	public Bishop(String path) {
		super(name, path);
	}
}

