import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

import javafx.animation.KeyFrame;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * This represents the primary class for a game/animation
 * 
 * @author Jeremy
 *
 */
public class BreadFirstSearch {
	private Scene myScene;
	private Group myRoot;
	private Player myPlayer;
	private Earth myEarth;
	private Collection<GameObject> myBasicEnemies = new CopyOnWriteArrayList<GameObject>();
	private Collection<AdvancedEnemy> myAdvancedEnemies = new CopyOnWriteArrayList<AdvancedEnemy>();
	private Collection<GameObject> myProjectiles = new CopyOnWriteArrayList<GameObject>();

	private Random myRandom = new Random();
	private boolean isLevelOneOver = false;
	private boolean isLevelTwoOver = false;
	private Timers t = new Timers();



	/**
	 * Create the game's scene
	 */
	public Scene init(Stage stage, int height, int width) {
		// start the scene graph
		myRoot = new Group();
		//create the player
		myPlayer = new Player(height, width);

		// add the player to the scene;
		myRoot.getChildren().add(myPlayer);

		myScene = new Scene(myRoot, width, height, Color.BLACK);
		myScene.setOnKeyPressed(e -> handleKeyInput(e));
		return myScene;

	}

	/**
	 * Create the game's frame
	 */
	public KeyFrame start(int frameRate) {
		return new KeyFrame(Duration.millis(1000 / frameRate), e -> updateSprites());

	}

	/**
	 * What to do each game frame
	 *
	 * Change the sprite properties each frame by a tiny amount to animate them
	 *
	 * Note, there are more sophisticated ways to animate shapes, but these simple ways work too.
	 */
	private int myCounter = 0;

	private void updateSprites() {
		generateObjects();
		moveObjects();
		checkAllCollisions();
		killOffScreenObjects();
		cleanUpDeadSprites();
		myCounter++;
	}

	/**
	 * 
	 */
	public void checkAllCollisions() {
		for (GameObject current: myBasicEnemies) {
			checkCollide(myPlayer,current);
		}
		for (AdvancedEnemy current: myAdvancedEnemies) {
			checkCollide(myPlayer,current);
		}
		for (GameObject currentEnemy: myBasicEnemies) {
			for (GameObject currentProjectile: myProjectiles) {
				checkCollide(currentEnemy,currentProjectile);
			}
		}
		for (AdvancedEnemy currentEnemy: myAdvancedEnemies) {
			for (GameObject currentProjectile: myProjectiles) {
				checkCollide(currentEnemy,currentProjectile);
			}
		}
		if (myEarth!=null)
			if (myPlayer.getBoundsInParent().intersects(myEarth.getBoundsInParent())) {
				if (!isLevelOneOver)
					isLevelOneOver=true;
				else if (!isLevelTwoOver)
					isLevelTwoOver=true;
			}
	}

	/**
	 * 
	 */
	public void cleanUpDeadSprites() {
		for (GameObject current: myBasicEnemies)
			if (current.isDead()) {
				myRoot.getChildren().remove(current);
				myBasicEnemies.remove(current);
			}
		for (AdvancedEnemy current: myAdvancedEnemies)
			if (current.isDead()) {
				myRoot.getChildren().remove(current);
				myAdvancedEnemies.remove(current);
			}
		for (GameObject current: myProjectiles) 
			if (current.isDead()) {
				myRoot.getChildren().remove(current);
				myProjectiles.remove(current);
			}

		if (myPlayer.isDead())
			myRoot.getChildren().remove(myPlayer);
	}

	/**
	 * 
	 */
	public void moveObjects() {
		moveUpOrDown(myBasicEnemies,"down");
		moveUpOrDown(myProjectiles, "up");
		// move advanced enemies
		for (AdvancedEnemy current: myAdvancedEnemies) {
			current.setDestination(myPlayer.getLocation());
			Point2D velocity = current.getVelocity();
			current.setCenterX(current.getCenterX() + velocity.getX());
			current.setCenterY(current.getCenterY() + velocity.getY());

		}
		//move projectiles

		// move the Earth
		moveUpOrDown(myEarth,"down");
	}
	public void moveUpOrDown(Collection<GameObject> myList, String input) {
		if (input.equals("up"))
			for (GameObject current: myList)
				current.setCenterY(current.getCenterY() - current.getSpeed());
		else if (input.equals("down"))
			for (GameObject current: myList) 
				current.setCenterY(current.getCenterY() + current.getSpeed());
	}
	
	public void moveUpOrDown(GameObject myObject, String input) {
		if (myObject!=null && input.equals("up"))
				myObject.setCenterY(myObject.getCenterY() - myObject.getSpeed());
		else if (myObject!=null && input.equals("down"))
				myObject.setCenterY(myObject.getCenterY() + myObject.getSpeed());
	}
	

	/**
	 * 
	 */
	public void generateObjects() {
		if (t.isTimeForEarth(myCounter))
			generateEarth();
		if (myEarth==null) {
			if (t.isTimeForEnemy(myCounter)) {
				generateBasicEnemy();
				generateAdvancedEnemy();
			}
		}
	}


	/**
	 * What to do each time a key is pressed
	 */
	private void handleKeyInput (KeyEvent e) {
		KeyCode keyCode = e.getCode();
		if (keyCode == KeyCode.RIGHT) {
			// make this player speed!
			myPlayer.setCenterX( myPlayer.getCenterX() + myPlayer.getSpeed());
		}
		else if (keyCode == KeyCode.LEFT) {
			myPlayer.setCenterX( myPlayer.getCenterX() - myPlayer.getSpeed());
		}
		else if (keyCode == KeyCode.SPACE) {
			fireProjectile();
		}
		else if (keyCode == KeyCode.SHIFT) {
			myPlayer.toggleInvincibility();
		}
		else if (keyCode == KeyCode.TAB) {
			killAllEnemies();
		}

	}


	/**
	 * What to do each time the mouse is clicked
	 */
	private void handleMouseInput (MouseEvent e) {

	}

	/**
	 * What to do each time shapes collide
	 */
	private void checkCollide (GameObject first, GameObject second) {
		// check for collision
		if (first.getBoundsInParent().intersects(second.getBoundsInParent())) {
			if (!first.IS_INVINCIBLE)
				first.kill();
			if (!second.IS_INVINCIBLE)
				second.kill();

		}

	}

	public void generateEarth() {
		myEarth = new Earth((int) myScene.getWidth(),(int) myScene.getHeight());
		myRoot.getChildren().add(myEarth);
	}

	/**
	 * 
	 */
	public void generateBasicEnemy() {
		BasicEnemy temp = new BasicEnemy(generateRandom( (int) myScene.getWidth()),0);
		myRoot.getChildren().add(temp);
		myBasicEnemies.add(temp);
	}

	public void generateAdvancedEnemy() {
		Point2D tempPoint = new Point2D((double)generateRandom((int) myScene.getWidth()),0);
		AdvancedEnemy tempEnemy = new AdvancedEnemy(tempPoint);
		myRoot.getChildren().add(tempEnemy);
		myAdvancedEnemies.add(tempEnemy);
	}

	public int generateRandom(int input) {
		return myRandom.nextInt(input) + 1;
	}

	public void killOffScreenObjects() {
		for (GameObject current: myBasicEnemies)
			if (isOffScreen(current))
				current.kill();
		for (AdvancedEnemy current: myAdvancedEnemies)
			if (isOffScreen(current))
				current.kill();
		for (GameObject current: myProjectiles)
			if (isOffScreen(current))
				current.kill();
	}

	public boolean isOffScreen(GameObject input) {
		return input.getCenterY() > myScene.getHeight() || input.getCenterY() < 0
				|| input.getCenterX() > myScene.getWidth() || input.getCenterX() < 0;
	}

	public void fireProjectile() {
		Projectile temp = new Projectile((int)myPlayer.getCenterX() + (int) myPlayer.getTranslateX(),
				(int)myPlayer.getCenterY() + (int) myPlayer.getTranslateY());
		myProjectiles.add(temp);
		myRoot.getChildren().add(temp);
	}
	//fix this!!
	//
	//
	//
	//
	//
	public void killAllEnemies() {
		killAll(myBasicEnemies);
		killAll1(myAdvancedEnemies);
	}
	
	public void killAll(Collection<GameObject> myCollection) {
		for (GameObject current:myCollection)
			current.kill();
	}
	
	public void killAll1(Collection<AdvancedEnemy> myCollection) {
		for (AdvancedEnemy current: myCollection) 
			current.kill();
		
	}
	
}


