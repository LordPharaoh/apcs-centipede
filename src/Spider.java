
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;



public class Spider implements MovingObject, Drawable{
	//TODO actual values
	public static final int WIDTH = 50;
	public static final int HEIGHT = 50;
	public static final int BOUNDARY = MovingObjectsGameLauncher.DEFAULT_SIZE * 2 / 3;
	public static final int MOVEX = 4;
	public static final int MOVEY = 5;
	private int x, y;
	private Vector location;
	private boolean up, left;
	private GameMap gm;
	private static BufferedImage spider;


	public Spider (Boolean left, Vector v, GameMap gm){
		// TODO
		this.left = left;
		location = v;
		this.gm = gm;
		if(spider == null){
			try {
				spider = ImageIO.read(new File("res/spider.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}



	@Override
	public void move() {
		x = location.x;
		y = location.y;

		if(y >= MovingObjectsGameLauncher.DEFAULT_SIZE - 100){
			changeDirection();
		}
		else if(y - MOVEY < BOUNDARY){
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
		if(r == null || r.getBoundingRect() == null) return false;
		return (getBoundingRect()).intersects(r.getBoundingRect());
		/**
		 * returns true if collision occurs
		 */

	}



	public Rectangle getBoundingRect() {
		// TODO Auto-generated method stub
		/**
		 * returns hitbox
		 */
		return new Rectangle(location.x, location.y, WIDTH, HEIGHT);

	}

	@Override
	public Vector getLocation() {
		// TODO Auto-generated method stub
		return location;

	}


	@Override

	public void draw(Graphics g) {
		g.drawImage(spider, this.location.x, this.location.y, WIDTH, HEIGHT, null);

	}



	@Override
	public void handleCollision(MovingObject m) {
		// TODO Auto-generated method stub
		if (m instanceof Bullet){
			gm.remove(this);
			//TODO increase score
		}
		if (m instanceof Player) {
			gm.gameOver();
		}
		/**
		 * Hits Mushroom, does nothing, continues to move
		 * Hits Player, deletes
		 * Hits Bullet, deletes
		 * Hits	Centipede, does nothing, continues to move
		 */

	}




}
