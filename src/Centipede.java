
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.Rectangle;
public class Centipede implements Drawable, MovingObject {
	//TODO actual values
	public static final int CENT_WIDTH = 50;
	public static final int CENT_HEIGHT = 50;
	private Vector location;
	//TODO support scaling
	public Centipede(Vector v) {
		location = v;
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
	public void draw(Graphics g) {
		g.setColor(new Color(0, 255, 0));
		g.drawOval(this.location.x, this.location.y, 10, 10);

	}

	@Override
	public Rectangle getBoundingRect() {
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

	public Vector getLocation() {
		// TODO Auto-generated method stub
		return location;
	}
		
}
