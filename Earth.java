import javafx.scene.paint.Color;


public class Earth extends GameObject {

	Earth(int width, int height) {
		SIZE = height;
		SPEED = 1;
		COLOR = Color.PURPLE;
		setRadius(SIZE);
		setCenterX(width/2);
		setCenterY(-height);
		setFill(COLOR);
		IS_DEAD = false;
		
	}
}
