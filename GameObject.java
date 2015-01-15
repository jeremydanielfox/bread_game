import java.util.Collection;
import java.util.Random;

import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;



public class GameObject extends ImageView {
	protected int SPEED;
	protected int SIZE;
	protected Color COLOR;
	protected boolean IS_DEAD = false;
	protected boolean IS_INVINCIBLE = false;
	protected int ID;
	private Random myRandom = new Random();
	
	public GameObject() {
		
	}
	
	public int getSpeed() {
		return SPEED;
	}
	
	public boolean isDead() {
		return IS_DEAD;
	}
	
	public void toggleInvincibility() {
		if (this.IS_INVINCIBLE)
			this.removeInvincible();
		else
			this.makeInvincible();
	}
	
	public boolean isInvincible() {
		return IS_INVINCIBLE;
	}
	
	public void makeInvincible() {
		IS_INVINCIBLE = true;
	}
	
	public void removeInvincible() {
		IS_INVINCIBLE = false;
	}
	
	public void kill() {
		IS_DEAD = true;
	}
	
	public Point2D getLocation() {
		return new Point2D((float) this.getCenterX(),(float) this.getCenterY());
	}
	
	public int getCenterX() {
		return (int) getX() + (int) getFitWidth()/2;
	}
	
	public int getCenterY() {
		return (int) getY() + (int) getFitHeight()/2;
	}
	
	public void setCenterX(double d) {
		setX((double)d - (int) getFitWidth()/2);
	}

	public void setCenterY(double d) {
		setY((double)d- (int) getFitHeight()/2);
	}
	
	public void generate(Collection<GameObject> myCollection, Group myRoot, Scene myScene) {
		BasicEnemy temp = new BasicEnemy(generateRandom( (int) myScene.getWidth()),0);
		myRoot.getChildren().add(temp);
		myCollection.add(temp);
	}

	public int generateRandom(int input) {
			return myRandom.nextInt(input) + 1;
		}
	
	 
	
}
