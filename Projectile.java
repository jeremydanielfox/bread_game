import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class Projectile extends GameObject {
	
	
	public Projectile(int XPosition,int YPosition) {
		SIZE = 5;
		SPEED = 20;
		COLOR = Color.WHITE;
		setRadius(SIZE);
		setCenterX(XPosition);
		setCenterY(YPosition);
		setFill(COLOR);
		IS_DEAD = false;
	}

}
