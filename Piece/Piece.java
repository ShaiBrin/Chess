package Piece;

import java.awt.Point;
import javax.swing.ImageIcon;

import Enums.ChessColor;
import Enums.ID;
import model.Algorithm;

/**
 * 
 * @author Ishr_
 *
 */
@SuppressWarnings("serial")
public abstract class Piece extends ImageIcon implements chessMoves{

	private Point currentPosition;
	private String name = "";
	private ID uniqueID;
	private ChessColor color;
	private static String path = "";
	private int value;

	/**
	 * is the constructor.
	 * @param name is the name of the piece.
	 * @param path is the path of the image Icon.
	 */
	protected Piece(String name, String path) {
		super(path);
		this.name = name;
		Piece.path = path;
	}
	
	/**
	 * sets the position of the piece.
	 * @param position is the current position of the piece.
	 */
	public void setPosition(Point position) {
		this.currentPosition = position;
	}
	
	/**
	 * sets the unique ID for the piece.
	 * @param uniqueID is the uniqueID for the piece.
	 */
	public void setUniqueID(ID uniqueID) {
		this.uniqueID = uniqueID;
	}
	
	/**
	 * sets the color of the chess piece.
	 * @param color is the chess color of the piece.
	 */
	public void setChessColor(ChessColor color) {
		this.color = color;
	}
	
	/**
	 * sets the path of the image icon
	 * @param path is the path of the image icon.
	 */
	protected void setPath(String path) {
		Piece.path = path;
	}

	/**
	 * sets the numeric value of the piece.
	 * @param value is the value of the piece.
	 */
	public void setValue(int value) {
		this.value = value;
	}
	
	/**
	 * 
	 * @return the row of the piece.
	 */
	public short getRow() {
		return Algorithm.getRowWithPoint(currentPosition);
	}

	/**
	 * 
	 * @return the column of the piece.
	 */
	public short getColumn() {
		return Algorithm.getColumnWithPoint(currentPosition);
	}
	
	/**
	 * 
	 * @return the imageIcon path of the piece.
	 */
	public String getPath() {
		return path;
	}
	

	/**
	 * 
	 * @return the position of the piece.
	 */
	public Point getPosition() {
		return currentPosition;
	}

	/**
	 * 
	 * @return the name of the piece.
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @return the chess Color of the piece.
	 */
	public ChessColor getChessColor() {
		return color;
	}

	/**
	 * 
	 * @return the unique ID of the piece.
	 */
	public ID getUniqueID() {
		return uniqueID;
	}

	/**
	 * 
	 * @return the numeric value of the piece.
	 */
	public int getValue() {
		return value;
	}
}
