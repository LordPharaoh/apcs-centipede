import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Map;

import javax.swing.JFrame;


public class MovingObjectsGameLauncher {
	public static final int DEFAULT_SIZE = 800;
	public static void main(String[] args) {
		JFrame gameFrame = new JFrame();
		gameFrame.setSize(DEFAULT_SIZE, DEFAULT_SIZE);
		Map<String,String> environMap= System.getenv();
		System.out.println(environMap.keySet());
		
		//Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		
		MovingObjectsPanel mop = new MovingObjectsPanel(new Dimension(1000, 1000));
		gameFrame.add(mop);
		gameFrame.pack();
		gameFrame.setVisible(true);
		gameFrame.setDefaultCloseOperation(gameFrame.EXIT_ON_CLOSE);
	}

}
