package model;
import java.util.Hashtable;


public class GameModel {

	private GameBoard gameBoard;
	private GamePieces gamePieces;
	private GameRules gameRules;
	private GameThread gameThread;
	private GameSimulation gameSimulation;
	
	public GameModel () {
		initParameters();
	}
	
	public void initParameters() {
		gameBoard = new GameBoard();
		gamePieces = new GamePieces(gameBoard);
		putPiecesOnBoard(gameBoard);
		gameRules = new GameRules(this);
		gameThread =  new GameThread();
		gameSimulation = new GameSimulation(this);
	}
	
	
	
	public Hashtable<String, Cell> getListCells (){
		return gameBoard.getListCells();
	}
	
	public GameBoard getchessBoard() {
		return gameBoard;
	}
	
	public GamePieces getgamePieces() {
		return gamePieces;
	}

	public GameRules getGameRules() {
		return gameRules;
	}
	
	public Thread getThread() {
		return gameThread;
	}
	
	private void putPiecesOnBoard(GameBoard chessBoard) {
		gamePieces.getBlackPieces().forEach((key,value) -> {
			String chessCoordinate = Algorithm.getChessCoordinate(this,value.getPosition());
			Cell cell = Algorithm.getCellWithCoordinate(this, chessCoordinate);
			cell.setPiece(value);
		});
		
		gamePieces.getWhitePieces().forEach((key,value) -> {
			String chessCoordinate = Algorithm.getChessCoordinate(this,value.getPosition());
			Cell cell = Algorithm.getCellWithCoordinate(this, chessCoordinate);
			cell.setPiece(value);
		});
	}

	public GameSimulation getGameSimulation() {
		return gameSimulation;
	}


	
}
