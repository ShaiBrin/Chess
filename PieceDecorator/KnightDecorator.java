package PieceDecorator;

import java.awt.Point;

import Enums.KnightDirections;
import model.Algorithm;
import model.Cell;
import model.GameModel;

@SuppressWarnings("serial")
public abstract class KnightDecorator extends PieceDecorator {

	private short horizontalIndex;
	private short verticalIndex;

	public KnightDecorator(String name, String path) {
		super(name, path);
	}
	
	
	public void setPossibleMoves(GameModel game) {
		super.setPossibleMoves(game);
		for (KnightDirections direction : KnightDirections.values()) {
			setDirections(game, direction);
		}
	}

	private void setDirections(GameModel game, KnightDirections direction) {
		setIndexes(direction);
		Point point = Algorithm.getPointWithIndexes(getPosition(), horizontalIndex, verticalIndex);
		if (Algorithm.pointOnBoard(point)) {
			Cell cell = Algorithm.getCellWithPoint(game, point);
			Algorithm.setMoves(cell,this);
		}
	}
	
	private void setIndexes(KnightDirections direction) {
		switch (direction) {
		case UP_VERTICAL_RIGHT:
			horizontalIndex = 1;
			verticalIndex = 2;
			break;

		case UP_HORIZONTAL_RIGHT:
			horizontalIndex = 2;
			verticalIndex = 1;
			break;

		case UP_VERTICAL_LEFT:
			horizontalIndex = -1;
			verticalIndex = 2;
			break;

		case UP_HORIZONTAL_LEFT:
			horizontalIndex = -2;
			verticalIndex = 1;
			break;

		case DOWN_VERTICAL_RIGHT:
			horizontalIndex = 1;
			verticalIndex = -2;
			break;

		case DOWN_HORIZONTAL_RIGHT:
			horizontalIndex = 2;
			verticalIndex = -1;
			break;

		case DOWN_HORIZONTAL_LEFT:
			horizontalIndex = -2;
			verticalIndex = -1;
			break;

		case DOWN_VERTICAL_LEFT:
			horizontalIndex = -1;
			verticalIndex = -2;
			break;
		}
	}

}
