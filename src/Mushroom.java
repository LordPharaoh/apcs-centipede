import java.awt.Graphics;
import java.awt.Rectangle;


public class Mushroom implements MovingObject, Drawable {
	//TODO actual values
	public static final int WIDTH = 30;
	public static final int HEIGHT = 30;
	private Vector location;
	GameMap gm;
	public Mushroom(Vector v, GameMap gm) {
		//Make a mushroom
		location = v;
		this.gm = gm;
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
		if(r == null || r.getBoundingRect() == null) return false;
		
		return (new Rectangle(location.x, location.y, WIDTH, HEIGHT)).intersects(r.getBoundingRect());	
	}

	@Override
	public Vector getLocation() {
		return location;
	}

	@Override
	public void handleCollision(MovingObject m) {
		// TODO Handle collissions, look at chart on github
		if (m instanceof Bullet) gm.remove(this);
		if (m instanceof Spider) gm.remove(this);
		
	}

	@Override
	public void draw(Graphics g) {
		g.fillRect(location.x, location.y, WIDTH, HEIGHT);
	}
}
