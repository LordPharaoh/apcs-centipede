
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Bullet implements MovingObject, Drawable {
	//TODO actual values
	public static final int WIDTH = 5;
	public static final int HEIGHT = 5;
	protected int bulletSpeed = 3;
	private Vector location;

	private GameMap gm;
	public int Wall = 1000;
	private static BufferedImage bullet;
	public Bullet(Vector v, GameMap gm){
		location = v;
		this.gm = gm;
		/*if(bullet == null){
			try {
				ImageIO.read(new File("res/bullet.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
	}
	

	@Override
	public void move() {
		if(location.y>0 && location.x<Wall){
			location.y=location.y-bulletSpeed;//draw(null);
		}
		if(location.y > 0) gm.remove(this);
	}
	@Override
	public void handleCollision(MovingObject m){
		if(!(m instanceof Player)) gm.remove(this);
	}

	@Override
	public void draw(Graphics g) {
		
		//g.drawImage(bullet, this.location.x, this.location.y,WIDTH, HEIGHT, null);

		
	}
	@Override
	public Vector getLocation() {
		// TODO Auto-generated method stub
		return location;
	}
	


	public Rectangle getBoundingRect() {
		/**
		 * Gives hitbox
		 */	
		
		return new Rectangle(location.x, location.y, WIDTH, HEIGHT);
	}


	


	@Override
	public boolean collision(MovingObject r) {
		// TODO Auto-generated method stub
		/**
		 * Checks if hitbox overlaps with any other hitboxes
		 */
		if(r == null || r.getBoundingRect() == null) return false;
		return (getBoundingRect()).intersects(r.getBoundingRect());
	}
}


