package model;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;

import PieceDecorator.PieceDecorator;

@SuppressWarnings("serial")
public class Cell extends Point {	
	protected short column;
	protected short row;
	protected boolean containsPiece = false;
	protected String chessPosition = "";
	protected Color color;
	protected PieceDecorator piece;

	public Cell(String chessPosition, Point position) {
		setCell(chessPosition, position);
	}
	
	public Cell() {}

	public void setPositionPiece() {
		piece.setPosition(this.getLocation());
	}
	
	public void setCell(String chessPosition, Point position) {
		setCoordinatePosition(chessPosition);
		this.setLocation(position);
	}
	
	public void setCoordinatePosition(String chessPosition) {
		this.chessPosition = chessPosition;
	}

	public void setContainsPiece(boolean occupied) {
		this.containsPiece = occupied;
	}
	

	public void setColor(Color color) {
		this.color = color;
	}
	
	
	public void setPiece(PieceDecorator piece) {
		if(piece == null) {
			this.piece = null;
			setContainsPiece(false);
		}
		 
		else {
		this.piece = piece;
		setContainsPiece(true);
		setPositionPiece();
		}
	}
	
	public boolean containsPiece() {
		return containsPiece;
	} 
	
	public String getChessPosition() {
		return chessPosition;
	}
	
	public Color getColor() {
		return color;
	}
	
	public short getRow() {
		return (short) Algorithm.getRowWithPoint(this.getLocation());
	}

	public short getColumn() {
		return (short) Algorithm.getColumnWithPoint(this.getLocation());
	}
	
	public PieceDecorator getPiece() {
		return piece;
	}
}
