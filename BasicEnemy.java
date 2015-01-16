import java.util.Collection;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class BasicEnemy extends GameObject  {

	private Image img = new Image("Images/basicEnemy.png");
	static final int BASIC_ENEMY_SPEED = 3;
	static final int BASIC_ENEMY_SIZE = 30;
	static final int START_X_COORD = 250;
	static final int START_Y_COORD = 0;

	BasicEnemy() {
		setSpeedSizeImageXY(BASIC_ENEMY_SPEED,BASIC_ENEMY_SIZE,img,START_X_COORD,START_Y_COORD);
	}

	BasicEnemy(int XPosition, int YPosition) {
		setSpeedSizeImageXY(BASIC_ENEMY_SPEED,BASIC_ENEMY_SIZE,img, XPosition,YPosition);
	}

	public void generate(Collection<GameObject> myCollection, Group myRoot, Scene myScene) {
		BasicEnemy temp = new BasicEnemy(generateRandom( (int) myScene.getWidth()),START_Y_COORD);
		myRoot.getChildren().add(temp);
		myCollection.add(temp);
	}
}
