import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class BasicEnemy extends GameObject  {
	
	Image img = new Image("Images/basicEnemy.png");
	BasicEnemy() {
	SIZE = 30;
	SPEED = 3;
	COLOR = Color.BLUE;
		//setRadius(SIZE);
	setImage(img);

	setFitHeight(SIZE);
	setFitWidth(SIZE);
	preserveRatioProperty();
		setCenterX(250);
		setCenterY(0);
		//setFill(COLOR);
	}
	
	BasicEnemy(int XPosition, int YPosition) {
		SIZE = 30;
		SPEED = 3;
		COLOR = Color.BLUE;
		setImage(img);

		setFitHeight(SIZE);
		setFitWidth(SIZE);
		preserveRatioProperty();
		//setRadius(SIZE);
		setCenterX(XPosition);
		setCenterY(YPosition);
		//setFill(COLOR);
	}

}
