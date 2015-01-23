// This entire file is part of my masterpiece.
// Jeremy Fox
import java.util.Collection;
import java.util.Random;

import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * This is the base class from which all other game objects inherit
 * @author Jeremy
 *
 */

public class GameObject extends ImageView {
	private Point2D Destination;
	private Point2D Velocity;
	private int SPEED;
	private int SIZE;
	private boolean IS_DEAD = false;
	private boolean IS_INVINCIBLE = false;
	private Random myRandom = new Random();

	public GameObject() {

	}

	public int getSpeed() {
		return this.SPEED;
	}

	public void setSpeed(int speed) {
		this.SPEED = speed;
	}

	public int getSize() {
		return SIZE;
	}

	public void setSize(int size) {
		this.SIZE = size;
	}

	public void setSpeedAndSize(int speed, int size) {
		this.setSpeed(speed);
		this.setSize(size);
	}

	public void setSpeedSizeImageXY(int speed,int size, Image img, int x, int y) {
		setSpeedAndSize(speed,size);
		setImage(img);
		setupImage();
		setCenterX(x);
		setCenterY(y);
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

	public void revive() {
		IS_DEAD = false;
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
		GameObject temp = new GameObject();
		myRoot.getChildren().add(temp);
		myCollection.add(temp);
	}

	public void setupImage()	{
		setFitHeight(this.SIZE);
		setFitWidth(this.SIZE);
		preserveRatioProperty();
	}

	public int generateRandom(int input) {
		return myRandom.nextInt(input) + 1;
	}
	
	public void setDestination(Point2D destination) {
		Destination = destination;
	}

	public Point2D getDestination() {
		return Destination;
	}
	
	public void setVelocity() {
	}

	public Point2D getVelocity() {
		setVelocity();
		return Velocity;
	}
	

	public void move() {
		Point2D velocity = this.getVelocity();
		this.setCenterX(this.getCenterX() + velocity.getX());
		this.setCenterY(this.getCenterY() + velocity.getY());
	}

}
