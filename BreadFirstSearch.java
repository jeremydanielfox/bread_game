import java.util.ArrayList;
import java.util.Collection;

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
		if (isTimeForEnemy(myCounter)) {
			BasicEnemy temp = new BasicEnemy();
			myRoot.getChildren().add(temp);
			myEnemies.add(temp);
			
		}
		for (BasicEnemy current: myEnemies) {
			current.setCenterY(current.getCenterY() + current.getSpeed());
			
		}
		myCounter++;
	}

	/**
	 * What to do each time a key is pressed
	 */
	private void handleKeyInput (KeyEvent e) {
		KeyCode keyCode = e.getCode();
        if (keyCode == KeyCode.RIGHT) {
        	// make this player speed!
            myPlayer.setTranslateX(myPlayer.getTranslateX() + myPlayer.getSpeed());
        }
        else if (keyCode == KeyCode.LEFT) {
        	myPlayer.setTranslateX(myPlayer.getTranslateX() - myPlayer.getSpeed());
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
    private void checkCollide (Node player, Node enemy) {
    	
    }
    /**
     * Return true every three seconds
     * @param counter
     * @return
     */
	public boolean isTimeForEnemy(int counter) {
		//how to use num frames per second?
		if (counter%180 == 0)
			return true;
		return false;
	}
   
}


