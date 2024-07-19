package PieceDecorator;

import Piece.Queen;
import model.GameModel;

@SuppressWarnings("serial")
public abstract class QueenDecorator extends PieceDecorator{

	protected RookDecorator rookDecorator;
	protected BishopDecorator bishopDecorator;
	protected Queen queen;
	
	public QueenDecorator(String name, String path) {
		super(name,path);
	}

	public void initDecorators(Queen queen) {
		this.queen = queen;
	}
	
	
	public void setPossibleMoves(GameModel game) {
		initDecorators();
		setPositionDecorators();
		setPossibleMovesDecorators(game);
		mergePossibleMoves();
		mergeKillerMoves();
	}
	
	private void mergeKillerMoves() {
		
		rookDecorator.assaultMoves().addAll(bishopDecorator.assaultMoves());
		queen.setAssaultMoves(rookDecorator.assaultMoves());
		queen.getMoves().addAll(queen.assaultMoves());
	}
	private void mergePossibleMoves() {
		rookDecorator.getMoves().addAll(bishopDecorator.getMoves());
		queen.setMoves(rookDecorator.getMoves());
	}
	
	private void initDecorators () {
		rookDecorator = new RookDecorator(queen);
		bishopDecorator = new BishopDecorator(queen);
		rookDecorator.setChessColor(this.getChessColor());
		bishopDecorator.setChessColor(this.getChessColor());
	}
	
	private void setPositionDecorators() {
		rookDecorator.setPosition(queen.getPosition());
		bishopDecorator.setPosition(queen.getPosition());
	}
	
	private void setPossibleMovesDecorators(GameModel game) {
		rookDecorator.setPossibleMoves(game);
		bishopDecorator.setPossibleMoves(game);
	}
}
