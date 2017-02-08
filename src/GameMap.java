import java.awt.Image;
import java.util.ArrayList;
import java.util.List;


public abstract class GameMap {

	private List<MovingObject> movers;
	Image backgroundImage;
	
	public GameMap() {
		movers = new ArrayList();
		openBackgroundImage();
	}

	
	public abstract void openBackgroundImage();


	public void add(MovingObject go) {
		movers.add(go);
	} 	
}
