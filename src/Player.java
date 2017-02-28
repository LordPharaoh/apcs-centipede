import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.KeyStroke;



public class Player implements MovingObject, Drawable{

	public static final int WIDTH = 100;
	public static final int HEIGHT = 50;
	public static final int SPEED = 10;
	private Vector location;
	private static BufferedImage ship; 
	
	public Player (Vector v){
		// TODO
		location = v;

		if(ship == null){
			try {
				ship = ImageIO.read(new File("res/ship.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		
	}
	
	
	
	
	@Override
	public void draw(Graphics g) {
		g.drawImage(ship, this.location.x, this.location.y, WIDTH, HEIGHT, null);

		
	}

	
	public void move(String s) {
		if (s.equalsIgnoreCase("left")){
			location.x -= SPEED;
		}
		else if (s.equalsIgnoreCase("right")){
			location.x += SPEED;
		}
		else if (s.equalsIgnoreCase("up")){
			location.y -= SPEED;
		}
		else if (s.equalsIgnoreCase("down")){
			location.y += SPEED;
		}

	}

	@Override
	public Rectangle getBoundingRect() {
		// TODO Auto-generated method stub
		return new Rectangle(location.x, location.y, WIDTH, HEIGHT);
	}

	@Override
	public Vector getLocation() {
		return location;
	}



	@Override
	public void handleCollision(MovingObject m) {
		// TODO Auto-generated method stub
		/**
		 * cannot go through mushrooms
		 * next health when hitting spider or centipede
		 */
		
		
		
	}




	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}




	@Override
	public boolean collision(MovingObject r) {
		if(r == null || r.getBoundingRect() == null) return false;
		return (getBoundingRect()).intersects(r.getBoundingRect());
	}

	
	
	
}
