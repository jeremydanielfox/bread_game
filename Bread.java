import java.util.Collection;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;


public class Bread extends GameObject {
	private Image img = new Image("Images/breadSlice.jpg");
	private int BREAD_SIZE = 3;
	private int BREAD_SPEED = 50;
	private int START_Y_COORD = 0;
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
