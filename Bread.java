import java.util.Collection;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;


public class Bread extends GameObject {
	Image img = new Image("Images/breadSlice.jpg");
	Bread() {};
	Bread(int XPosition, int YPosition) {
		setSpeedSizeImageXY(3,50,img,XPosition,YPosition);
	}
	public void generate(Collection<GameObject> myCollection, Group myRoot, Scene myScene) {
		Bread temp = new Bread(generateRandom( (int) myScene.getWidth()),0);
		myRoot.getChildren().add(temp);
		myCollection.add(temp);
	}
}
