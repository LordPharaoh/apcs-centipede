import java.awt.Rectangle;


public interface MovingObject {

	void move();
	Rectangle getBoundingRect();
	Vector getLocation();
	boolean collision(MovingObject m);
	void handleCollision(MovingObject m);
}
