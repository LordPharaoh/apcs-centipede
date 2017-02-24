import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public abstract class Bullet implements MovingObject, Drawable {
	//TODO actual values
	private int x, y;
	public static final int BULLET_WIDTH = 2;
	public static final int BULLET_HEIGHT = 2;
	protected int bulletSpeed = 3;
	private boolean hitObj;
	private Vector location;
	
	public Bullet(int x, int y){
		this.x = x;
		this.y = y;
		
	}
	

	@Override
	public void move() {
		while(hitObj==false){
			y+=bulletSpeed;
		}
		
	}
	@Override
	public void handleCollision(MovingObject m){
		
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRoundRect(x, y, (int)this.BULLET_WIDTH, (int)this.BULLET_HEIGHT, 1, 1);
		
	}
	@Override
	public Vector getLocation() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean collision(MovingObject r) {
		// TODO Auto-generated method stub
		return hitObj;
	}

}
