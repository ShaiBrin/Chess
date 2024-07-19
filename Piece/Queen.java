package Piece;

import PieceDecorator.QueenDecorator;
import model.GameModel;

@SuppressWarnings("serial")
public class Queen extends QueenDecorator{
	private static String name = "queen";
	
	public Queen(String path) {
		super(name, path);
	}

	@Override
	public void setPossibleMoves(GameModel game) {
		super.initDecorators(this);
		super.setPossibleMoves(game);
	}
}

	

