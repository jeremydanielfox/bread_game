import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class BasicEnemy extends GameObject  {
	
	
	BasicEnemy() {
	SIZE = 10;
	SPEED = 3;
	COLOR = Color.BLUE;
		setRadius(SIZE);
		setCenterX(250);
		setCenterY(0);
		setFill(COLOR);
	}
	
	BasicEnemy(int XPosition, int YPosition) {
		SIZE = 10;
		SPEED = 3;
		COLOR = Color.BLUE;
		setRadius(SIZE);
		setCenterX(XPosition);
		setCenterY(YPosition);
		setFill(COLOR);
	}

}
