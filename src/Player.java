import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.KeyStroke;



public class Player implements MovingObject, Drawable{

	public static final int WIDTH = 75;
	public static final int HEIGHT = 75;
	public static final int SPEED = 20;
	private Vector location;
	private GameMap gm;
	private static BufferedImage ship; 

		
	
	public Player (Vector v, GameMap gm){
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
		
		this.gm = gm;



	}




	@Override
	public void draw(Graphics g) {
		g.drawImage(ship, this.location.x, this.location.y, WIDTH, HEIGHT, null);

	}


	public void move(String s) {

		if (s.equalsIgnoreCase("left")){
			if (location.x - SPEED <= 0){
				location.x = 0;
			}
			else{
				location.x -= SPEED;
			}
		}
		if (s.equalsIgnoreCase("right")){
			if (location.x + SPEED >= MovingObjectsGameLauncher.DEFAULT_SIZE){
				location.x = MovingObjectsGameLauncher.DEFAULT_SIZE;
			}
			else{
				location.x += SPEED;
			}
		}
		if (s.equalsIgnoreCase("up")){
			if (location.y - SPEED <= 600){
				location.y = 600;
			}
			else{
				location.y -= SPEED;
			}
		}
		if (s.equalsIgnoreCase("down")){
			if (location.y + SPEED >= MovingObjectsGameLauncher.DEFAULT_SIZE){
				location.y = MovingObjectsGameLauncher.DEFAULT_SIZE;
			}
			else{
				location.y += SPEED;
			}
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





	public void shoot() {
		// TODO Auto-generated method stub
		Bullet b = new Bullet(new Vector(location.x + WIDTH/2, location.y), gm);
		gm.add(b);
	}

}
