import javafx.animation.KeyFrame;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Menu extends GameSection {
	private static final int NUM_FRAMES_PER_SECOND = 60;
	private Group myRoot;
//	Menu() {
//		Text myLabel = new Text(50,50,"test");
//		//myLabel.setLayoutX(100);
//
//
//
//	}
	@Override
	public Scene init(Stage s, int width, int height) {
		myRoot = this.getGroup();
		Scene myScene = new Scene(myRoot, width, height, Color.BLACK);
		Button btn = new Button();
		btn.setText("Click if you are Bready");
		btn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				setup(s);
				LevelOne one = new LevelOne();
				KeyFrame frame = one.start(NUM_FRAMES_PER_SECOND);
				startAnimation(frame);

			}
		});
		myRoot.getChildren().add(btn);
		return myScene;

	}
}
