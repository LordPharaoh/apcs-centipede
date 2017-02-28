import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.KeyStroke;



public class Player implements MovingObject, Drawable{

	public static final int WIDTH = 100;
	public static final int HEIGHT = 50;
	public static final int SPEED = 10;
	private Vector location;
	private GameMap gm;
	
	public Player (Vector v, GameMap gm){
		// TODO
		location = v;
		this.gm = gm;
		

		
		
	}
	
	
	
	
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(new Color(255, 0, 0));
		g.drawOval(this.location.x, this.location.y, WIDTH, HEIGHT);
		
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




	public void shoot() {
		// TODO Auto-generated method stub
		Bullet b = new Bullet(new Vector(location.x + WIDTH/2, location.y), gm);
		gm.add(b);
	}

	
	
	
}
