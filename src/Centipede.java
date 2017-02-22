
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.Rectangle;
public class Centipede implements Drawable, MovingObject {
	//TODO actual values
	public static final int WIDTH = 50;
	public static final int HEIGHT = 50;
	private static final int UP = 0, DOWN = 1, LEFT = 2, RIGHT = 3;
	private int speed;
	public int direction = DOWN;
	private Vector location;
	//tracks the next direction to turn
	private int nextTurn;
	//last place you started moving down so you can turn when you hit a body length
	private int turnY = 0;
	//TODO support scaling
	public Centipede(Vector v) {
		location = v;
		direction = DOWN;
		speed = 10;
		nextTurn = RIGHT;
	}
	@Override
	public void move() {
		/**
		 * Should move horizontally until it comes into contact with the east/west 
		 * wall, another Centipede piece, or a Mushroom. When it comes into 
		 * contact (collides) with one of those it should move down one vertical unit.
		 */
		Vector dir;
		int scaledSpeed = speed;
		switch(direction) {
			case UP:
				dir = new Vector(0, - scaledSpeed);
				//if we've been going up for a while torn the other way
				if(location.y > turnY - HEIGHT){
					changeDirection();
				}
				break;
			case DOWN:
				dir = new Vector(0, scaledSpeed);
				//if you went down for a whole body length then turn the other way
				if(location.y > turnY + HEIGHT){
					changeDirection();
				}
				break;
			case LEFT:
				dir = new Vector(-scaledSpeed, 0);
				if(location.x <= 0) changeDirection(); 
				break;
			case RIGHT:
				dir = new Vector(scaledSpeed, 0);
				if(location.x + WIDTH >= MovingObjectsGameLauncher.DEFAULT_SIZE) changeDirection(); 
				break;
			default:
				dir = new Vector(0, 0);
				break;
		}
		location = location.add(dir);
	}
	
	private void changeDirection() {
		changeDirection(nextTurn);
	}
	private void changeDirection(int dir) {
		if(dir == UP || dir == DOWN) {
			nextTurn = (direction == LEFT) ? RIGHT : LEFT;
		}
		if(dir == LEFT || dir == RIGHT) {
			if(location.y + (1.5 * WIDTH) >= MovingObjectsGameLauncher.DEFAULT_SIZE) nextTurn = UP;
			else nextTurn = DOWN;
		}
		direction = dir;
		turnY = location.y;
	}
	
	@Override
	public void draw(Graphics g) {
		//TODO rotate centipede based on directions
		g.setColor(new Color(0, 255, 0));
		g.drawOval(this.location.x, this.location.y, WIDTH, HEIGHT);

	}

	@Override
	public Rectangle getBoundingRect() {
		/**
		 * Gives hitbox
		 */
		return null;
	}
	
	@Override
	public boolean collision(Rectangle r) {
		// TODO Auto-generated method stub
		/**
		 * Checks if hitbox overlaps with any other hitboxes
		 */
	
		return false;
	}

	void handleCollision(Mushroom m) {
		
	}
	@Override
	public void handleCollision(MovingObject m) {
		// TODO Auto-generated method stub
		/**
		 * Checks what it is in contact with
		 * 
		 * Contact with Mushroom -> Move down 1 Vertical unit + Change Direction
		 * Contact with East/West Wall -> Move down 1 Vertical unit + Change Direction
		 * Contact with another Centipede -> Move down 1 Vertical unit + Change Direction
		 * Contact with Bullet -> Delete section, Spawn Mushroom at location
		 */
		
	}

	public Vector getLocation() {
		// TODO Auto-generated method stub
		return location;
	}
		
}
