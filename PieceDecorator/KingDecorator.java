package PieceDecorator;
import java.awt.Point;

import Enums.DiagonalDirections;
import Enums.LateralDirections;
import model.Algorithm;
import model.Cell;
import model.GameModel;

@SuppressWarnings("serial")
public class KingDecorator extends PieceDecorator{

	protected short horizontalIndex;
	protected short verticalIndex;
	protected boolean border = false;
	public KingDecorator(String name, String path) {
		super(name, path);
	}
	
	
	@Override
	public void setPossibleMoves(GameModel game) {
		initMoves();
		initAssaultMoves();
		for (LateralDirections direction : LateralDirections.values()) {
			setDirections(game, direction);
		}
		
		for (DiagonalDirections direction : DiagonalDirections.values()) {
			setDirectionss(game, direction);
		}	
	}
	
	public void setDirectionss(GameModel game, DiagonalDirections direction) {
		setIndexess(direction);
		Point point = Algorithm.getPointWithIndexes(getPosition(), horizontalIndex, verticalIndex);
		if (Algorithm.pointOnBoard(point)) {
			Cell cell = Algorithm.getCellWithPoint(game, point);
			if (!cell.containsPiece()) {
				super.getMoves().add(cell);
			} 
			else if(cell.containsPiece() && cell.getPiece().getChessColor()!= this.getChessColor()) {
				super.getMoves().add(cell);
				super.assaultMoves().add(cell);
				//cellHasPiece = false;

			}
			else {	
				//cellHasPiece = false;
			}
		}
		
	}
	public void setDirections(GameModel game, LateralDirections direction) {
		setIndexes(direction);
		Point point = Algorithm.getPointWithIndexes(getPosition(), horizontalIndex, verticalIndex);
		if (Algorithm.pointOnBoard(point)) {
			Cell cell = Algorithm.getCellWithPoint(game, point);
			if (!cell.containsPiece()) {
				super.getMoves().add(cell);
			} 
			else if(cell.containsPiece() && cell.getPiece().getChessColor()!= this.getChessColor()) {
				super.getMoves().add(cell);
				super.assaultMoves().add(cell);
				//cellHasPiece = false;

			}
			else {	
				//cellHasPiece = false;
			}
		}
		
	}
	public void setIndexess(DiagonalDirections direction) {
		switch (direction) {
		case NORTH_EAST:
			horizontalIndex = 1;
			verticalIndex = 1;
			break;

		case NORTH_WEST:
		
			horizontalIndex = -1;
			verticalIndex = 1;
			break;
			

		case SOUTH_EAST:
			horizontalIndex = 1;
			verticalIndex = -1;
			break;

		case SOUTH_WEST:
			horizontalIndex = -1;
			verticalIndex = -1;
			break;
			
		default:
			break;
		}
	}
	public void setIndexes(LateralDirections direction) {
		switch (direction) {
		case NORTH:
			horizontalIndex = 0;
			verticalIndex = 1;
			break;

		case SOUTH:
		
			horizontalIndex = 0;
			verticalIndex = -1;
			break;
			

		case EAST:
			horizontalIndex = 1;
			verticalIndex = 0;
			break;

		case WEST:
			horizontalIndex = -1;
			verticalIndex = 0;
			break;
			
		default:
			break;
		}
	}

}
