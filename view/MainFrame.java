package view;

import model.Constantes;
import model.GameModel;

import java.awt.Dimension;


import javax.swing.JFrame;



@SuppressWarnings("serial")
public class MainFrame extends JFrame{

	protected MainPanel frontEnd;
	protected GameModel backEnd;
	
	public MainFrame() {
		initBackEnd();
		initFrontEnd();
		startGame();
	}
	
	public void startGame() {
		backEnd.getThread().start();
	}
	
	public void initBackEnd() {
		backEnd = new GameModel();
	}
	
	public void setMainPanel() {
		frontEnd = new MainPanel(backEnd);
	}
	
	public void addPanel() {
		this.add(frontEnd);
	}
	
	public void initFrontEnd() {
		setTitle("Chess Game");
		setPreferredSize(new Dimension(Constantes.CANVAS_WIDTH, Constantes.CANVAS_HEIGHT));
		pack();
		setLocationRelativeTo(null);
		setResizable(false);
		setMainPanel();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		addPanel();
	}
	
}
