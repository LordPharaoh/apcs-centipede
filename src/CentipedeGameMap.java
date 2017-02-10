import java.awt.Dimension;
import java.awt.Graphics;


public class CentipedeGameMap extends GameMap {

	
	public CentipedeGameMap(Dimension dim) {
		//TODO open with dimensions
		add(new Mushroom(Math.random()*100, 0));
		
	}
	
	public CentipedeGameMap() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void openBackgroundImage() {
		// TODO Open the background image
		
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
	}

}
