import java.awt.Rectangle;


public class Mushroom implements MovingObject {
	//TODO actual values
	public static final int MUSHROOM_WIDTH = 50;
	public static final int MUSHROOM_HEIGHT = 50;
	public Mushroom(double x, double y) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void move() {
		/**
		 * Does nothing, mushrooms don't move
		 */
		
	}

	@Override
	public Rectangle getBoundingRect() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean collision(Rectangle r) {
		// TODO Auto-generated method stub
		return false;
	}
}
