import java.util.Collection;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class Projectile extends GameObject {
	Image img = new Image("Images/bullet.jpg");
	public Projectile(){};
	public Projectile(int XPosition,int YPosition) {
		setSpeedSizeImageXY(20,20,img,XPosition,YPosition);
	}
	public void generate(Collection<GameObject> myCollection, Group myRoot, Scene myScene, Player myPlayer) {
		Projectile temp = new Projectile((int)myPlayer.getCenterX(),(int)myPlayer.getCenterY());
		myRoot.getChildren().add(temp);
		myCollection.add(temp);
	}
}
