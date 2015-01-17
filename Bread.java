import java.util.Collection;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

/**
 * this class contains Bread, which is a powerup
 * Bread slowly falls from the top of the screen
 * getting bread clears all enemies from screen
 * @author Jeremy
 *
 */
public class Bread extends GameObject {
	private Image img = new Image("Images/breadSlice.jpg");
	static final int BREAD_SIZE = 3;
	static final int BREAD_SPEED = 50;
	static final int START_Y_COORD = 0;
	Bread() {};
	Bread(int XPosition, int YPosition) {
		setSpeedSizeImageXY(BREAD_SIZE,BREAD_SPEED,img,XPosition,YPosition);
	}
	public void generate(Collection<GameObject> myCollection, Group myRoot, Scene myScene) {
		Bread temp = new Bread(generateRandom( (int) myScene.getWidth()),START_Y_COORD);
		myRoot.getChildren().add(temp);
		myCollection.add(temp);
	}
}
