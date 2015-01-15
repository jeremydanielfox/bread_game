import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class GameSection {
	private static final int NUM_FRAMES_PER_SECOND = 60;
	private Group myRoot;
	private Scene myScene;

	public void setup(Stage stage) {
		myScene= this.init(stage, 500, 500);
		stage.setScene(myScene);
		stage.show();
	}

	public Scene init(Stage s, int width, int height) {
		return null;
	}

	public void startAnimation(KeyFrame frame) {
		//KeyFrame frame = myGame.start(NUM_FRAMES_PER_SECOND);
		Timeline animation = new Timeline();
		animation.setCycleCount(Animation.INDEFINITE);
		animation.getKeyFrames().add(frame);
		animation.play();
	}
	
	public Group getGroup() {
		return myRoot;
	}
	
	public Scene getScene() {
		return myScene;
	}
}
