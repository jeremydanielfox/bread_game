import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class BasicEnemy extends GameObject  {
	
	private Image img = new Image("Images/basicEnemy.png");
	
	BasicEnemy() {
		setSize(30);
		setSpeed(3);
	setImage(img);
	setupImage();
		setCenterX(250);
		setCenterY(0);
	}
	
	BasicEnemy(int XPosition, int YPosition) {
		setSize(30);
		setSpeed(3);
		setImage(img);
		setupImage();
		setCenterX(XPosition);
		setCenterY(YPosition);
	}

}
