package PieceDecorator;

import java.awt.Point;

import Enums.DiagonalDirections;
import model.Algorithm;
import model.Cell;
import model.Constantes;
import model.GameModel;


@SuppressWarnings("serial")
public class BishopDecorator extends PieceDecorator{

	protected short difference;
	protected short horizontalIndex;
	protected short verticalIndex;
	
	
	public BishopDecorator(String name, String path) {
		super(name,path);
	}
	
	public BishopDecorator(PieceDecorator pieceDecorator) {
		super(pieceDecorator.getName(), pieceDecorator.getPath());
	}
	
	public void setPossibleMoves(GameModel game) {
		super.setPossibleMoves(game);
		for (DiagonalDirections direction : DiagonalDirections.values()) {
			setDirections(game, direction);
		}		

	}

	public void setDirections(GameModel game, DiagonalDirections direction) {

		setIndexes(direction);
		setDifference(direction);
		short counter = 1;
		boolean hasPiece = true;
		while (counter <= difference && hasPiece) {
			Point point = Algorithm.getPointWithIndexes(getPosition(),  (short)(counter * horizontalIndex), (short)(counter * verticalIndex));
			Cell cell = Algorithm.getCellWithPoint(game, point);
			counter++;
			if (!cell.containsPiece()) {
				super.getMoves().add(cell);
			} 
			else if(cell.containsPiece() && cell.getPiece().getChessColor()!= this.getChessColor()) {
				super.getMoves().add(cell);
				super.assaultMoves().add(cell);
				hasPiece = false;

			}
			else {	
				hasPiece = false;
			}
			
		}
	}
	
	public void setDifference(DiagonalDirections direction) {
		if(southEast(getPosition()) && direction.equals(DiagonalDirections.NORTH_EAST)) {
			difference = (short) (Constantes.NUMBER_COLUMNS - 1 - this.getColumn());
		}
		
		if(!southEast(getPosition()) && direction.equals(DiagonalDirections.NORTH_EAST)) {
			difference = (short) (Constantes.NUMBER_ROWS - this.getRow());
		}
		
		
		if(southEast(getPosition()) && direction.equals(DiagonalDirections.SOUTH_WEST)) {
			difference = (short) (this.getRow() - 1);
		}
		
		if(!southEast(getPosition()) && direction.equals(DiagonalDirections.SOUTH_WEST)) {
			difference = (short) (this.getColumn());
		}
	
		if(northEast(getPosition()) && direction.equals(DiagonalDirections.NORTH_WEST)) {
			difference = (short) (Constantes.NUMBER_ROWS - this.getRow());
		}
		
		if(!northEast(getPosition()) && direction.equals(DiagonalDirections.NORTH_WEST)) {
			difference = (short) this.getColumn();
		}
		
		
		if(northEast(getPosition()) && direction.equals(DiagonalDirections.SOUTH_EAST)) {
			difference = (short) (Constantes.NUMBER_COLUMNS - 1 - this.getColumn());
		}
		
		if(!northEast(getPosition()) && direction.equals(DiagonalDirections.SOUTH_EAST)) {
			difference = (short) (this.getRow()-1);
		}

	}
	
	public void setIndexes(DiagonalDirections direction) {
		
		switch(direction) {
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
		}		
	}
	
	
	
	
	private  boolean southEast(Point point) {
		boolean southEast = false;
		short row = Algorithm.getRowWithPoint(point);
		short column = Algorithm.getColumnWithPoint(point);
		
		if(column>=row-1) {
			southEast = true;
		}
		else {
			southEast = false;
		}
		
		return southEast;
	}

	private  boolean northEast(Point point) {
		boolean northEast = false;
		short difference = 0;
		short row = Algorithm.getRowWithPoint(point);
		short column = Algorithm.getColumnWithPoint(point);
		
		difference = (short) (Constantes.NUMBER_ROWS - row);
		
		if(column >= (difference)) {
			northEast = true;
		}
		else {
			northEast = false;
		}
		
		return northEast;
	}

}
