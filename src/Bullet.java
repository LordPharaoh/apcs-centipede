import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class Bullet implements MovingObject, Drawable{
	//TODO actual values
	private int x, y;
	public static final int BULLET_WIDTH = 10;
	public static final int BULLET_HEIGHT = 20;
	protected int bulletSpeed = 5;
	private Vector location;
	public int Wall = 1000;

	
	public Bullet(Vector v){
		location = v;
	}
	

	@Override
	public void move() {
		x = location.x;
		y = location.y;
		if(y>0 && y<Wall){
			y=y-bulletSpeed;//draw(null);
			location = new Vector(x, y);
			}
	}
	
	@Override
	public void handleCollision(MovingObject m){
		if(m instanceof Mushroom || m instanceof Spider || m instanceof MovingObject) bulletSpeed =0;
		else return;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillRoundRect(location.x, location.y, (int)this.BULLET_WIDTH, (int)this.BULLET_HEIGHT, 10, 10);
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


	public void setLocation(Vector location) {
	}


	@Override
	public Rectangle getBoundingRect() {
		// TODO Auto-generated method stub
		return null;
	}

}
