import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import java.util.Timer;
import java.util.TimerTask;


public class MovingObjectsPanel extends JPanel {
	
	final Dimension defaultDim;// = new Dimension(800,600);
	public static final int FRAME_RATE = 30;
	GameMap gm;
	private Timer t;// belongs to the class
	
	
	public MovingObjectsPanel(Dimension dim) {
		defaultDim = dim;
		this.setPreferredSize(defaultDim);
		//TODO decouple painting and ticking (low priority)
		gm = new CentipedeGameMap(defaultDim);// let the map know what dim is
		t = new Timer();
		t.schedule(new TimerTask(){
			public void run() {
				gm.tick();
				repaint();
			}
		}, 0, 1000/FRAME_RATE);
		
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// TODO paint gamemap
		gm.draw(g);
	}

}
