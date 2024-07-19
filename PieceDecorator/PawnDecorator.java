package PieceDecorator;

import java.awt.Point;

import Enums.ChessColor;
import model.Algorithm;
import model.Cell;
import model.GameModel;

@SuppressWarnings("serial")
public class PawnDecorator extends PieceDecorator {

	private Point advanceOnePoint;
	private Point advanceTwicePoint;
	private Cell firstCell;
	private Cell secondCell;
	private short direction;
	private Point killerRightPoint;
	private Point killerLeftPoint;
	private Cell  killerRightCell;
	private Cell killerLeftCell;

	public PawnDecorator(String name, String path) {
		super(name, path);
	}

	@Override
	public void setPossibleMoves(GameModel game) {
		super.setPossibleMoves(game);
		if (this.getChessColor() == ChessColor.BLACK) {
			direction = 1;
		}

		else {
			direction = -1;
		}
		
		setPoints();
		
		try {setCells(game);}
		catch(Throwable e) {}
		movement();
		setKillersMoves(game);

	}

	
	
	
	public void setPoints() {
		advanceOnePoint = Algorithm.getPointWithIndexes(this.getPosition(), (short) 0, (short) (direction * 1));
		advanceTwicePoint = Algorithm.getPointWithIndexes(this.getPosition(), (short) 0, (short) (direction * 2));
	}

	public void setCells(GameModel game) {
		firstCell = Algorithm.getCellWithCoordinate(game, Algorithm.getChessCoordinate(game, advanceOnePoint));
		secondCell = Algorithm.getCellWithCoordinate(game, Algorithm.getChessCoordinate(game, advanceTwicePoint));
	}

	public void setKillersMoves(GameModel game) {
		killerRightPoint = Algorithm.getPointWithIndexes(this.getPosition(), (short)1, (short)(direction*1));
		killerLeftPoint = Algorithm.getPointWithIndexes(this.getPosition(), (short) -1, (short)(direction*1));
		killerRightCell = Algorithm.getCellWithPoint(game, killerRightPoint);
		killerLeftCell = Algorithm.getCellWithPoint(game,killerLeftPoint);
		
		try {
			if (killerRightCell.containsPiece() && killerRightCell.getPiece().getChessColor() != this.getChessColor()) {
				super.getMoves().add(killerRightCell);
				super.assaultMoves().add(killerRightCell);
			}
		} catch (Throwable e) {
		}

		try {
			if (killerLeftCell.containsPiece() && killerLeftCell.getPiece().getChessColor() != this.getChessColor()) {
				super.getMoves().add(killerLeftCell);
				super.assaultMoves().add(killerLeftCell);
			}
		} catch (Throwable e) {
		}
	}
	
	public void movement() {
		if (!super.hasMoved()) {
			if (!firstCell.containsPiece()) {
				super.getMoves().add(firstCell);
				if(!secondCell.containsPiece())
					super.getMoves().add(secondCell);
			}
		}

		else {
			if (!firstCell.containsPiece()) {
				super.getMoves().add(firstCell);
			}
		}
	}
}
