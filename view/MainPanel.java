package view;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

import model.GameModel;
import model.PaintAlgorithm;
import model.PanelAlgorithm;

@SuppressWarnings("serial")
public class MainPanel extends JPanel implements MouseListener {

	protected GamePanel gamePanel;
	protected PanelAlgorithm panelAlgorithm;
 	
	public MainPanel(GameModel gameModel) {
		super();
		initParemeters(gameModel);
		addPanels();
		addMouseListener(this);	
	}

	public void paint(Graphics g) {
		super.paint(g);
		gamePanel.paint(g);
		panelAlgorithm.paint(g, this);
	}
	
	@Override
	public void mouseReleased(MouseEvent arg0) {
		panelAlgorithm.mouseReleased(arg0);
		repaint();
	}
	
	
	public void initParemeters(GameModel gameModel) {
		panelAlgorithm = new PanelAlgorithm(gameModel);
		gamePanel = new GamePanel(gameModel, panelAlgorithm);	
	}
	
	public void addPanels() {
		this.add(gamePanel);
	}
	


	@Override
	public void mouseClicked(MouseEvent event) {
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {

		// TODO Auto-generated method stub
	}
	
	public GamePanel getGamePanel() {
		return gamePanel;
	}
}
