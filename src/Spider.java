
import java.awt.Graphics;
import java.awt.Rectangle;



public class Spider implements MovingObject, Drawable{
	//TODO actual values
	public static final int SPIDER_WIDTH = 100;
	public static final int SPIDER_HEIGHT = 50;
	private int x, y;
	private Vector location;


	public Spider (Vector v){
		// TODO
		location = v;


	}



	@Override
	public void move() {
		x = location.x;
		y = location.y;

		int movex = (int) (Math.random()*10);
		int movey = (int) (Math.random()*10);
		int random = (int) (Math.random()*2);


		if(random == 0){
			x = x + movex;
			if(y + movey < 200){
				y = y + movey;
			}
			else{
				y = 200;
			}
		}
		else{
			x = x - movex;
			y = y - movey;
			
		}
		


		/**
		 * Moves randomly within certain area
		 */

	}

	public boolean collision(Rectangle r) {
		return false;
		/**
		 * returns true if collision occurs
		 */

	}



	public Rectangle getBoundingRect() {
		return null;
		// TODO Auto-generated method stub
		/**
		 * returns hitbox
		 */
	}

	@Override
	public Vector getLocation() {
		// TODO Auto-generated method stub
		return location;

	}


	@Override

	public void draw(Graphics g) {
		// TODO Auto-generated method stub

	}



	@Override
	public void handleCollision(MovingObject m) {
		// TODO Auto-generated method stub

		/**
		 * Hits Mushroom, does nothing, continues to move
		 * Hits Player, deletes
		 * Hits Bullet, deletes
		 * Hits	Centipede, does nothing, continues to move
		 */

	}




}
