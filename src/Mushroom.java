
import java.awt.Graphics;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Mushroom implements MovingObject, Drawable {
	//TODO actual values
	public static final int WIDTH = 25;
	public static final int HEIGHT = 25;
	private Vector location;
	GameMap gm;
	private static BufferedImage mush1;
	private static BufferedImage mush2;
	private static BufferedImage mush3;
	private static BufferedImage mush4;
	private int health = 4;
	public Mushroom(Vector v, GameMap gm) {
		//Make a mushroom
		location = v;
		this.gm = gm;
		if(mush1 == null  ){
			try {
				mush1 = ImageIO.read(new File("res/Mush1.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(mush2 == null)
			try {
				mush2 = ImageIO.read(new File("res/Mush2.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		else if(mush3 == null)
			try {
				mush3 = ImageIO.read(new File("res/Mush3.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		else if(mush4 == null)
			try {
				mush4 = ImageIO.read(new File("res/Mush4.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


	}

	@Override
	public void move() {
		/**
		 * Does nothing, mushrooms don't move
		 */
		
	}

	@Override
	public Rectangle getBoundingRect() {
		// TODO Return hitbox, implement
		return new Rectangle(location.x, location.y, WIDTH, HEIGHT);
	}

	@Override
	public boolean collision(MovingObject r) {
		// TODO Implement, return true if hitboxes overlap
		if(r == null || r.getBoundingRect() == null) return false;
		
		return (new Rectangle(location.x, location.y, WIDTH, HEIGHT)).intersects(r.getBoundingRect());	
	}

	@Override
	public Vector getLocation() {
		return location;
	}

	@Override
	public void handleCollision(MovingObject m) {
		// TODO Handle collissions, look at chart on github
		if (m instanceof Bullet) {
			health--; 
			if(health < 0) {
				gm.remove(this);
			}
			System.out.println("Hit, health is now " + health);
		}
		if (m instanceof Spider) gm.remove(this);
		
	}

	@Override
	public void draw(Graphics g) {
		switch(health) {
			case 1:
				g.drawImage(mush4, this.location.x, this.location.y, WIDTH, HEIGHT, null);
				break;
			case 2:
				g.drawImage(mush3, this.location.x, this.location.y, WIDTH, HEIGHT, null);
				break;

			case 3:
				g.drawImage(mush2, this.location.x, this.location.y, WIDTH, HEIGHT, null);
				break;

			case 4:
				g.drawImage(mush1, this.location.x, this.location.y, WIDTH, HEIGHT, null);
				break;

			default:

		}
	}
}
