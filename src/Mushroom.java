import java.awt.Graphics;
import java.awt.Rectangle;


public class Mushroom implements MovingObject, Drawable {
	//TODO actual values
	public static final int WIDTH = 50;
	public static final int HEIGHT = 50;
	private Vector location;
	public Mushroom(Vector v) {
		//Make a mushroom
		location = v;
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
		return new Rectangle(location.x, location.y, WIDTH, HEIGHT);
	}

	@Override
	public boolean collision(MovingObject r) {
		// TODO Implement, return true if hitboxes overlap
		if(r == null) return false;
		return (new Rectangle(location.x, location.y, WIDTH, HEIGHT)).intersects(r.getBoundingRect());	
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
		g.fillRect(location.x, location.y, WIDTH, HEIGHT);
	}
}
