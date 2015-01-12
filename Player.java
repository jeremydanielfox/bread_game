import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class Player extends GameObject {
	Image img = new Image("Images/myPlayer.jpg");
	Player() {
		SIZE = 50;
		SPEED = 20;
//		COLOR = Color.RED;
		setImage(img);

		setFitHeight(SIZE);
		setFitWidth(SIZE);
		preserveRatioProperty();
		//setRadius(SIZE);
		setCenterX(250);
		setCenterY(480);
		//setFill(COLOR);
		
	}
	
	Player(int XPosition,int YPosition) {
		SIZE = 50;
		SPEED = 20;
	//	COLOR = Color.RED;
		setImage(img);
		setFitHeight(SIZE);
		setFitWidth(SIZE);
		preserveRatioProperty();
		//setRadius(SIZE);
		setCenterX(setPlayerXPosition(XPosition));
		setCenterY(setPlayerYPosition(YPosition));
		//setFill(COLOR);
	}
	
	
	public int setPlayerXPosition (int width) {
		return width/2;
	}
	
	public int setPlayerYPosition (int height) {
		return height - SIZE;
	}

	

}
