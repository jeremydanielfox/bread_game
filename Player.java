import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class Player extends Circle {
	private static final int PLAYER_SIZE = 20;
	private static final int PLAYER_SPEED = 8;
	private static Color PLAYER_COLOR = Color.RED;
	
	Player() {
		setRadius(PLAYER_SIZE);
		setCenterX(250);
		setCenterY(480);
		setFill(PLAYER_COLOR);
		
	}
	
	Player(int XPosition,int YPosition) {
		setRadius(PLAYER_SIZE);
		setCenterX(setPlayerXPosition(XPosition));
		setCenterY(setPlayerYPosition(YPosition));
		setFill(PLAYER_COLOR);
		
	}
	
	
	public int setPlayerXPosition (int width) {
		return width/2;
	}
	
	public int setPlayerYPosition (int height) {
		return height - PLAYER_SIZE;
	}
	
	public int getSpeed() {
		return PLAYER_SPEED;
	}
	

}
