import java.awt.Rectangle;


public interface MovingObject {

	void move();
	Rectangle getBoundingRect();
	Vector getLocation();
	boolean collision(Rectangle r);
	void handleCollision(MovingObject m);
}
