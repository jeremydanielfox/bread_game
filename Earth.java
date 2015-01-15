import javafx.scene.image.Image;
import javafx.scene.paint.Color;


public class Earth extends GameObject {
Image img = new Image("Images/earth.jpg");
	Earth(int width, int height) {
		setSize(height);
		setSpeed(1);
		setImage(img);

		setFitHeight(getSize());
		setFitWidth(getSize());
		preserveRatioProperty();
		setCenterX(width/2);
		setCenterY(-height);
		
	}
	
	
}
