import java.awt.Dimension;
import java.awt.Graphics;


public class CentipedeGameMap extends GameMap {

	//TODO implement scale
	public static double scale = 1;

	Player p;
	
	public CentipedeGameMap(Dimension dim) {
		//TODO open with dimensions
		makeMushrooms(20);
		makeCentipede(20, 600);
		Spider s = new Spider(false, new Vector(0, MovingObjectsGameLauncher.DEFAULT_SIZE * 3 / 4), this);
		p = new Player(new Vector((int)(MovingObjectsGameLauncher.DEFAULT_SIZE * .5), MovingObjectsGameLauncher.DEFAULT_SIZE - 100), this);
		startGame();
		add(s);
		add(p);
	}

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
	
	public void makeSpider(){
		
		Spider s = new Spider(Math.random() >= .5,
			new Vector(
					(int)(Math.random() * MovingObjectsGameLauncher.DEFAULT_SIZE), 
					(int)(Math.random() * MovingObjectsGameLauncher.DEFAULT_SIZE *2 / 3)
			),
			this
		);
		add(s);
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
		for(int i = 0; i < movers.size(); i++) {
			movers.get(i).move();
		}
	}

	@Override
	public void tick() {
		updateLists();
		if(gameOver) return;
		collisions();
		moveAll();
		
	}

	@Override
	public void draw(Graphics g) {
		//TODO cool gameover background, this looks lame
		if(gameOver) {
			g.drawString("Game Over", MovingObjectsGameLauncher.DEFAULT_SIZE / 2, MovingObjectsGameLauncher.DEFAULT_SIZE / 2);
			return;
		}
		// TODO affinetransform to scale with window size
		for(int i = 0; i < drawers.size(); i++) {
			drawers.get(i).draw(g);
		}
	}

	public void shoot() {
		// TODO Auto-generated method stub
		p.shoot();
	}

	public void move(String s) {
		p.move(s);
	}
}


