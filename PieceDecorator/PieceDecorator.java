package PieceDecorator;

import java.awt.Point;
import java.util.HashSet;
import java.util.Set;
import Piece.Piece;
import model.Cell;
import model.GameModel;

@SuppressWarnings("serial")
/**
 * 
 * @author Ishr_
 *
 */
public abstract class PieceDecorator extends Piece {
	
	private Set<Cell> moves;
	private Set<Cell> assaultMoves;
	private boolean hasMoved = false;
	
	
	/**
	 * 
	 * @param name is the name of the piece.
	 * @param path is the path for the icon.
	 */
	public PieceDecorator(String name, String path) {
		super(name,path);
	}
	
	/**
	 * initializes the killer moves.
	 */
	public void initAssaultMoves() {
		assaultMoves =  new HashSet<Cell>();
	}
	
	/**
	 * initializes the moves of the piece.
	 */
	public void initMoves() {
		moves = new HashSet<Cell>();
	}
	
	/**
	 * 
	 * @param position is the position of the opponent piece.
	 */
	public void assaultPiece(Point position) {
		movePiece(position);
	}
	
	
	/**
	 * moves the piece 
	 * @param position is the position to be moved at.
	 */
	public void movePiece(Point position) {
		setPosition(position);
	}
	
	
	/**
	 *  sets the possible moves for the piece.
	 */
	public void setPossibleMoves(GameModel game) {
		initMoves();
		initAssaultMoves();
	}

	/**
	 * 
	 * @param assaultMoves is the set of the killer moves.
	 */
	public void setAssaultMoves(Set<Cell> assaultMoves) {
		this.assaultMoves = assaultMoves;
	}
	
	/**
	 * 
	 * @param moves is the set of the possible moves.
	 */
	public void setMoves(Set<Cell> moves) {
		this.moves = moves;
	}
	
	/**
	 * 
	 * @param hasMoved is the parameter if the piece has moved or not.
	 */
	public void setHasMoved(boolean hasMoved) {
		this.hasMoved = hasMoved;
	}
	
	/**
	 * 
	 * @return the possible moves of the piece.
	 */
	public Set<Cell> getMoves() {
		return moves;
	}
	
	/**
	 * 
	 * @return true if the piece has moved.
	 */
	public boolean hasMoved() {
		return hasMoved;
	}

	/**
	 * 
	 * @return the set of the killer moves.
	 */
	public Set<Cell> assaultMoves() {
		return assaultMoves;
	}
}
