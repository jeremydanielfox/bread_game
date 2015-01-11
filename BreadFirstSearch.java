import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

import javafx.animation.KeyFrame;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
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
	private Collection<BasicEnemy> myEnemies = new ArrayList<BasicEnemy>();
	private Collection<Projectile> myProjectiles = new ArrayList<Projectile>();
	private Random myRandom = new Random();



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
		//potentially generate more enemies
		if (isTimeForEnemy(myCounter))
			generateEnemy();
		//move all enemies down
		for (BasicEnemy current: myEnemies) {
			current.setCenterY(current.getCenterY() + current.getSpeed());

		}
		//move projectiles
		for (Projectile current: myProjectiles) {
			current.setCenterY(current.getCenterY() - current.getSpeed());
		}
		//check for collisions
		for (BasicEnemy current: myEnemies) {
			checkCollide(myPlayer,current);
		}
		for (BasicEnemy currentEnemy: myEnemies) {
			for (Projectile currentProjectile: myProjectiles) {
				checkCollide(currentEnemy,currentProjectile);
			}
		}

		killOffScreenObjects();

		//clean up dead sprites
		for (BasicEnemy current: myEnemies)
			if (current.isDead()) {
				myRoot.getChildren().remove(current);
				myEnemies.remove(current);
			}
		for (Projectile current: myProjectiles) 
			if (current.isDead()) {
				myRoot.getChildren().remove(current);
				myProjectiles.remove(current);
			}

		if (myPlayer.isDead())
			myRoot.getChildren().remove(myPlayer);
		myCounter++;
	}


	/**
	 * What to do each time a key is pressed
	 */
	private void handleKeyInput (KeyEvent e) {
		KeyCode keyCode = e.getCode();
		if (keyCode == KeyCode.RIGHT) {
			// make this player speed!
			myPlayer.setTranslateX(myPlayer.getTranslateX()  + myPlayer.getSpeed());
		}
		else if (keyCode == KeyCode.LEFT) {
			myPlayer.setTranslateX(myPlayer.getTranslateX() - myPlayer.getSpeed());
		}
		else if (keyCode == KeyCode.SPACE) {
			fireProjectile();
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
			first.kill();
			second.kill();

		}

	}
	/**
	 * Return true every three seconds
	 * @param counter
	 * @return
	 */
	public boolean isTimeForEnemy(int counter) {
		//how to use num frames per second?
		if (counter%30 == 0)
			return true;
		return false;
	}

	/**
	 * 
	 */
	public void generateEnemy() {
		BasicEnemy temp = new BasicEnemy(generateRandom( (int) myScene.getWidth()),0);
		myRoot.getChildren().add(temp);
		myEnemies.add(temp);
	}

	public int generateRandom(int input) {
		return myRandom.nextInt(input) + 1;
	}

	public void killOffScreenObjects() {
		for (BasicEnemy current: myEnemies)
			if (isOffScreen(current))
				current.kill();
		for (Projectile current: myProjectiles)
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
}


