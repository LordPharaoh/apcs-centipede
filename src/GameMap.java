import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;


public abstract class GameMap {

	protected List<MovingObject> movers;
	protected List<Drawable> drawers;
	Image backgroundImage;
	
	public GameMap() {
		movers = new ArrayList<MovingObject>();
		drawers = new ArrayList<Drawable>();
		openBackgroundImage();
	}

	
	public abstract void openBackgroundImage();
	public abstract void tick();
	public abstract void draw(Graphics g);

	public void addMover(MovingObject go) {
		movers.add(go);
	}
	public void addDrawer(Drawable d) {
		drawers.add(d);
	}
	public void add(Object d) {
		if(d instanceof Drawable) {
			drawers.add((Drawable) d);
		}
		if(d instanceof MovingObject){
			movers.add((MovingObject) d);
		}
	}

}
