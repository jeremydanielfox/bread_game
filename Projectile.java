import java.util.Collection;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class Projectile extends GameObject {
	private Image img = new Image("Images/bullet.jpg");
	static final int PROJECTILE_SPEED = 20;
	static final int PROJECTILE_SIZE = 20;
	public Projectile(){};
	public Projectile(int XPosition,int YPosition) {
		setSpeedSizeImageXY(PROJECTILE_SPEED,PROJECTILE_SIZE,img,XPosition,YPosition);
	}
	public void generate(Collection<GameObject> myCollection, Group myRoot, Scene myScene, Player myPlayer) {
		Projectile temp = new Projectile((int)myPlayer.getCenterX(),(int)myPlayer.getCenterY());
		myRoot.getChildren().add(temp);
		myCollection.add(temp);
	}
}
