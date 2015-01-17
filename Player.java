import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class Player extends GameObject {
	private Image img = new Image("Images/myPlayer.jpg");
	static final int PLAYER_SPEED = 20;
	static final int PLAYER_SIZE = 50;
	static final int PLAYER_START_X = 250;
	static final int PLAYER_START_Y = 480;
	Player() {
		setSpeedSizeImageXY(PLAYER_SPEED,PLAYER_SIZE,img,PLAYER_START_X,PLAYER_START_Y);
	}

	Player(int XPosition,int YPosition) {
		setSpeedSizeImageXY(PLAYER_SPEED,PLAYER_SIZE,img,setPlayerXPosition(XPosition),setPlayerYPosition(YPosition));
		setCenterY(setPlayerYPosition(YPosition));
	}


	public int setPlayerXPosition (int width) {
		return width/2;
	}

	public int setPlayerYPosition (int height) {
		return height - getSize();
	}



}
