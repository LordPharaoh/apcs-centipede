import java.awt.Rectangle;


public class Centipede implements Drawable, MovingObject {
	//TODO actual values
	public static final int CENT_WIDTH = 50;
	public static final int CENT_HEIGHT = 50;
	public Centipede(Vector v) {
		//Make a centipede
		
	}

	@Override
	public void move() {
		/**
		 * Should move horizontally until it comes into contact with the east/west 
		 * wall, another Centipede piece, or a Mushroom. When it comes into 
		 * contact (collides) with one of those it should move down one vertical unit.
		 */
		
	}

	@Override
	public Rectangle getBoundingRect() {
		// TODO Auto-generated method stub
		/**
		 * Gives hitbox
		 */
		return null;
	}

	@Override
	public boolean collision(Rectangle r) {
		// TODO Auto-generated method stub
		/**
		 * Checks if hitbox overlaps with any other hitboxes
		 */
	
		return false;
	}

	@Override
	public Vector getLocation() {
		// TODO Auto-generated method stub
		/**
		 * Returns x and y of object
		 */
		return null;
	}

	@Override
	public void handleCollision(MovingObject m) {
		// TODO Auto-generated method stub
		/**
		 * Checks what it is in contact with
		 * 
		 * Contact with Mushroom -> Move down 1 Vertical unit + Change Direction
		 * Contact with East/West Wall -> Move down 1 Vertical unit + Change Direction
		 * Contact with another Centipede -> Move down 1 Vertical unit + Change Direction
		 * Contact with Bullet -> Delete section, Spawn Mushroom at location
		 */
		
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		/**
		 * Displays sprite
		 */
		
	}
}
