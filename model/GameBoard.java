package model;

import java.awt.Point;
import java.util.Hashtable;


public class GameBoard {
	
	protected Hashtable <String, Cell> cellMapWithCoordinates;
	protected static char[] listOfChars;
	protected boolean pieceSelected = false;
	
	public GameBoard () {
		setCoordinateSet();
	}
	
	public Hashtable<String, Cell> getListCells() {
		return cellMapWithCoordinates;
	}

	public char[] getlistOfChars() {
		return listOfChars;
	}
	
	public String getChessCoordinatesWithRowAndColumn(short column, short row) {
		return listOfChars[column] + Integer.toString(row);
	}
	
	private void setlistOfChars() {
		listOfChars = new char[Constantes.NUMBER_COLUMNS];
		listOfChars[0] = 'A';
		listOfChars[1] = 'B';
		listOfChars[2] = 'C';
		listOfChars[3] = 'D';
		listOfChars[4] = 'E';
		listOfChars[5] = 'F';
		listOfChars[6] = 'G';
		listOfChars[7] = 'H';
	}
	
	private void setCoordinateSet() {
		setlistOfChars();
		setColumns();
	}
	
	
	private void setRow(Point position, short numColumns) {
		for (short i = 0; i < Constantes.NUMBER_ROWS; i++) {
				Cell cell = new Cell();
				Point point = new Point(0,0);
				String chessCoordinate = listOfChars[i] + Integer.toString(numColumns);
				point.setLocation(position);
				cell.setCell(chessCoordinate, point);
				cellMapWithCoordinates.put(chessCoordinate, cell);
				position.setLocation(position.x + Constantes.CELL_SIZE, position.y);
			}
	}
	

	private void setColumns() {
		cellMapWithCoordinates = new Hashtable<String, Cell>();
		Point position = new Point(0, 0);
		for (short i = Constantes.NUMBER_ROWS; i > 0; i--) {
			 setRow(position, i );
			 position.setLocation(0, position.y + Constantes.CELL_SIZE);
		}
	}
	
}
