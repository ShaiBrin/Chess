package src;
import javax.swing.SwingUtilities;

import view.MainFrame;

public class Main {
	protected static MainFrame game;
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				game = new MainFrame();
				game.setVisible(true);
			}
		});
	}
	
}
