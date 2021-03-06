import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class CentipedeGameMap extends GameMap {

	//TODO implement scale
	public static double scale = 1;
	private static BufferedImage bg;
	private static int MAX_BULLETS = 1;
	Player p;
	int level;
	
	public CentipedeGameMap(Dimension dim) {
		//TODO open with dimensions

		level = 1;
		makeGame(level);
		p = new Player(new Vector((int)(MovingObjectsGameLauncher.DEFAULT_SIZE * .5), MovingObjectsGameLauncher.DEFAULT_SIZE - 100), this);
		startGame();

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
		
	public void makeGame(int level) {
		makeMushrooms(50);
		makeCentipede(level * 20, (int) (Math.random() * MovingObjectsGameLauncher.DEFAULT_SIZE));
		Spider s = new Spider(false, new Vector(0, MovingObjectsGameLauncher.DEFAULT_SIZE * 3 / 4), this);
		add(s);
	}
	public CentipedeGameMap() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void openBackgroundImage() {
		try {
			bg = ImageIO.read(new File("res/bg.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


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
	
	private int numCentipedes() {
		int tot = 0;
		for(int i = 0; i < movers.size(); i++) {
			if (movers.get(i) instanceof Centipede) tot++;
		}
		return tot;
	}
	private int numBullets() {
		int tot = 0;
		for(int i = 0; i < movers.size(); i++) {
			if (movers.get(i) instanceof Bullet) tot++;
		}
		return tot;
	}
	@Override
	public void tick() {
		if (numCentipedes() == 0){
			makeGame(level);
			level++;
		}
		
		updateLists();
		if(gameOver) return;
		collisions();
		moveAll();
		
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(bg, 0, 0, MovingObjectsGameLauncher.DEFAULT_SIZE, MovingObjectsGameLauncher.DEFAULT_SIZE, null);
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
		if(numBullets() < MAX_BULLETS) p.shoot();
	}

	public void move(String s) {
		p.move(s);
	}
}


