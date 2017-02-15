import java.awt.Dimension;
import java.awt.Graphics;


public class CentipedeGameMap extends GameMap {

	
	public CentipedeGameMap(Dimension dim) {
		//TODO open with dimensions
		Mushroom m = new Mushroom(new Vector((int)Math.random()*100, 0));
		addDrawer(m);
		addMover(m);
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
		// TODO Auto-generated method stub
		for(MovingObject mo : movers) {
			mo.move();
		}
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		for(Drawable d : drawers) {
			d.draw(g);
		}
	}

}
