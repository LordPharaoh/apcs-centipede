import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class Bullet implements MovingObject, Drawable {
	//TODO actual values
	public static final int WIDTH = 2;
	public static final int HEIGHT = 2;
	protected int bulletSpeed = 3;
	private boolean hitObj;
	private Vector location;
	private GameMap gm;
	public Bullet(Vector v, GameMap gm){
		location = v;
		this.gm = gm;
	}
	

	@Override
	public void move() {
		while(hitObj==false){
			location.y += bulletSpeed;
		}
		
	}
	@Override
	public void handleCollision(MovingObject m){
		
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRoundRect(location.x, location.y, (int)this.WIDTH, (int)this.HEIGHT, 1, 1);
		
	}
	@Override
	public Vector getLocation() {
		// TODO Auto-generated method stub
		return location;
	}
	
	@Override
	public boolean collision(MovingObject r) {
		// TODO Auto-generated method stub
		if(r == null) return false;
		return (getBoundingRect()).intersects(r.getBoundingRect());
	}

	public Rectangle getBoundingRect() {
		/**
		 * Gives hitbox
		 */
		
		return new Rectangle(location.x, location.y, WIDTH, HEIGHT);
	}
}
