import javafx.scene.image.Image;
import javafx.scene.paint.Color;


public class Earth extends GameObject {
Image img = new Image("Images/earth.jpg");
	Earth(int width, int height) {
		SIZE = height;
		SPEED = 1;
		COLOR = Color.PURPLE;
		//setRadius(SIZE);
		setImage(img);

		setFitHeight(SIZE);
		setFitWidth(SIZE);
		preserveRatioProperty();
		setCenterX(width/2);
		setCenterY(-height);
		//setFill(COLOR);
		IS_DEAD = false;
		
	}
	
	
}
