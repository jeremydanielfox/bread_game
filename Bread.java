import javafx.scene.image.Image;
import javafx.scene.paint.Color;


public class Bread extends GameObject {
	Image img = new Image("Images/breadSlice.jpg");
	Bread(int XPosition, int YPosition) {
		setSize(50);
		setSpeed(3);
		setImage(img);
		setupImage();
		setCenterX(XPosition);
		setCenterY(YPosition);
	}
}
