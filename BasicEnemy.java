import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class BasicEnemy extends Circle {
	private static final int SPEED = 3;
	private static final int SIZE = 10;
	private static Color COLOR = Color.BLUE;
	
	BasicEnemy() {
		setRadius(SIZE);
		setCenterX(250);
		setCenterY(0);
		setFill(COLOR);
	}
	
	BasicEnemy(int XPosition, int YPosition) {
		setRadius(SIZE);
		setCenterX(XPosition);
		setCenterY(YPosition);
		setFill(COLOR);
	}
	
	public int getSpeed() {
		return SPEED;
	}
	
	public boolean isTimeForEnemy(int counter) {
		if (counter%180 == 0)
			return true;
		return false;
	}
	
	
}
