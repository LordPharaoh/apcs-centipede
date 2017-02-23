import java.awt.Dimension;
import java.awt.Graphics;


public class CentipedeGameMap extends GameMap {

	//TODO implement scale
	public static double scale = 1;
	public void makeMushrooms(int n) {
		for(int i = 0; i < n; i++) {
			Mushroom m = new Mushroom(new Vector((int)Math.random()*100, 0));
			add(m);
		}
	}
	public void makeCentipede(int numSegments, int xVal) {
		for(int i = 0; i < numSegments; i++) {
			Centipede c = new Centipede(new Vector(xVal, -(i * Centipede.HEIGHT)));
			add(c);
		}
	}
	
	public CentipedeGameMap(Dimension dim) {
		//TODO open with dimensions
		makeMushrooms(100);
		makeCentipede(20, 100);
		Spider s = new Spider(new Vector(100, 100));

	}
	
	public CentipedeGameMap() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void openBackgroundImage() {
		// TODO Open the background image
		
	}

	@Override
	public void tick() {
		for(MovingObject mo : movers) {
			mo.move();
		}
	}

	@Override
	public void draw(Graphics g) {
		// TODO affinetransform to scale with window size
		for(Drawable d : drawers) {
			d.draw(g);
		}
	}

}
