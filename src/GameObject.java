import java.awt.Color;
import java.awt.Image;
import java.awt.Rectangle;


public class GameObject implements MovingObject {
	private double speed, x,y,width, height, health, damage;
	//public static final int NORTH = 1, SOUTH = 3, EAST = 2,WEST = 4;
	
	private double direction;
	private Color color;
	private Image img;
	
	public GameObject(double x, double y, double wid, double ht) {
		speed = 0; 
		
	}
	
	@Override
	public void move() {
		x+=speed*Math.cos(direction);
		
		
		// there should be some checking that takes place
		
	}

	@Override
	public Rectangle getBoundingRect() {
		// TODO Auto-generated method stub
		return null;
	}

}
