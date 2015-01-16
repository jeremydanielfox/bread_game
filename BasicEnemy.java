import java.util.Collection;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class BasicEnemy extends GameObject  {

	private Image img = new Image("Images/basicEnemy.png");

	BasicEnemy() {
		setSpeedSizeImageXY(3,30,img,250,0);
	}

	BasicEnemy(int XPosition, int YPosition) {
		setSpeedSizeImageXY(3,30,img, XPosition,YPosition);
	}

	public void generate(Collection<GameObject> myCollection, Group myRoot, Scene myScene) {
		BasicEnemy temp = new BasicEnemy(generateRandom( (int) myScene.getWidth()),0);
		myRoot.getChildren().add(temp);
		myCollection.add(temp);
	}
}
