import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class Player extends GameObject {
	Image img = new Image("Images/myPlayer.jpg");
	Player() {
		setSpeedSizeImageXY(20,50,img,250,480);
	}

	Player(int XPosition,int YPosition) {
		setSpeedSizeImageXY(20,50,img,setPlayerXPosition(XPosition),setPlayerYPosition(YPosition));
		setCenterY(setPlayerYPosition(YPosition));
	}


	public int setPlayerXPosition (int width) {
		return width/2;
	}

	public int setPlayerYPosition (int height) {
		return height - getSize();
	}



}
