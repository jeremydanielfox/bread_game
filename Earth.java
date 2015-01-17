import javafx.scene.image.Image;
import javafx.scene.paint.Color;


public class Earth extends GameObject {
	Image img = new Image("Images/earth.jpg");
	static final int EARTH_SPEED = 1;
	Earth(int width, int height) {
		setSpeedSizeImageXY(EARTH_SPEED,height,img,width/2,-height);
	}

}
