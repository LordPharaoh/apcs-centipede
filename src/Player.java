import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.KeyStroke;

import javafx.event.ActionEvent;


public class Player implements MovingObject, Drawable{

	public static final int PLAYER_WIDTH = 100;
	public static final int PLAYER_HEIGHT = 50;
	public static final int PLAYER_SPEED = 5;
	private Vector location;
	private int x, y;
	
	
	
	public Player (Vector v){
		// TODO
		location = v;

		
		
	}
	
	
	
	
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(new Color(255, 0, 0));
		g.drawOval(this.location.x, this.location.y, PLAYER_WIDTH, PLAYER_HEIGHT);
		
	}

	
	public void move(String s) {
		// TODO Auto-generated method stub
		x = location.x;
		y = location.y;
		
		if (s.equalsIgnoreCase("left")){
			location = new Vector(x - PLAYER_SPEED, y);
		}
		else if (s.equalsIgnoreCase("right")){
			location = new Vector(x + PLAYER_SPEED, y);
		}
		else if (s.equalsIgnoreCase("up")){
			location = new Vector(x, y - PLAYER_SPEED);
		}
		else if (s.equalsIgnoreCase("down")){
			location = new Vector(x, y + PLAYER_SPEED);
		}

	}

	@Override
	public Rectangle getBoundingRect() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector getLocation() {
		return location;
	}

	@Override
	public boolean collision(Rectangle r) {
		// TODO Auto-generated method stub
		return false;
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

	
	
	
}
