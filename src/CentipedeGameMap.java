import java.awt.Dimension;
import java.awt.Graphics;


public class CentipedeGameMap extends GameMap {

	//TODO implement scale
	public static double scale = 1;
	public void makeMushrooms(int n) {
		for(int i = 0; i < n; i++) {
			Mushroom m = new Mushroom(
					new Vector(
							(int)(Math.random() * MovingObjectsGameLauncher.DEFAULT_SIZE), 
							(int)(Math.random() * MovingObjectsGameLauncher.DEFAULT_SIZE)
					),
					this
			);
			add(m);
		}
	}
	public void makeCentipede(int numSegments, int xVal) {
		for(int i = 0; i < numSegments; i++) {
			Centipede c = new Centipede(new Vector(xVal, -(i * Centipede.HEIGHT)), this);
			add(c);
		}
	}
		
	public CentipedeGameMap(Dimension dim) {
		//TODO open with dimensions

		makeMushrooms(20);
		makeCentipede(20, 600);

	}
	
	public CentipedeGameMap() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void openBackgroundImage() {
		// TODO Open the background image
		
	}
	
	public void collisions() {
		//TODO add box optimization
		//TODO skip types that don't react? is instanceof more efficient?
		for(int i = 0; i < movers.size(); i++) {
			for(int h = i + 1; h < movers.size(); h++) {
				if(movers.get(i).collision(movers.get(h))) {
					movers.get(i).handleCollision(movers.get(h));
					movers.get(h).handleCollision(movers.get(i));
				}
			}
		}
	}
	public void moveAll() {
		for(MovingObject mo : movers) {
			mo.move();
		}
	}

	@Override
	public void tick() {
		collisions();
		moveAll();
	}

	@Override
	public void draw(Graphics g) {
		// TODO affinetransform to scale with window size
		for(Drawable d : drawers) {
			d.draw(g);
		}
	}

}
