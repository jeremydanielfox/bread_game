import javafx.scene.image.Image;
import javafx.scene.paint.Color;


public class Earth extends GameObject {
	Image img = new Image("Images/earth.jpg");
	Earth(int width, int height) {
		setSpeedSizeImageXY(3,height,img,width/2,-height);
	}

}
