package PieceDecorator;

import java.awt.Point;

import Enums.LateralDirections;
import model.Algorithm;
import model.Cell;
import model.Constantes;
import model.GameModel;

@SuppressWarnings("serial")
public  class RookDecorator extends PieceDecorator{

	protected int difference;
	protected short horizontalIndex;
	protected short verticalIndex;
	
	public RookDecorator(String name,String path) {
		super(name,path);		
	}
	
	public RookDecorator(PieceDecorator pieceDecorator) {
		super(pieceDecorator.getName(), pieceDecorator.getPath());
		
	};

	@Override
	public void setPossibleMoves(GameModel game) {
		super.setPossibleMoves(game);
		for (LateralDirections direction : LateralDirections.values()) {
			setDirections(game, direction);
		}		

	}
	
	private void setDirections(GameModel game, LateralDirections direction) {
		byte counter = 1;
		boolean cellHasPiece = true;
		setIndexes(direction);
		while (counter <= difference && cellHasPiece) {
			Point point = Algorithm.getPointWithIndexes(this.getPosition(), (short)(counter * horizontalIndex),
				(short)	(counter * verticalIndex));
			Cell cell = Algorithm.getCellWithPoint(game, point);
			counter++;
			if (!cell.containsPiece()) {
				super.getMoves().add(cell);
			} 
			else if(cell.containsPiece() && cell.getPiece().getChessColor()!= this.getChessColor()) {
				super.getMoves().add(cell);
				super.assaultMoves().add(cell);
				cellHasPiece = false;

			}
			else {	
				cellHasPiece = false;
			}
		}
	}
	
	public void setIndexes(LateralDirections direction) {
		switch (direction) {
		case NORTH:
			difference = (Constantes.NUMBER_ROWS - this.getRow());
			horizontalIndex = 0;
			verticalIndex = 1;
			break;

		case SOUTH:
			difference =  (this.getRow() - 1);
			horizontalIndex = 0;
			verticalIndex = -1;
			break;
			

		case EAST:
			difference = (Constantes.NUMBER_COLUMNS - 1 - this.getColumn());
			horizontalIndex = 1;
			verticalIndex = 0;
			break;

		case WEST:
			difference =  (this.getColumn());
			horizontalIndex = -1;
			verticalIndex = 0;
			break;
			
		default:
			break;
		}
	}

}
