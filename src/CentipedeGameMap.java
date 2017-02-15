import java.awt.Dimension;
import java.awt.Graphics;


public class CentipedeGameMap extends GameMap {

	//TODO implement scale
	public static double scale = 1;
	
	public CentipedeGameMap(Dimension dim) {
		//TODO open with dimensions
		Mushroom m = new Mushroom(new Vector((int)Math.random()*100, 0));
		Centipede c = new Centipede(new Vector((int)Math.random()*100, 0));
		add(m);
		add(c);
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
