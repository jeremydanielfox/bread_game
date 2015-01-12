import javafx.scene.paint.Color;


public class Bread extends GameObject {
	
	Bread(int XPosition, int YPosition) {
		SIZE = 5;
		SPEED = 5;
		COLOR = Color.ORANGE;
		//setRadius(SIZE);
		setCenterX(XPosition);
		setCenterY(YPosition);
	//	setFill(COLOR);
		
	}
}
