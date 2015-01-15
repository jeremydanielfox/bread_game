import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class Projectile extends GameObject {
	Image img = new Image("Images/bullet.jpg");
	public Projectile(int XPosition,int YPosition) {
		setSize(20);
		setSpeed(20);
		setImage(img);
		setupImage();
		setCenterX(XPosition);
		setCenterY(YPosition);
	}

}
