
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;



public class Spider implements MovingObject, Drawable{
	//TODO actual values
	public static final int SPIDER_WIDTH = 100;
	public static final int SPIDER_HEIGHT = 50;
	public static final int SPIDER_BOUNDARY = 500;
	public static final int MOVEX = 4;
	public static final int MOVEY = 5;
	private int x, y;
	private Vector location;
	private boolean up, left;
	private GameMap gm;


	public Spider (Vector v, GameMap gm){
		// TODO
		location = v;
		this.gm = gm;

	}



	@Override
	public void move() {
		x = location.x;
		y = location.y;

		if(y >= MovingObjectsGameLauncher.DEFAULT_SIZE - 100){
			changeDirection();
		}
		else if(y - MOVEY < SPIDER_BOUNDARY){
			changeDirection();
		}
		
		else if(Math.random() > .96){
			changeDirection();
		}
		
		
		if(up == true){
			y = y - MOVEY;
		}
		else{
			y = y + MOVEY;

		}

		if(left == false){
			x = x + MOVEX;
		}
		else{
			x = x - MOVEX;
		}

		location = new Vector(x , y);


		/**
		 * Moves randomly within certain area
		 */

	}


	private void changeDirection() {
		// TODO Auto-generated method stub
			if(up == false)
				up = true;
			else
				up = false;
	}





	public boolean collision(MovingObject r) {

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
		g.setColor(new Color(255, 0, 0));
		g.drawOval(this.location.x, this.location.y, SPIDER_WIDTH, SPIDER_HEIGHT);
	}



	@Override
	public void handleCollision(MovingObject m) {
		// TODO Auto-generated method stub
		if (m instanceof Player || m instanceof Bullet){
			
			
		}
		/**
		 * Hits Mushroom, does nothing, continues to move
		 * Hits Player, deletes
		 * Hits Bullet, deletes
		 * Hits	Centipede, does nothing, continues to move
		 */

	}




}
