import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;


public abstract class GameMap {

	protected List<MovingObject> movers;
	protected List<Drawable> drawers;
	Image backgroundImage;
	protected boolean gameOver;
	
	
	public GameMap() {
		movers = new ArrayList<MovingObject>();
		drawers = new ArrayList<Drawable>();
		openBackgroundImage();
	}

	
	public abstract void openBackgroundImage();
	public abstract void tick();
	public abstract void draw(Graphics g);
	
	public void remove(Object m){
		drawers.remove(m);
		movers.remove(m);
	}

	public void addMover(MovingObject go) {
		movers.add(go);
	}
	public void addDrawer(Drawable d) {
		drawers.add(d);
	}
	public void add(Object d) {
		if(d instanceof Drawable) {
			drawers.add((Drawable) d);
		}
		if(d instanceof MovingObject){
			movers.add((MovingObject) d);
		}
	}

	public void startGame() {
		gameOver = false;
	}
	public void gameOver() {
		gameOver = true;
	}


	public void shoot() {
		// TODO Auto-generated method stub
		
	}


	public void move(String s) {
		// TODO Auto-generated method stub
		
	}


}
