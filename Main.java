import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
	private static final int NUM_FRAMES_PER_SECOND = 60;
	private BreadFirstSearch myGame;

	/**
	 * Set things up at the beginning
	 */
	@Override
	public void start(Stage stage) {
		stage.setTitle("Bread First Search");
		//create the game
		myGame = new BreadFirstSearch();
		Scene scene = myGame.init(stage, 500, 500);
		stage.setScene(scene);
		stage.show();
		
		//setup the game's loop
		KeyFrame frame = myGame.start(NUM_FRAMES_PER_SECOND);
		Timeline animation = new Timeline();
        animation.setCycleCount(Animation.INDEFINITE);
        animation.getKeyFrames().add(frame);
        animation.play();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
