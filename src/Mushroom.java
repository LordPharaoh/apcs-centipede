import java.awt.Graphics;
import java.awt.Rectangle;


public class Mushroom implements MovingObject, Drawable {
	//TODO actual values
	public static final int MUSHROOM_WIDTH = 50;
	public static final int MUSHROOM_HEIGHT = 50;
	private Vector location;
	public Mushroom(Vector v) {
		//Make a mushroom
		
	}

	@Override
	public void move() {
		/**
		 * Does nothing, mushrooms don't move
		 */
		
	}

	@Override
	public Rectangle getBoundingRect() {
		// TODO Return hitbox, implement
		return null;
	}

	@Override
	public boolean collision(Rectangle r) {
		// TODO Implement, return true if hitboxes overlap
		return false;
	}

	@Override
	public Vector getLocation() {
		return location;
	}

	@Override
	public void handleCollision(MovingObject m) {
		// TODO Handle collissions, look at chart on github
		
	}

	@Override
	public void draw(Graphics g) {
		
	}
}
