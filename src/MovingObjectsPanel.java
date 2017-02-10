import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;


public class MovingObjectsPanel extends JPanel {
	
	final Dimension defaultDim;// = new Dimension(800,600);
	GameMap gm;
	private Timer t;// belongs to the class
	
	
	public MovingObjectsPanel(Dimension dim) {
		defaultDim = dim;
		this.setPreferredSize(defaultDim);
		makeGameMap();
		t.start();// start the timer which starts the "ticking"
	}
	private void makeGameMap() {
		//TODO decouple painting and ticking (low priority)
		gm = new CentipedeGameMap(defaultDim);// let the map know what dim is
		t = new Timer(10, new ActionListener() {// fires off every 10 ms
			@Override
			public void actionPerformed(ActionEvent arg0) {
				gm.tick();// I tell the GameMap to tick... do what
					// you do every time the clock goes off.
				repaint();// naturally, we want to see the new view
			}
		});
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO paint gamemap
		gm.draw(g);
	}

}
