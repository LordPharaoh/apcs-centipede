import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class Centipede implements MovingObject, Drawable {

	private Vector location;
	//TODO support scaling
	public Centipede(Vector v) {
		location = v;
	}
	@Override
	public void move() {
	
	}
	
	@Override
	public void draw(Graphics g) {
		// TODO placeholder draw function
		g.setColor(new Color(0, 255, 0));
		g.drawOval(this.location.x, this.location.y, 10, 10);
	}

	@Override
	public Rectangle getBoundingRect() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector getLocation() {
		// TODO Auto-generated method stub
		return location;
	}

	@Override
	public boolean collision(Rectangle r) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void handleCollision(MovingObject m) {
		// TODO implement
		
	}
}


