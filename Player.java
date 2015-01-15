import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class Player extends GameObject {
	Image img = new Image("Images/myPlayer.jpg");
	Player() {
		setSize(50);
		setSpeed(20);
		setImage(img);

		setupImage();
		setCenterX(250);
		setCenterY(480);
		
	}
	
	Player(int XPosition,int YPosition) {
		setSize(50);
		setSpeed(20);
		setImage(img);
		setupImage();
		setCenterX(setPlayerXPosition(XPosition));
		setCenterY(setPlayerYPosition(YPosition));
	}
	
	
	public int setPlayerXPosition (int width) {
		return width/2;
	}
	
	public int setPlayerYPosition (int height) {
		return height - getSize();
	}

	

}
