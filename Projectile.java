import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class Projectile extends GameObject {
	
	Image img = new Image("Images/bullet.jpg");
	public Projectile(int XPosition,int YPosition) {
		SIZE = 20;
		SPEED = 20;
		COLOR = Color.WHITE;
		setImage(img);

		setFitHeight(SIZE);
		setFitWidth(SIZE);
		preserveRatioProperty();
		//setRadius(SIZE);
		setCenterX(XPosition);
		setCenterY(YPosition);
		//setFill(COLOR);
		IS_DEAD = false;
	}

}
