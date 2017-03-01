
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
public class Centipede implements Drawable, MovingObject {
	//TODO actual values
	public static final int WIDTH = 25;
	public static final int HEIGHT = 25;
	private static final int UP = 0, DOWN = 1, LEFT = 2, RIGHT = 3;
	private int speed;
	public int direction = DOWN;
	private Vector location;
	//tracks the next direction to turn
	private int nextTurn;
	//last place you started moving down so you can turn when you hit a body length
	private int turnY = 0;
	private GameMap gm;
	//TODO support scaling
	private static BufferedImage centHead;
	private static BufferedImage centBod;
	public Centipede(Vector v, GameMap gm) {
		location = v;
		direction = DOWN;
		speed = 5;
		nextTurn = RIGHT;
		this.gm = gm;
		if(centHead == null){
			try {
				centHead = ImageIO.read(new File("res/centHead.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(centBod == null)
			try {
				centBod = ImageIO.read(new File("res/centBod.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


	}
	@Override
	public void move() {
		/**
		 * Should move horizontally until it comes into contact with the east/west 
		 * wall, another Centipede piece, or a Mushroom. When it comes into 
		 * contact (collides) with one of those it should move down one vertical unit.
		 */
		if(location.y < 0) {
			location = location.add(new Vector(0, speed));
			return;
		}
		Vector dir;
		int scaledSpeed = speed;
		switch(direction) {
			case UP:
				dir = new Vector(0, - scaledSpeed);
				//if we've been going up for a while torn the other way
				if(location.y > turnY - HEIGHT + speed){
					changeDirection();
				}
				break;
			case DOWN:
				dir = new Vector(0, scaledSpeed);
				//if you went down for a whole body length then turn the other way
				if(location.y > turnY + HEIGHT - speed){
					changeDirection();
				}
				if(location.y  + HEIGHT > MovingObjectsGameLauncher.DEFAULT_SIZE) changeDirection(UP);
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
		turnY = location.y;
		if(dir == UP || dir == DOWN) {
			nextTurn = (direction == LEFT) ? RIGHT : LEFT;
		}
		if(dir == LEFT || dir == RIGHT) {
			if(location.y + (1.5 * WIDTH) >= MovingObjectsGameLauncher.DEFAULT_SIZE) nextTurn = UP;
			else nextTurn = DOWN;
		}
		direction = dir;
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawImage(centHead, this.location.x, this.location.y, WIDTH, HEIGHT, null);


	}

	@Override
	public Rectangle getBoundingRect() {
		/**
		 * Gives hitbox
		 */
		
		return new Rectangle(location.x, location.y, WIDTH, HEIGHT);
	}
	
	@Override
	public boolean collision(MovingObject r) {
		// TODO Auto-generated method stub
		/**
		 * Checks if hitbox overlaps with any other hitboxes
		 */
		if(r == null || r.getBoundingRect() == null) return false;
		return (getBoundingRect()).intersects(r.getBoundingRect());
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
		if(m instanceof Mushroom || m instanceof Spider) {
			changeDirection(DOWN);
		}
		if(m instanceof Bullet) {
			gm.add(new Mushroom(location, gm));
			gm.remove(this);
		}
		if(m instanceof Player) {
			gm.gameOver();
		}
		if(m instanceof Spider) gm.remove(this);

		
	}

	public Vector getLocation() {
		// TODO Auto-generated method stub
		return location;
	}
		
}
