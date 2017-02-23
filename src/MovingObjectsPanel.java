import java.awt.Dimension;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.MouseInfo;    
import javax.swing.JPanel;

import javax.swing.Timer;


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
		t = new Timer(1000/FRAME_RATE, new ActionListener() {// fires off every 10 ms
			@Override
			public void actionPerformed(ActionEvent arg0) {
				gm.tick();// I tell the GameMap to tick... do what
					// you do every time the clock goes off.
				repaint();// naturally, we want to see the new view
				
				//This sketchy stuff requests a mouse location every frame so it repaints
		        //MouseInfo.getPointerInfo().getLocation().y;
			}
		});
		t.start();
		
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// TODO paint gamemap
		gm.draw(g);
	}

}
