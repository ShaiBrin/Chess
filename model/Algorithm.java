package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import Enums.ChessColor;
import Enums.ID;
import PieceDecorator.PieceDecorator;


public  class Algorithm {

	/**
	 * 
	 * @param point is the point on the board.
	 * @return the respective column on the board.
	 */
	public static short getColumnWithPoint(Point point) {
		
		short horizontalLocation = (short)point.x;
		short column = 0;

		if (horizontalLocation >= Constantes.CELL_SIZE * 1 && horizontalLocation <= (Constantes.CELL_SIZE * 2 - 1)) {
			column = 1;
		}

		if (horizontalLocation >= Constantes.CELL_SIZE * 2 && horizontalLocation <= (Constantes.CELL_SIZE * 3 - 1)) {
			column = 2;
		}

		if (horizontalLocation >= Constantes.CELL_SIZE * 3 && horizontalLocation <= (Constantes.CELL_SIZE * 4 - 1)) {
			column = 3;
		}

		if (horizontalLocation >= Constantes.CELL_SIZE * 4 && horizontalLocation <= (Constantes.CELL_SIZE * 5 - 1)) {
			column = 4;
		}

		if (horizontalLocation >= Constantes.CELL_SIZE * 5 && horizontalLocation <= (Constantes.CELL_SIZE * 6 - 1)) {
			column = 5;
		}

		if (horizontalLocation >= Constantes.CELL_SIZE * 6 && horizontalLocation <= (Constantes.CELL_SIZE * 7 - 1)) {
			column = 6;
		}

		if (horizontalLocation >= Constantes.CELL_SIZE * 7) {
			column = 7;
		}
		
		if(horizontalLocation >= Constantes.CELL_SIZE * 8  || horizontalLocation < 0) {
			column = 8;
		}

		return column;
	}
	
	/**
	 * 
	 * @param point is the point on the board.
	 * @return the respective row on the board.
	 */
	public static short getRowWithPoint(Point point) {
		short row = 8;
		short verticalLocation = (short)point.y;

		if (verticalLocation >= Constantes.CELL_SIZE * 1 && verticalLocation <= (Constantes.CELL_SIZE * 2 - 1)) {
			row = 7;
		}

		if (verticalLocation >= Constantes.CELL_SIZE * 2 && verticalLocation <= (Constantes.CELL_SIZE * 3 - 1)) {
			row = 6;
		}

		if (verticalLocation >= Constantes.CELL_SIZE * 3 && verticalLocation <= (Constantes.CELL_SIZE * 4 - 1)) {
			row = 5;
		}

		if (verticalLocation >= Constantes.CELL_SIZE * 4 && verticalLocation <= (Constantes.CELL_SIZE * 5 - 1)) {
			row = 4;
		}

		if (verticalLocation >= Constantes.CELL_SIZE * 5 && verticalLocation <= (Constantes.CELL_SIZE * 6 - 1)) {
			row = 3;
		}

		if (verticalLocation >= Constantes.CELL_SIZE * 6 && verticalLocation <= (Constantes.CELL_SIZE * 7 - 1)) {
			row = 2;
		}

		if (verticalLocation >= Constantes.CELL_SIZE * 7 && verticalLocation <= (Constantes.CELL_SIZE * 8 - 1) ) {
			row = 1;
		}
		
		if(verticalLocation < 0 || verticalLocation >=  Constantes.CELL_SIZE*8) {
			row = 0;
		}
		
		return row;	
	}
	

	
	/**
	 * 
	 * @param color is the color of the square
	 * .
	 * @param rowCounter is the position of the row on the board.
	 * @param columnCounter is the position of the columns on the board.
	 * @return
	 */
	public static Color switchColors(int rowCounter, int columnCounter) {

		Color color = null;
		if (columnCounter % 2 == 0) {
			if (rowCounter % 2 == 0) {
				color =  Constantes.paleColor;
			} else {
				color = Constantes.solidColor;
			}
		}

		else {
			if (rowCounter % 2 == 0) {
				color = Constantes.solidColor;
			} else {
				color = Constantes.paleColor;
			}
		}
		
		return color;
	}
 
	
	public static Cell getKingCell(GameModel gameModel, ChessColor color) {
		
		if(color.equals(ChessColor.BLACK)) {
			return getCellWithCoordinate(gameModel,getChessCoordinate(gameModel,gameModel.getgamePieces().getBlackPieces().get(ID.BLACK_KING).getPosition()));
		}
		
		else {
			return getCellWithCoordinate(gameModel,getChessCoordinate(gameModel,gameModel.getgamePieces().getWhitePieces().get(ID.WHITE_KING).getPosition()));
		}
	}

	/**
	 * 
	 * @param game is the game.
	 * @param column is column on the board.
	 * @param row is the row on the board.
	 * @return the chess coordinate of the board.
	 */
	public static String getChessCoordinateWithRowAndColumn(GameModel game, int column, int row) {
		return game.getchessBoard().getlistOfChars()[column] + Integer.toString(row);
	}

	/**
	 * 
	 * @param cell is the cell.
	 * @param color is the color.
	 */
	public static void setCellColor(Cell cell, Color color) {
		cell.setColor(color);
	}
	
	/**
	 * 
	 * @param g is the graphics.
	 * @param color is the color.
	 */
	public static void setGraphicsColor(Graphics g, Color color) {
		g.setColor(color);
	}
	
	
	public static void printInfoCells(Cell pastCell, Cell presentCell) {
		try {
			System.out.print("Past Cell: ");
			Algorithm.printInfoCell(pastCell);
		} catch (Exception e) {
			System.out.print("null ");
		}
		System.out.println();
		System.out.print("Present Cell: ");
		Algorithm.printInfoCell(presentCell);
		System.out.println();
	}

	/**
	 * prints info on the specific cell.
	 * @param cell is the cell.
	 */
	public static void printInfoCell(Cell cell){
		System.out.print(cell.containsPiece()+" " + cell.getChessPosition());
	}

	/**
	 * 
	 * @param game is the game.
	 * @param point is the point.
	 * @return the chess coordinate.
	 */
	public static String getChessCoordinate(GameModel game, Point point) {
		short column =  Algorithm.getColumnWithPoint(point);
		short row =  Algorithm.getRowWithPoint(point);
		return game.getchessBoard().getChessCoordinatesWithRowAndColumn(column, row);
	}
	
	/**
	 * 
	 * @param game is the game.
	 * @param chessCoordinate is the chess coordinate.
	 * @return the cell with the associate chess coordinate.
	 */
	public static Cell getCellWithCoordinate(GameModel game, String chessCoordinate) {
		return game.getListCells().get(chessCoordinate);
	}


	/**
	 * 
	 * @param game is the game.
	 * @param point is the point.
	 * @return the cell with the associated point.
	 */
	public static Cell getCellWithPoint(GameModel game, Point point) {
		
		if (point != null) {
			String chessCoordinate = Algorithm.getChessCoordinate(game, point);
			return Algorithm.getCellWithCoordinate(game, chessCoordinate);

		}
		return null;
	
	}
	
	/**
	 * 
	 * @param point is the point
	 * @return true if the point is on the chess board.
	 */
	public static boolean pointOnBoard(Point point) {
		
		if(point == null) {
			return false;
		}
		
		short column = getColumnWithPoint(point);
		short row = getRowWithPoint(point);
		
		if(row == 0 || column == 8) {
			return false;
		}
		
		else {
			return true;
		}
	}
	
	
	/**
	 * 
	 * @param point is the specific point.
	 * @param horizontalIndex is the horizontal index.
	 * @param verticalIndex is the vertical index.
	 * @return the point associated with the vertical and horizontal indexes.
	 */
	public static Point getPointWithIndexes(Point point, short horizontalIndex, short verticalIndex) {		
		Point newPoint = new Point (point.x + horizontalIndex * Constantes.CELL_SIZE, point.y - verticalIndex * Constantes.CELL_SIZE);
		
		if(pointOnBoard(newPoint)){
			return newPoint;
		}
		else {
			return null;
		}
		
	}

	
	public static void setMoves(Cell cell, PieceDecorator piece) {
		if (cell.containsPiece() && cell.getPiece().getChessColor() != piece.getChessColor()) {
			piece.assaultMoves().add(cell);
			piece.getMoves().add(cell);
		}	
		
		if (!cell.containsPiece()) {
			piece.getMoves().add(cell);
		}		

	}

	
	
}
