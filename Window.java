import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends Canvas {
	
	private static final long serialVersionUID = 9034494958129720942L;

	public Window(int w, int h, String title, Game game) {
		
		JFrame frame = new JFrame(title);
		frame.setPreferredSize(new Dimension(w, h));
		frame.setMinimumSize(new Dimension(w, h));
		frame.setMaximumSize(new Dimension(w, h));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.add(game);
		frame.setVisible(true);
		game.start();
		
	}
	
}